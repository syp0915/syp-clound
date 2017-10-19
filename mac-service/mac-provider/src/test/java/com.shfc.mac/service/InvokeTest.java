package com.shfc.mac.service;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Colin Yan on 2017/5/23.
 */
public class InvokeTest extends InvokeBase {
  private final String baseUrl = "http://assess-basicservice.sit1.of.com:8080";
    // private final String baseUrl = "http://localhost:8086";
// private final String baseUrl = "http://192.168.0.172:8086";
    //     private final String baseUrl = "http://192.168.201.17:8082";

    private final String signType = "01";
    private final String version = "V2.0.0";

    private final String appId = "20001";
    private final String appSecret = "dhuicn_c!#9j*#@10k,3d913fm";


    @Test
    public void testMacDetail() throws IOException {
        String url = baseUrl + "/mac/detail/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mac","00196843AC17");
       // MacParam macParam = new MacParam();
       // macParam.setMac("00196843AC17");
        String params = JSONObject.toJSONString(paramMap);

        //final String params = JSON.toJSONString(macParam);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));
        System.out.println("params====="+params);
        System.out.println(param);
        String retSrc = post(url, param);

        System.out.println(retSrc);
    }

  /*  @Test
    public void testgetCustomerInfoByMac() throws IOException {
        String url = baseUrl + "/ocn/clientDetail/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        MacParam macParam = new MacParam();
        macParam.setMac("00034C902AB7");

        final String params = JSON.toJSONString(macParam);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));

        String retSrc = post(url, param);

        System.out.println(retSrc);
    }






    @Test
    public void estimate() throws IOException {
        String url = baseUrl + "/estimate/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        HouseAssessParm houseAssessParm = new HouseAssessParm();

        houseAssessParm.setResidenceId(821);
        houseAssessParm.setPropertyTypeId(3);
        houseAssessParm.setPlaceFloor(7);
        houseAssessParm.setTotalFloor(7);
        houseAssessParm.setPropertyArea(70.0);
        houseAssessParm.setPlaneType(1);
        houseAssessParm.setBuildingNo("1");
        houseAssessParm.setRoomNo("101");
        houseAssessParm.setRoomNum(2);

        final String params = JSON.toJSONString(houseAssessParm);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));

        String retSrc = post(url, param);

        System.out.println(retSrc);
    }

    @Test
    public void estimateFollow() throws IOException {
        String url = baseUrl + "/estimateFollow/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        HouseAssessParm houseAssessParm = new HouseAssessParm();

        houseAssessParm.setResidenceId(821);
        houseAssessParm.setPropertyTypeId(3);
        houseAssessParm.setPlaceFloor(7);
        houseAssessParm.setTotalFloor(7);
        houseAssessParm.setPropertyArea(70.0);
        houseAssessParm.setPlaneType(1);
        houseAssessParm.setBuildingNo("1");
        houseAssessParm.setRoomNo("101");
        houseAssessParm.setRoomNum(2);

        final String params = JSON.toJSONString(houseAssessParm);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));

        String retSrc = post(url, param);

        System.out.println(retSrc);
    }



    @Test
    public void hint() throws IOException {
        String url = baseUrl + "/residence/hint/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        HintParam hintParam = new HintParam();

        hintParam.setKeyWord("小区");
        hintParam.setSize(1);

        final String params = JSON.toJSONString(hintParam);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));

        System.out.println(url);
        for (String key : param.keySet()) {
            System.out.println(key + "=" + param.get(key));
        }

        String retSrc = post(url, param);

        System.out.println(retSrc);
    }


    @Test
    public void building() throws IOException {
        String url = baseUrl + "/residence/building/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        Map<String, Object> postParams = new HashMap<String, Object>();

        postParams.put("residenceId", 1);

        final String params = JSON.toJSONString(postParams);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));

        System.out.println(url);
        for (String key : param.keySet()) {
            System.out.println(key + "=" + param.get(key));
        }

        String retSrc = post(url, param);

        System.out.println(retSrc);
    }

    @Test
    public void houseDetail() throws IOException {
        String url = baseUrl + "/houseDetail/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        Map<String, Object> postParams = new HashMap<String, Object>();

        postParams.put("houseId", 39);
        postParams.put("residenceId", 7277);
        postParams.put("houseAddress", "华泾路880弄53号602室");

        final String params = JSON.toJSONString(postParams);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));

        System.out.println(url);
        for (String key : param.keySet()) {
            System.out.println(key + "=" + param.get(key));
        }

        String retSrc = post(url, param);

        System.out.println(retSrc);
    }

    @Test
    public void district() throws IOException {
        String url = baseUrl + "/district/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        Map<String, Object> postParams = new HashMap<String, Object>();

        postParams.put("districtId", 310101);

        final String params = JSON.toJSONString(postParams);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));

        System.out.println(url);
        for (String key : param.keySet()) {
            System.out.println(key + "=" + param.get(key));
        }

        String retSrc = post(url, param);

        System.out.println(retSrc);
    }

    @Test
    public void block() throws IOException {
        String url = baseUrl + "/block/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        Map<String, Object> postParams = new HashMap<String, Object>();

        postParams.put("districtId", 310101);

        final String params = JSON.toJSONString(postParams);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));

        System.out.println(url);
        for (String key : param.keySet()) {
            System.out.println(key + "=" + param.get(key));
        }

        String retSrc = post(url, param);

        System.out.println(retSrc);
    }
    @Test
    public void school() throws IOException {
        String url = baseUrl + "/school/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        Map<String, Object> postParams = new HashMap<String, Object>();

        postParams.put("districtId", 310101);

        final String params = JSON.toJSONString(postParams);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));

        System.out.println(url);
        for (String key : param.keySet()) {
            System.out.println(key + "=" + param.get(key));
        }

        String retSrc = post(url, param);

        System.out.println(retSrc);
    }
    @Test
    public void residence_info() throws IOException {
        String url = baseUrl + "/residence/info/";

        Map<String, String> param = new HashMap<String, String>();

        param.put("signType", signType);
        param.put("version", version);
        param.put("appId", appId);

        Map<String, Object> postParams = new HashMap<String, Object>();

        postParams.put("residenceId", 21);

        final String params = JSON.toJSONString(postParams);
        param.put("params", params);
        param.put("signCode", sign(appId, version, signType, params, appSecret));

        System.out.println(url);
        for (String key : param.keySet()) {
            System.out.println(key + "=" + param.get(key));
        }

        String retSrc = post(url, param);

        System.out.println(retSrc);
    }
*/
}

