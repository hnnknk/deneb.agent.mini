package xyz.hnnknk.deneb.agent.mini;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.Cpu;
import xyz.hnnknk.deneb.agent.mini.hardwares.DiskDrive;
import xyz.hnnknk.deneb.agent.mini.hardwares.Motherboard;
import xyz.hnnknk.deneb.agent.mini.hardwares.Ram;
import xyz.hnnknk.deneb.agent.mini.tasks.CpuTask;
import xyz.hnnknk.deneb.agent.mini.tasks.DiskDriveTask;
import xyz.hnnknk.deneb.agent.mini.tasks.MotherboardTask;
import xyz.hnnknk.deneb.agent.mini.tasks.RamTask;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The JavaFx controller.
 */
public final class Controller implements Initializable {

    /**
     * Standard JavaFx TreeView.
     */
    @FXML private TreeView tree;

    /**
     * Handle submit button action.
     */
    @FXML
    public void handleSubmitButtonAction() {

        Motherboard mother = new Motherboard();
        DiskDrive drive = new DiskDrive();
        Cpu cpu = new Cpu();
        Ram ram = new Ram();

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

        RamTask rTask = new RamTask(ram, tree);
        Thread t3 = new Thread(rTask);
        t3.setDaemon(true);
        t3.start();
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        TreeItem rootItem = new TreeItem("Компоненты");
        rootItem.setExpanded(true);
        tree.setRoot(rootItem);
    }

}
