package org.example.process.action;

import com.alibaba.fastjson.JSON;
import org.example.alert.Alert;
import org.example.alert.AlertField;
import org.jeasy.rules.api.Rule;

import java.util.Map;

public class MergeAction implements IAlertAction{
    @Override
    public Alert execute(Alert alert, String context) {
        System.out.println(String.format("<告警合并>:  告警id: %d, 告警名称: %s, 告警等级: %d\n\t- context: %s",
                alert.getValue(AlertField.ID),
                alert.getValue(AlertField.NAME),
                alert.getValue(AlertField.SEVERITY),
                context));
        return alert;
    }

    @Override
    public String getName() {
        return "action-merge";
    }

}
