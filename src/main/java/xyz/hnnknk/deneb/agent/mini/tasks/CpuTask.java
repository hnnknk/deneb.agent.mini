package xyz.hnnknk.deneb.agent.mini.tasks;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.Cpu;
import xyz.hnnknk.deneb.agent.mini.wmic.WmiUtility;

import java.util.concurrent.TimeUnit;

public class CpuTask extends Task<Void> {

    private Cpu cpu;
    private WmiUtility wmiUtility;
    private TreeView tree;


    public CpuTask(Cpu cpu, TreeView tree) {
        this.cpu = cpu;
        wmiUtility = new WmiUtility();
        this.tree = tree;
    }

    @Override
    protected Void call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                cpu.setInfo(wmiUtility.getCpuInformation());

                TreeItem cpuItem = new TreeItem("Процессор");

                TreeItem cManufacturer = new TreeItem("Производитель: " + cpu.getManufacturer().getValue());
                TreeItem cModel = new TreeItem("Модель: " + cpu.getModel().getValue());
                TreeItem cSocket = new TreeItem("Сокет: " + cpu.getSocket().getValue());
                TreeItem cCores = new TreeItem("Количество ядер: " + cpu.getNumberOfCores().getValue());

                cpuItem.getChildren().addAll(cManufacturer, cModel, cSocket, cCores);
                cpuItem.setExpanded(true);
                tree.getRoot().getChildren().add(cpuItem);
            }
        });
        return null;
    }
}
