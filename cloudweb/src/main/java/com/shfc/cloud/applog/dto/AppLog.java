package com.shfc.cloud.applog.dto;

import java.util.LinkedList;
import java.util.List;

/**
 * @Package com.shfc.cloud.applog.dto.AppLog
 * @Description: app log
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/27 15:18
 * version V1.0.0
 */
public class AppLog {
    /**
     * 文件或者目录名称
     */
    private String name;

    /**
     * 日期
     */
    private String date;

    /**
     * 大小
     */
    private String size;

    public AppLog(String name, String date, String size) {
        this.name = name;
        this.date = date;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 转换对象
     * @param dataArray
     * @return
     */
    public static List<AppLog>  convertArray(String[] dataArray){
        List<AppLog> list = null;
        if(dataArray != null && dataArray.length > 0){
            list = new LinkedList<>();
            for (int i = 0; i < dataArray.length; i++) {
                if(dataArray[i].contains("*")){
                    String[] data = dataArray[i].split("\\*");
                    list.add(new AppLog(data[0], data[1], data[2]));
                }else{
                    list.add(new AppLog(dataArray[i], "", ""));
                }
            }
        }

        return list;
    }
}
