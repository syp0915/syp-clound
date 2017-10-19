package com.shfc.cloud.gateway.service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.shfc.cloud.gateway.domain.SourceDataInfo;
import com.shfc.cloud.gateway.dto.SourceDatabaseDTO;
import com.shfc.cloud.gateway.manager.GatewayDbManager;
import com.shfc.common.result.ResultDO;
import com.shfc.log.LogFileUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/28 14:30
 * @since 1.0
 */
@Service
@Slf4j
public class GatewayDbServiceImpl implements GatewayDbService {
    @Resource
    private GatewayDbManager gatewayDbManager;
    LogFileUtils logFileUtils = LogFileUtils.getInstance("gateway-service");
    @Override
    public ResultDO select(SourceDatabaseDTO sourceDatabaseDto) {
        long startTime=System.currentTimeMillis();
        ResultDO resultDO=new ResultDO();
        SourceDataInfo SourceDataInfo=gatewayDbManager.select(sourceDatabaseDto);
        resultDO.setData(SourceDataInfo);
        resultDO.setSuccess(true);
        logFileUtils.info("网关模块",sourceDatabaseDto.getMerchantId(),sourceDatabaseDto.getChannelNo(),GatewayAuthServiceImpl.class,"select",startTime);
        return resultDO;
    }

