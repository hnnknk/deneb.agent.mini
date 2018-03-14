package xyz.hnnknk.deneb.agent.mini.tasks;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.DiskDrive;
import xyz.hnnknk.deneb.agent.mini.wmic.WmiUtility;

import java.util.concurrent.TimeUnit;

public class DiskDriveTask extends Task<Void> {

    private DiskDrive diskDrive;
    private WmiUtility wmiUtility;
    private TreeView tree;

    public DiskDriveTask(DiskDrive diskDrive, TreeView tree) {
        this.diskDrive = diskDrive;
        wmiUtility = new WmiUtility();
        this.tree = tree;
    }

    @Override
    protected Void call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                diskDrive.setInfo(wmiUtility.getDiskDriveInformation());

                TreeItem diskDriveItem = new TreeItem("Жесткие диски");

                for(int i = 1; i < diskDrive.getDiskCount(); i++) {

                    TreeItem d = new TreeItem("Жесткий диск №" + i);

                    TreeItem mManufacturer = new TreeItem("Производитель: "
                            + diskDrive.getDiskDrives().get("#" + i).get(0).getValue());
                    TreeItem mModel = new TreeItem("Емкость: "
                            + diskDrive.getDiskDrives().get("#" + i).get(1).getValue());

                    d.setExpanded(true);
                    d.getChildren().addAll(mManufacturer, mModel);
                    diskDriveItem.getChildren().add(d);

                }

                diskDriveItem.setExpanded(true);
                tree.getRoot().getChildren().add(diskDriveItem);

            }
        });
        return null;
    }
}
