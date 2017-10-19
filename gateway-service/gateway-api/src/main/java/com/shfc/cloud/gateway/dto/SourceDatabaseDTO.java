package com.shfc.cloud.gateway.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/28 15:03
 * @since 1.0
 */
@Data
@Getter
@Setter
public class SourceDatabaseDTO implements Serializable {
    private static final long serialVersionUID = 6856200774811403442L;
    private String channelNo;
    private long merchantId;
    private String name;
    private String dbName;
    private String tableName;
    private String columnNames;
    private List dataList;
    private String where;
}
