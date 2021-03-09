package org.example.process;

import com.alibaba.fastjson.JSON;
import org.example.process.action.AlertActionManager;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.RuleListener;

/**
 * Created by gao_xiaoliang on 2021/3/9.
 */
public class ActionRuleListner implements RuleListener {

    /**
     * Triggered after a rule has been executed successfully.
     *
     * @param rule the current rule
     * @param facts known facts after executing the rule
     */
     public void onSuccess(Rule rule, Facts facts) {
         System.out.println(
                 String.format("\n++++\nActionRuleListner onSuccess \n --- \n rule-info: %s \n facts-info: %s\n++++\n",
                 JSON.toJSONString(rule),
                 JSON.toJSONString(facts.getFact("alert"))));

     }
}
