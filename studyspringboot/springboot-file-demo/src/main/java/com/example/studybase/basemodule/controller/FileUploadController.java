package com.example.studybase.basemodule.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.studybase.utils.R;
import com.example.studybase.basemodule.service.FileService;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/file")
@Api("文件上传api")  //@Api：用在类上，说明该类的作用
public class FileUploadController {

    @Autowired
    FileService fileService;

    @ApiOperation("上传MultipartFile类文件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "file", dataType = "file", required = true, value = "文件")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "文件错误"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @PostMapping("/uploadfile")
    public R uploadFile(@RequestBody MultipartFile file) {
        if (file.isEmpty()) {
            return R.error("文件为空");
        }

        if (fileService.uploadFile(file)) {
            return R.ok("上传成功");
        } else {
            return R.error("上传失败");
        }
    }

    @ApiOperation("上传Base64编码后文件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "param", dataType = "string", required = true, value = "文件")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "文件错误"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @PostMapping("/uploadencodefile")
    public R uploadEncodeFile(@RequestBody String param) {
        JSONObject params = JSON.parseObject(param);

        //jdk8使用map.forEach方法遍历map
//        params.forEach((key, value) -> {
//            if (key.matches("^file\\d*$")) {
//                if (StringUtils.isBlank((String) value)) {
//                    return R.error("文件为空");
//                }
//            }
//        });

        //遍历map使用entrySet()不用keySet()
        for (Map.Entry<String, Object> entrySet : params.entrySet()) {
            if (entrySet.getKey().matches("^file\\d*$")) {
                if (StringUtils.isBlank((String) entrySet.getValue())) {
                    return R.error("文件为空");
                }
            }
        }

        if (fileService.uploadFile(params)) {
            return R.ok("上传成功");
        } else {
            return R.error("上传失败");
        }
    }

}
