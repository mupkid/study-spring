package org.ohx.springbootfiledemo.basemodule.service;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ohx.springbootfiledemo.basemodule.entity.FileDO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService extends IService<FileDO> {

    boolean uploadFile(MultipartFile file);

    /**
     * 上传base64编码后的文件到本地
     * @param params
     * @return
     */
    boolean uploadFile(JSONObject params);
}
