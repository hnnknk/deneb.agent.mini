package xyz.hnnknk.deneb.agent.mini.tasks;

import javafx.application.Platform;
import javafx.concurrent.Task;
import xyz.hnnknk.deneb.agent.mini.hardwares.Motherboard;
import xyz.hnnknk.deneb.agent.mini.wmic.WmiUtility;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MotherboardTask extends Task<Void>{

    private Motherboard motherboard;
    private WmiUtility wmiUtility;

    private ArrayList<String> motherboardData;

    public MotherboardTask(Motherboard motherboard) {
        this.motherboard = motherboard;
        wmiUtility = new WmiUtility();
        motherboardData = new ArrayList<>();
    }

    @Override
    protected Void call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                motherboard.setManufacturer(wmiUtility.getMotherboardInformation().get(0));
                motherboard.setManufacturer(wmiUtility.getCpuInformation().get(0));
                motherboard.setManufacturer(wmiUtility.getRamInformation().get(5));
                motherboard.setManufacturer(wmiUtility.getDiskDriveInformation().get(2));
            }
        });
        return null;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }
}
