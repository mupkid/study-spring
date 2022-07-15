package org.ohx.springbootfiledemo.basemodule.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("file")
public class FileDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    //URL地址
    private String uri;
    //创建时间
    private Date createDate;


}
