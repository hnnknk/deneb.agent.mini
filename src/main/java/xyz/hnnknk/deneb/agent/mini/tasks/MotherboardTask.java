package xyz.hnnknk.deneb.agent.mini.tasks;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.Motherboard;
import xyz.hnnknk.deneb.agent.mini.wmic.WmiUtility;

import java.util.concurrent.TimeUnit;

/**
 * The Motherboard task.
 */
public class MotherboardTask extends Task<Void> {

    /**
     * Instance of a motherboard.
     */
    private final Motherboard motherboard;
    /**
     * Instance of a standard wmiUtility.
     */
    private final WmiUtility wmiUtility;
    /**
     * Instance of a JavaFx TreeView.
     */
    private final TreeView tree;


    /**
     * Instantiates a new Motherboard task.
     *
     * @param motherboard the motherboard
     * @param tree the JavaFx TreeView
     */
    public MotherboardTask(final Motherboard motherboard, final TreeView tree) {
        this.motherboard = motherboard;
        wmiUtility = new WmiUtility();
        this.tree = tree;
    }

    @Override
    protected final Void call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        Platform.runLater(() -> {
            motherboard.setInfo(wmiUtility.getMotherboardInformation());

            TreeItem<String> motherboardItem = new TreeItem<>(
                    "Материнская плата");

            TreeItem<String> mManufacturer = new TreeItem<>(
                    "Производитель: "
                    + motherboard.getManufacturer());
            TreeItem<String> mModel = new TreeItem<>("Модель: "
                    + motherboard.getModel());
            TreeItem<String> mSocket = new TreeItem<>("Сокет: "
                    + motherboard.getSocket());

            motherboardItem.getChildren()
                    .addAll(mManufacturer, mModel, mSocket);
            motherboardItem.setExpanded(true);
            tree.getRoot().getChildren().add(motherboardItem);
        });
        return null;
    }
}
