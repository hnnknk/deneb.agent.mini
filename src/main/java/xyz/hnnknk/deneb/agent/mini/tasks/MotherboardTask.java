package xyz.hnnknk.deneb.agent.mini.tasks;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.Motherboard;
import xyz.hnnknk.deneb.agent.mini.wmic.WmiUtility;

import java.util.concurrent.TimeUnit;

public class MotherboardTask extends Task<Void>{

    private final Motherboard motherboard;
    private final WmiUtility wmiUtility;
    private final TreeView tree;


    public MotherboardTask(Motherboard motherboard, TreeView tree) {
        this.motherboard = motherboard;
        wmiUtility = new WmiUtility();
        this.tree = tree;
    }

    @Override
    protected Void call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        Platform.runLater(() -> {
            motherboard.setInfo(wmiUtility.getMotherboardInformation());

            TreeItem<String> motherboardItem = new TreeItem<>("Материнская плата");

            TreeItem<String> mManufacturer = new TreeItem<>("Производитель: " + motherboard.getManufacturer());
            TreeItem<String> mModel = new TreeItem<>("Модель: " + motherboard.getModel());
            TreeItem<String> mSocket = new TreeItem<>("Сокет: " + motherboard.getSocket());

            motherboardItem.getChildren().addAll(mManufacturer, mModel, mSocket);
            motherboardItem.setExpanded(true);
            tree.getRoot().getChildren().add(motherboardItem);
        });
        return null;
    }
}
