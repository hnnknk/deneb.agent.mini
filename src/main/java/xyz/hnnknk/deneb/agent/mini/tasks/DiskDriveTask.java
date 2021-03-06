package xyz.hnnknk.deneb.agent.mini.tasks;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.DiskDrive;
import xyz.hnnknk.deneb.agent.mini.wmic.WmiUtility;

import java.util.concurrent.TimeUnit;

/**
 * The Disk drive task.
 */
public class DiskDriveTask extends Task<Void> {

    /**
     * Instance of a disk drive.
     */
    private final DiskDrive diskDrive;
    /**
     * Instance of a standard wmiUtility.
     */
    private final WmiUtility wmiUtility;
    /**
     * Instance of a JavaFx TreeView.
     */
    private final TreeView tree;

    /**
     * Instantiates a new Disk drive task.
     *
     * @param diskDrive the disk drive
     * @param tree the JavaFx TreeView
     */
    public DiskDriveTask(final DiskDrive diskDrive, final TreeView tree) {
        this.diskDrive = diskDrive;
        wmiUtility = new WmiUtility();
        this.tree = tree;
    }

    @Override
    protected final Void call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        Platform.runLater(() -> {
            diskDrive.setInfo(wmiUtility.getDiskDriveInformation());

            TreeItem<String> diskDriveItem = new TreeItem<>(
                    "Жесткие диски");

            for (int i = 1; i <= diskDrive.getDiskCount(); i++) {

                TreeItem<String> d = new TreeItem<>(
                        "Жесткий диск №" + i);

                TreeItem<String> dManufacturer = new TreeItem<>(
                        "Производитель: " + diskDrive.getDiskDrives()
                                .get("#" + i).get(0));
                TreeItem<String> dCapacity = new TreeItem<>(
                        "Емкость: " + diskDrive.getDiskDrives()
                                .get("#" + i).get(1) + " Gb");

                d.setExpanded(true);
                d.getChildren().addAll(dManufacturer, dCapacity);
                diskDriveItem.getChildren().add(d);

            }

            diskDriveItem.setExpanded(true);
            tree.getRoot().getChildren().add(diskDriveItem);

        });
        return null;
    }
}
