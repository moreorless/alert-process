package org.example.process.action;

import org.example.alert.Alert;

import java.util.Map;

public interface IAlertAction {
    /**
     * 执行告警动作
     * @param alert  告警对象
     * @param context  上下文参数
     * @return
     */
    public Alert execute(Alert alert, Map<String, Object> context);

    public String getName();
}
