package xyz.hnnknk.deneb.agent.mini;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.Cpu;
import xyz.hnnknk.deneb.agent.mini.hardwares.DiskDrive;
import xyz.hnnknk.deneb.agent.mini.hardwares.Motherboard;
import xyz.hnnknk.deneb.agent.mini.tasks.CpuTask;
import xyz.hnnknk.deneb.agent.mini.tasks.DiskDriveTask;
import xyz.hnnknk.deneb.agent.mini.tasks.MotherboardTask;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private TreeView tree;

    TreeItem rootItem;

    @FXML
    public void handleSubmitButtonAction(ActionEvent actionEvent) {

        Motherboard mother = new Motherboard();
        DiskDrive drive = new DiskDrive();
        Cpu cpu = new Cpu();

        MotherboardTask mTask = new MotherboardTask(mother, tree);
        Thread t = new Thread(mTask);
        t.setDaemon(true);
        t.start();

        DiskDriveTask dTask = new DiskDriveTask(drive, tree);
        Thread t1 = new Thread(dTask);
        t1.setDaemon(true);
        t1.start();

        CpuTask cTask = new CpuTask(cpu, tree);
        Thread t2 = new Thread(cTask);
        t2.setDaemon(true);
        t2.start();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootItem = new TreeItem("Компоненты");
        rootItem.setExpanded(true);
        tree.setRoot(rootItem);
    }

    private void createTreeView() {

    }
}
