package org.example.process;

import org.example.alert.Alert;
import org.example.process.action.AlertActionManager;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 告警处理实现类
 */
public class AlertProcessImpl implements IAlertProcess{

    private Rules rules = new Rules();
    private RulesEngine rulesEngine = new DefaultRulesEngine();

    private int counter = 1;

    public AlertProcessImpl(){
        init();
    }

    /**
     * 初始化
     * 1. 注册规则
     */
    public void init(){
        registerRules();
    }


    public void registerRules(){
        try{
            MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
            // 加载两个告警规则
            String[] fileNames = new String[]{
                    "rule/alert-rule-1.yml",
                    "rule/alert-rule-2.yml"};
            ClassLoader classLoader = getClass().getClassLoader();

            for (String fileName : fileNames){
                File file = new File(classLoader.getResource(fileName).getFile());
                Rule alertRule = ruleFactory.createRule(new FileReader(file));
                rules.register(alertRule);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 处理告警
     * @param alert
     */
    @Override
    public void process(Alert alert) {
        // 模拟context
        Map<String, Object> context = new HashMap<>();
        context.put("counter", getCounter());

        // 添加Facts
        Facts facts = new Facts();
        facts.put("alert", alert);
        facts.put("alertActionManager", AlertActionManager.me());
        facts.put("context", context);

        // 触发规则
        rulesEngine.fire(rules, facts);

    }

    private synchronized int getCounter(){
        return counter++;
    }
}
