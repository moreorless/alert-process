package org.example.process.action;

import com.alibaba.fastjson.JSON;
import org.example.alert.Alert;
import org.example.alert.AlertField;

import java.util.Map;

public class MergeAction implements IAlertAction{
    @Override
    public Alert execute(Alert alert, Map<String, Object> context) {
        System.out.println(String.format("<告警合并>:  告警id: %d, 告警名称: %s, 告警等级: %d, cntext: %s",
                alert.getValue(AlertField.ID),
                alert.getValue(AlertField.NAME),
                alert.getValue(AlertField.SEVERITY),
                JSON.toJSONString(context)));
        return alert;
    }

    @Override
    public String getName() {
        return "action-merge";
    }

}
