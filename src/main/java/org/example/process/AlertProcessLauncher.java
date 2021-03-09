package org.example.process;

import org.example.alert.Alert;
import org.example.alert.AlertMock;

import java.util.List;

public class AlertProcessLauncher {



    public void run(){
        AlertProcessImpl alertProcess = new AlertProcessImpl();

        List<Alert> alertList = new AlertMock().getAlerts();
        alertList.forEach(alert -> {
            alertProcess.process(alert);
        });

    }

    public static void main(String[] args){
        AlertProcessLauncher launcher = new AlertProcessLauncher();
        launcher.run();
    }

}
