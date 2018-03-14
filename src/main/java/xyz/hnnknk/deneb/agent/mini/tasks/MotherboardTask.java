package xyz.hnnknk.deneb.agent.mini.tasks;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.Motherboard;
import xyz.hnnknk.deneb.agent.mini.wmic.WmiUtility;

import java.util.concurrent.TimeUnit;

public class MotherboardTask extends Task<Void>{

    private Motherboard motherboard;
    private WmiUtility wmiUtility;
    private TreeView tree;


    public MotherboardTask(Motherboard motherboard, TreeView tree) {
        this.motherboard = motherboard;
        wmiUtility = new WmiUtility();
        this.tree = tree;
    }

    @Override
    protected Void call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                motherboard.setInfo(wmiUtility.getMotherboardInformation());

                TreeItem motherboardItem = new TreeItem("Материнская плата");

                TreeItem mManufacturer = new TreeItem("Производитель: " + motherboard.getManufacturer().getValue());
                TreeItem mModel = new TreeItem("Модель: " + motherboard.getModel().getValue());
                TreeItem mSocket = new TreeItem("Сокет: " + motherboard.getSocket().getValue());

                motherboardItem.getChildren().addAll(mManufacturer, mModel, mSocket);
                motherboardItem.setExpanded(true);
                tree.getRoot().getChildren().add(motherboardItem);
            }
        });
        return null;
    }
}
