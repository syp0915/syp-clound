package com.shfc.cloud.gateway.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/23 10:02
 * @since 1.0
 */
@Data
public class SensitiveWebDTO implements Serializable {
    private static final long serialVersionUID = -4972467696406238128L;
    @ApiModelProperty(value = "敏感词内容",required =true)
    private String sensitiveWord;
    private String id;

    public String getSensitiveWord() {
        return sensitiveWord;
    }

    public void setSensitiveWord(String sensitiveWord) {
        this.sensitiveWord = sensitiveWord;
    }
}
