package com.shfc.authentication.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

/**
 * Copyright: Copyright (c) 2016
 * Company:上海房产
 * XML转map
 *
 * @author wky
 * @version V1.0
 * @create 2017-03-09 11:05
 **/
public class XmlToMap {
    public static Map<String, Object> Dom2Map(String xml){
        Map<String, Object> map = new HashMap<String, Object>();
        Document doc= null;
        try {
            doc = DocumentHelper.parseText(xml);
            if(doc == null)
                return map;
            Element root = doc.getRootElement();
            for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
                Element e = (Element) iterator.next();
                List list = e.elements();
                if(list.size() > 0){
                    map.put(e.getName(), Dom2Map(e));
                }else
                    map.put(e.getName(), e.getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static Map Dom2Map(Element e){
        Map map = new HashMap();
        List list = e.elements();
        if(list.size() > 0){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if(iter.elements().size() > 0){
                    Map m = Dom2Map(iter);
                    if(map.get(iter.getName()) != null){
                        Object obj = map.get(iter.getName());
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if(obj.getClass().getName().equals("java.util.ArrayList")){
                            mapList = (List) obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    }else
                        map.put(iter.getName(), m);
                }
                else{
                    if(map.get(iter.getName()) != null){
                        Object obj = map.get(iter.getName());
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(iter.getText());
                        }
                        if(obj.getClass().getName().equals("java.util.ArrayList")){
                            mapList = (List) obj;
                            mapList.add(iter.getText());
                        }
                        map.put(iter.getName(), mapList);
                    }else
                        map.put(iter.getName(), iter.getText());
                }
            }
        }else
            map.put(e.getName(), e.getText());
        return map;
    }


}
