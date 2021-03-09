package org.example.process.action;

import org.example.alert.Alert;

import java.util.Map;
import com.alibaba.fastjson.JSON;
import org.example.alert.AlertField;

/**
 * 默认的告警处理类
 */
public class SyslogAction implements IAlertAction{

    @Override
    public Alert execute(Alert alert, Map<String, Object> context) {

        System.out.println(String.format("<syslog动作>:  告警id: %d, 告警名称: %s, 告警等级: %d, cntext: %s",
                alert.getValue(AlertField.ID),
                alert.getValue(AlertField.NAME),
                alert.getValue(AlertField.SEVERITY),
                JSON.toJSONString(context)));

        return alert;
    }

    @Override
    public String getName() {
        return "action-syslog";
    }
}
