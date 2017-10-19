package com.shfc.cloud.gateway.service;

import com.fc.common.redis.RedisUtil;
import com.shfc.cloud.gateway.constant.ErrorConstant;
import com.shfc.cloud.gateway.domain.SensitiveWord;
import com.shfc.cloud.gateway.dto.SensitiveDTO;
import com.shfc.cloud.gateway.manager.SensitiveManager;
import com.shfc.common.result.ResultDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 类注释
 *
 * @author zhangjh
 * @version 1.0.0 createTime: 2017/3/23 14:13
 * @since 1.0
 */
@Service
public class SensitiveServiceImpl implements SensitiveService {
    @Resource
    private SensitiveManager sensitiveManager;
    public HashMap sensitiveWordMap;
    @Override
    public ResultDO insert(SensitiveDTO sensitiveDTO) {
        ResultDO resultDO=new ResultDO();
        try{
            if(sensitiveManager.insert(sensitiveDTO)){
                resultDO.setSuccess(true);
                reflashCache();
            }else{
                resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
                resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
                resultDO.setSuccess(false);
                return resultDO;
            }
        }catch(Exception e){
            resultDO.setErrCode(ErrorConstant.UNKNOWN_ERROR.getCode());
            resultDO.setErrMsg(ErrorConstant.UNKNOWN_ERROR.getMsg());
            e.printStackTrace();
            return resultDO;
        }

        return resultDO;
    }

    @Override
    public ResultDO select(String sensitiveWord) {
        ResultDO resultDO=new ResultDO();
        try{
        List<SensitiveWord> list =sensitiveManager.select(sensitiveWord);
        resultDO.setData(list);
        resultDO.setSuccess(true);
        }catch(Exception e){
            resultDO.setErrCode(ErrorConstant.UNKNOWN_ERROR.getCode());
            resultDO.setErrMsg(ErrorConstant.UNKNOWN_ERROR.getMsg());
            e.printStackTrace();
            return resultDO;
        }

        return resultDO;
    }

    @Override
    public ResultDO delete(String id) {
        ResultDO resultDO=new ResultDO();
        SensitiveWord sensitiveWord=new SensitiveWord();
        sensitiveWord.setId(Long.parseLong(id));
        sensitiveWord.setStatus("1");
        try{
        if(sensitiveManager.update(sensitiveWord)){
            reflashCache();
            resultDO.setSuccess(true);
        }else{
            resultDO.setErrCode(ErrorConstant.DATABASE_ERROR_OCCURRED.getCode());
            resultDO.setErrMsg(ErrorConstant.DATABASE_ERROR_OCCURRED.getMsg());
            resultDO.setSuccess(false);
            return resultDO;
        }
        }catch(Exception e){
            resultDO.setErrCode(ErrorConstant.UNKNOWN_ERROR.getCode());
            resultDO.setErrMsg(ErrorConstant.UNKNOWN_ERROR.getMsg());
            e.printStackTrace();
            return resultDO;
        }
        return resultDO;
    }


    public void reflashCache(){
        String sensitiveWord="";
        List<SensitiveWord> list =sensitiveManager.select(sensitiveWord);
        Set<String> set = null;
        set = new HashSet<String>();
        for(SensitiveWord s:list){
            set.add(s.getSensitiveWord());
            System.out.print(set.size());
        }
        //读取敏感词库
        Set<String> keyWordSet = set;
        //将敏感词库加入到HashMap中
        addSensitiveWordToHashMap(keyWordSet);
        RedisUtil.set("sensitiveWordMap",sensitiveWordMap);
    }

    /**
     * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型：<br>
     * 中 = {
     *      isEnd = 0
     *      国 = {<br>
     *      	 isEnd = 1
     *           人 = {isEnd = 0
     *                民 = {isEnd = 1}
     *                }
     *           男  = {
     *           	   isEnd = 0
     *           		人 = {
     *           			 isEnd = 1
     *           			}
     *           	}
     *           }
     *      }
     *  五 = {
     *      isEnd = 0
     *      星 = {
     *      	isEnd = 0
     *      	红 = {
     *              isEnd = 0
     *              旗 = {
     *                   isEnd = 1
     *                  }
     *              }
     *      	}
     *      }
     * @param keyWordSet  敏感词库
     * @version 1.0
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
         Map sensitiveWordMap = null;
        sensitiveWordMap = new HashMap(keyWordSet.size());     //初始化敏感词容器，减少扩容操作
        String key = null;
        Map nowMap = null;
        Map<String, String> newWorMap = null;
        //迭代keyWordSet
        Iterator<String> iterator = keyWordSet.iterator();
        while(iterator.hasNext()){
            key = iterator.next();    //关键字
            nowMap = sensitiveWordMap;
            for(int i = 0 ; i < key.length() ; i++){
                char keyChar = key.charAt(i);       //转换成char型
                Object wordMap = nowMap.get(keyChar);       //获取

                if(wordMap != null){        //如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                }
                else{     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<String,String>();
                    newWorMap.put("isEnd", "0");     //不是最后一个
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if(i == key.length() - 1){
                    nowMap.put("isEnd", "1");    //最后一个
                }
            }
        }
    }

}
