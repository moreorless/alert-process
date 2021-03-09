package org.example.process.action;

import org.example.alert.Alert;
import org.jeasy.rules.api.Rule;

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
     * @param actionId  执行机构id，如"action-syslog / action-merge"
     * @param alert
     * @param actionContext
     *
     */
    public void executionAction(Alert alert, String actionId, String actionContext){
        if (!alertActionMap.containsKey(actionId)){
            System.err.println("没有找到动作执行器");
            return;
        }
        alertActionMap.get(actionId).execute(alert, actionContext);
    }
}
