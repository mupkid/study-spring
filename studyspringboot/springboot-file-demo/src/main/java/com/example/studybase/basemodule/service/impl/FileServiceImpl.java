package com.example.studybase.basemodule.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.studybase.basemodule.dao.FileDao;
import com.example.studybase.basemodule.entity.FileDO;
import com.example.studybase.basemodule.service.FileService;
import org.apache.shiro.codec.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class FileServiceImpl extends ServiceImpl<FileDao, FileDO> implements FileService {

    @Value("${web.upload-path}")
    String path;

    private static final Logger LOG = LoggerFactory.getLogger(FileService.class);
    /**
     * 利用好Patter预编译功能，可以有效加快正则匹配速度，避免创建过多Patter对象
     */
    private static final Pattern PATTERN = Pattern.compile("^file\\d*$");

    @Override
    public boolean uploadFile(MultipartFile uploadFile) {
        String fileName = uploadFile.getOriginalFilename();

        try {
            File file = new File(path + fileName);
            uploadFile.transferTo(file);

            //保存文件上传信息到数据库
            FileDO fileDO = new FileDO();
            fileDO.setUri(file.getAbsolutePath());
            fileDO.setCreateDate(new Date());
            save(fileDO);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean uploadFile(JSONObject params) {
//        params.forEach((key,encodeFile)->{
//            if (key.matches("^file\\d*$")){
//                StringBuilder sb = new StringBuilder(key);
//                sb.insert(4, "name");
//                String fileName = params.getString(sb.toString());
//                if (!upload((String) encodeFile, fileName)) {
//                    return false;
//                }
//            }
//        });

        for (Map.Entry<String, Object> entrySet: params.entrySet()) {
            if (PATTERN.matcher(entrySet.getKey()).matches()) {
                StringBuilder sb = new StringBuilder(entrySet.getKey());
                sb.insert(4, "name");
                String fileName = params.getString(sb.toString());
                if (!upload((String)entrySet.getValue(), fileName)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean upload(String encodeFile, String fileName) {
        List<String> fileList = getFile(path, 0);
        if(fileList.contains(fileName)){
            fileName = checkFileName(fileList, fileName, 1);
        }

        //解码文件，使用Shiro的Base64类
        byte[] decodeFile = Base64.decode(encodeFile);
        File file = new File(path, fileName);

        try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            out.write(decodeFile);

            //保存文件上传信息到数据库
            FileDO fileDO = new FileDO();
            fileDO.setUri(file.getAbsolutePath());
            fileDO.setCreateDate(new Date());
            save(fileDO);

            //在日志输出时，字符串变量之间的拼接使用占位符的方式
            LOG.info("上传的文件为： \"{}\" 上传状态：成功",fileName);
            return true;
        } catch (IOException e) {
            LOG.error("上传的文件为： \"{}\" 上传状态：失败",fileName);
            LOG.error("_"+e.getMessage(),e);
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获得路径下的所有文件名
     * @param path 需要遍历的路径
     * @return 路径下文件的名称集合
     */
    private static ArrayList<String> getFile(String path, int deep) {
        // 获得指定文件对象
        File file = new File(path);
        // 获得该文件夹内的所有文件
        File[] array = file.listFiles();
        ArrayList<String> list = new ArrayList<String>();
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                //如果是文件
//                for (int j = 0; j < deep; j++) {
//                    //输出前置空格
//                    System.out.print(" ");
//                }
                // 只输出文件名字
                list.add(array[i].getName());
            }
        }
        return list;
    }

    /**
     * 已知存在重名文件，修改新文件的文件名
     * @param fileList 文件下文件名的集合
     * @param fileName 存入的文件名
     * @param index    索引的开始位置
     * @return 符合要求的文件名
     */
    private static String checkFileName(List<String> fileList, String fileName, int index) {
        String newFileName = fileName.substring(0, fileName.indexOf(".")) + "(" + index + ")" + fileName.substring(fileName.indexOf("."));
        if (fileList.contains(newFileName)) {
            return checkFileName(fileList, fileName, index + 1);
        } else {
            return newFileName;
        }
    }

}