    @Override
    public ResultDO insert(SourceDatabaseDTO sourceBaseDto, ResultDO result) {
        log.info("传入参数 sourceBaseDto:{}",sourceBaseDto.toString());
        log.info("传入参数result:{}",result);
        ResultDO resp=new ResultDO();
        //获取conn
        Connection conn=getConnection( result,sourceBaseDto);
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement pstmt;
        int k=0;
        String []cloumnNames=sourceBaseDto.getColumnNames().split(";");
        //*****拼接sql*****/
        StringBuffer sql=  getInsertSql(sourceBaseDto);
        /*******处理表数据dataList*******/
        log.info("dataList:{}",sourceBaseDto.getDataList());
        List<String> dataList=sourceBaseDto.getDataList();
        if(dataList==null){
            resp.setErrMsg("数据列表为空!");
            resp.setSuccess(false);
            return resp;
        }
        JSONArray jsonArr = JSONArray.fromObject(dataList);
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql.toString());
            for(int n=0;n<jsonArr.size();n++){
                for(int i=0;i<cloumnNames.length;i++){
                    pstmt.setString(i+1,jsonArr.getJSONObject(n).get(cloumnNames[i]).toString());
                }
                k = pstmt.executeUpdate();
                //数据插入失败就回滚
                if(k==0){
                    resp.setSuccess(false);
                    conn.rollback();
                    return resp;
                }
            }
            conn.commit();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 网管数据修改
     * @param sourceBaseDto
     * @param result
     * @return
     */
    @Override
    public ResultDO update(SourceDatabaseDTO sourceBaseDto, ResultDO result) {
        ResultDO resp=new ResultDO();
        /**获取conn***/
        Connection conn=getConnection( result,sourceBaseDto);
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement pstmt;
        int k=0;
        String []cloumnNames=sourceBaseDto.getColumnNames().split(";");
        String []where=sourceBaseDto.getWhere().split(";");
        //*****拼接sql*****/
        StringBuffer sql=getUpdateSql(sourceBaseDto);
        /*******处理表数据dataList*******/
        List dataList=sourceBaseDto.getDataList();
        if(dataList==null){
            resp.setErrMsg("数据列表为空");
            resp.setSuccess(false);
            return resp;
        }
        JSONArray jsonArr = JSONArray.fromObject(dataList);

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql.toString());
            for(int n=0;n<jsonArr.size();n++){
                for(int i=0;i<cloumnNames.length;i++){
                 pstmt.setString(i+1,jsonArr.getJSONObject(n).get(cloumnNames[i]).toString());
                }
                for(int i=0;i<where.length;i++){
                    pstmt.setString(cloumnNames.length+1,jsonArr.getJSONObject(n).get(where[i]).toString());
                }
                k = pstmt.executeUpdate();
                conn.commit();
                if(k==0){
                    resp.setSuccess(false);
                    conn.rollback();
                    return resp;
                }
            }
            pstmt.close();
            conn.close();
            resp.setSuccess(true);
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {

                e1.printStackTrace();
            }
            e.printStackTrace();
            resp.setSuccess(false);
        }

        return resp;
    }

    @Override
    public ResultDO delete(SourceDatabaseDTO sourceBaseDto, ResultDO result) {
        ResultDO resp=new ResultDO();
        Connection conn=getConnection( result,sourceBaseDto);
        PreparedStatement pstmt;
        int k=0;
      //  String []cloumnNames=sourceBaseDto.getColumnNames().split(";");
        String []where=sourceBaseDto.getWhere().split(";");
        //*****拼接sql*****/
        StringBuffer sql=getDelSql(sourceBaseDto);
        /*******处理表数据dataList*******/
        List dataList=sourceBaseDto.getDataList();
        if(dataList==null){
            resp.setErrMsg("数据列表为空");
            resp.setSuccess(false);
            return resp;
        }
        JSONArray jsonArr = JSONArray.fromObject(dataList);

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql.toString());
            for(int n=0;n<jsonArr.size();n++){
           /*     for(int i=0;i<cloumnNames.length;i++){
                    pstmt.setString(i+1,jsonArr.getJSONObject(n).get(cloumnNames[i]).toString());
                }*/
                for(int i=0;i<where.length;i++){
                    pstmt.setString(i+1,jsonArr.getJSONObject(n).get(where[i]).toString());
                }
                k = pstmt.executeUpdate();
                if(k==0){
                    resp.setSuccess(false);
                    return resp;
                }
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 查询
     * @param sourceBaseDto
     * @param result
     * @return
     */
    @Override
    public ResultDO selectData(SourceDatabaseDTO sourceBaseDto, ResultDO result) {
        ResultDO resp=new ResultDO();
        Connection conn=getConnection( result,sourceBaseDto);
        PreparedStatement pstmt;
        int k=0;
        //  String []cloumnNames=sourceBaseDto.getColumnNames().split(";");
        String []where=sourceBaseDto.getWhere().split(";");
        //*****拼接sql*****/
        StringBuffer sql=getSelectSql(sourceBaseDto);
        /*******处理表数据dataList*******/
        List dataList=sourceBaseDto.getDataList();
        if(dataList==null){
            resp.setErrMsg("数据列表为空");
            resp.setSuccess(false);
            return resp;
        }
        JSONArray jsonArr = JSONArray.fromObject(dataList);

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql.toString());
            for(int n=0;n<jsonArr.size();n++){
           /*     for(int i=0;i<cloumnNames.length;i++){
                    pstmt.setString(i+1,jsonArr.getJSONObject(n).get(cloumnNames[i]).toString());
                }*/
                for(int i=0;i<where.length;i++){
                    pstmt.setString(i+1,jsonArr.getJSONObject(n).get(where[i]).toString());
                }
                k = pstmt.executeUpdate();
                if(k==0){
                    resp.setSuccess(false);
                    return resp;
                }
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 获取conn
     * @param result
     * @param sourceBaseDto
     * @return
     */
    public Connection getConnection(ResultDO result,SourceDatabaseDTO sourceBaseDto){
        String ip=((HashMap)result.getData()).get("ip").toString();
        String url="jdbc:mysql://"+ip+":3306/"+sourceBaseDto.getDbName();
        String user=((HashMap)result.getData()).get("user").toString();
        String password=((HashMap)result.getData()).get("password").toString();
        Connection conn = null;
        String name = "com.mysql.jdbc.Driver";
        try {
            Class.forName(name);//指定连接类型
            conn = (Connection) DriverManager.getConnection(url, user, password);//获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 数据插入sql拼接
     * @param sourceBaseDto
     * @return
     */
    public StringBuffer getInsertSql(SourceDatabaseDTO sourceBaseDto){
        String []cloumnNames=sourceBaseDto.getColumnNames().split(";");
        StringBuffer sql=new StringBuffer();
         sql.append("insert into ").append(sourceBaseDto.getTableName()).append("(");
        for(int i=0;i<cloumnNames.length;i++){
            if ((i==cloumnNames.length-1)){
                sql.append(cloumnNames[i]);
            }else{
                sql.append(cloumnNames[i]).append(",");
            }
        }
        sql.append(") values(");
        for(int i=0;i<cloumnNames.length;i++){
            if ((i==cloumnNames.length-1)){
                sql.append("?");
            }else{
                sql.append("?,");
            }
        }
        sql.append(")");
        return sql;
    }

    /**
     * 数据修改sql拼接
     * @param sourceBaseDto
     * @return
     */
    public StringBuffer getUpdateSql(SourceDatabaseDTO sourceBaseDto){
        String []cloumnNames=sourceBaseDto.getColumnNames().split(";");
        StringBuffer sql=new StringBuffer();
         sql.append("update ").append(sourceBaseDto.getTableName()).append(" set ");
        String []where=sourceBaseDto.getWhere().split(";");
        for(int i=0;i<cloumnNames.length;i++){
            if ((i==cloumnNames.length-1)){
                sql.append(cloumnNames[i]).append("= ? ");
            }else{
                sql.append(cloumnNames[i]).append("= ? ,");
            }
        }
        sql.append(" where ");
        for(int i=0;i<where.length;i++){
            if(i==where.length-1){
                sql.append(where[i]).append("= ?");
            }else{
                sql.append(where[i]).append("= ?  and");
            }
        }
        return sql;
    }
    /**
     * 数据查询sql拼接
     * @param sourceBaseDto
     * @return
     */
    public StringBuffer getSelectSql(SourceDatabaseDTO sourceBaseDto){
        String []cloumnNames=sourceBaseDto.getColumnNames().split(";");
        StringBuffer sql=new StringBuffer();
        sql.append("select ");
        String []where=sourceBaseDto.getWhere().split(";");
        for(int i=0;i<cloumnNames.length;i++){
            if ((i==cloumnNames.length-1)){
                sql.append(cloumnNames[i]);
            }else{
                sql.append(cloumnNames[i]).append(",");
            }
        }
        sql.append(" from").append(sourceBaseDto.getTableName());
        sql.append(" where ");
        for(int i=0;i<where.length;i++){
            if(i==where.length-1){
                sql.append(where[i]).append("= ?");
            }else{
                sql.append(where[i]).append("= ?  and");
            }
        }
        return sql;
    }


    /**
     * 数据删除sql拼接
     * @param sourceBaseDto
     * @return
     */
    public StringBuffer getDelSql(SourceDatabaseDTO sourceBaseDto){
        String []where=sourceBaseDto.getWhere().split(";");
        StringBuffer sql=new StringBuffer();
         sql.append("delete from ").append(sourceBaseDto.getTableName());
        sql.append(" where ");
        for(int i=0;i<where.length;i++){
            if(i==where.length-1){
                sql.append(where[i]).append("= ?");
            }else{
                sql.append(where[i]).append("= ?  and");
            }
        }
        return sql;
    }



}
