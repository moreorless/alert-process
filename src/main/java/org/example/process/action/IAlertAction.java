package org.example.process.action;

import org.example.alert.Alert;
import org.jeasy.rules.api.Rule;

import java.util.Map;

public interface IAlertAction {
    /**
     * 执行告警动作
     * @param alert  告警对象
     * @param context
     * @return
     */
    public Alert execute(Alert alert, String context);

    public String getName();
}
