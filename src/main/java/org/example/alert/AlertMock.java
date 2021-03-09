package org.example.alert;

import java.util.ArrayList;
import java.util.List;

public class AlertMock {

    public List<Alert> getAlerts(){

        List<Alert> alerts = new ArrayList<>();

        Object[][] data = new Object[][]{
                {1, "告警1", 2},
                {2, "告警2", 1},
                {3, "告警3", 1},
                {4, "告警4", 3},
                {5, "告警5", 4},
                {6, "告警6", 5}
        };

        for (int i = 0; i < data.length; i++){
            Object[] row = data[i];
            Alert alert = new Alert();
            alert.setFiled(AlertField.ID, row[0]);
            alert.setFiled(AlertField.NAME, row[1]);
            alert.setFiled(AlertField.SEVERITY, row[2]);
            alerts.add(alert);
        }
        return alerts;
    }
}
