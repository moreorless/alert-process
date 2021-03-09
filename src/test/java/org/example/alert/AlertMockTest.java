package org.example.alert;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class AlertMockTest {

    private AlertMock alertMock = new AlertMock();

    @Test
    public void getAlerts(){
        List<Alert> alertList = alertMock.getAlerts();
        System.out.println(JSON.toJSONString(alertList));
        assertEquals(alertList.size(), 6);
        assertEquals(alertList.get(0).getValue(AlertField.ID), 1);
    }
}