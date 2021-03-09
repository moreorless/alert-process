package org.example.process.action;

import org.example.alert.Alert;

import java.util.HashMap;
import java.util.Map;

public class AlertActionManager {

    private AlertActionManager(){
        init();
    }
    private static AlertActionManager _instance;
    public static AlertActionManager me(){
        if (_instance == null){
            _instance = new AlertActionManager();
        }
        return _instance;
    }


    private Map<String, IAlertAction> alertActionMap = new HashMap<>();

    public void init(){
        register(new MergeAction());
        register(new SyslogAction());
    }

    public void register(IAlertAction alertAction){
        alertActionMap.put(alertAction.getName(), alertAction);
    }

    /**
     * 执行告警动作
     * @param actuator  执行机构id，如"action-syslog / action-merge"
     * @param alert
     * @param context
     */
    public void executionAction(String actuator, Alert alert, Map<String, Object> context){
        if (!alertActionMap.containsKey(actuator)){
            System.err.println("没有找到动作执行器");
            return;
        }
        alertActionMap.get(actuator).execute(alert, context);
    }
}
