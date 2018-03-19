package xyz.hnnknk.deneb.agent.mini.tasks;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.Ram;
import xyz.hnnknk.deneb.agent.mini.wmic.WmiUtility;

import java.util.concurrent.TimeUnit;

/**
 * The Ram task.
 */
public class RamTask extends Task<Void> {

    /**
     * Instance of a motherboard.
     */
    private final Ram ram;
    /**
     * Instance of a standard wmiUtility.
     */
    private final WmiUtility wmiUtility;
    /**
     * Instance of a JavaFx TreeView.
     */
    private final TreeView tree;

    /**
     * Instantiates a new Ram task.
     *
     * @param ram  the ram
     * @param tree the tree
     */
    public RamTask(final Ram ram, final TreeView tree) {
        this.ram = ram;
        wmiUtility = new WmiUtility();
        this.tree = tree;
    }

    @Override
    protected final Void call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        Platform.runLater(() -> {
            ram.setInfo(wmiUtility.getRamInformation());

            TreeItem<String> ramItem = new TreeItem<>(
                    "Оперативная память");

            for (int i = 1; i <= ram.getRamCount(); i++) {

                TreeItem<String> r = new TreeItem<>(
                        "Оперативная память №" + i);

                TreeItem<String> rManufacturer = new TreeItem<>(
                        "Производитель: "
                        + ram.getRams().get("#" + i).get(0));
                TreeItem<String> rSpeed = new TreeItem<>("Скорость: "
                        + ram.getRams().get("#" + i).get(1) + "Ghz");
                TreeItem<String> rCapacity = new TreeItem<>("Емкость: "
                        + ram.getRams().get("#" + i).get(2) + " Mb");

                r.setExpanded(true);
                r.getChildren().addAll(rManufacturer, rSpeed, rCapacity);
                ramItem.getChildren().add(r);

            }

            ramItem.setExpanded(true);
            tree.getRoot().getChildren().add(ramItem);

        });
        return null;
    }
}
