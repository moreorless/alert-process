package org.example.alert;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Alert implements Serializable {

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }

    private Map<String, Object> fields = new HashMap<>();

    public boolean contains(String filedName){
        return fields.containsKey(filedName);
    }

    public void setFiled(String filedName, Object fieldValue){
        fields.put(filedName, fieldValue);
    }

    public Object getValue(String filedName){
        return fields.get(filedName);
    }

    @Override
    public String toString(){
        return JSON.toJSONString(fields);
    }
}
