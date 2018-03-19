package xyz.hnnknk.deneb.agent.mini.tasks;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.Cpu;
import xyz.hnnknk.deneb.agent.mini.wmic.WmiUtility;

import java.util.concurrent.TimeUnit;

/**
 * The Cpu task.
 */
public class CpuTask extends Task<Void> {

    /**
     * Instance of a cpu.
     */
    private final Cpu cpu;
    /**
     * Instance of a standard wmiUtility.
     */
    private final WmiUtility wmiUtility;
    /**
     * Instance of a JavaFx TreeView.
     */
    private final TreeView tree;


    /**
     * Instantiates a new Cpu task.
     *
     * @param cpu  the cpu
     * @param tree the JavaFx TreeView
     */
    public CpuTask(final Cpu cpu, final TreeView tree) {
        this.cpu = cpu;
        wmiUtility = new WmiUtility();
        this.tree = tree;
    }

    @Override
    protected final Void call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        Platform.runLater(() -> {
            cpu.setInfo(wmiUtility.getCpuInformation());

            TreeItem<String> cpuItem = new TreeItem<>("Процессор");

            TreeItem<String> cManufacturer = new TreeItem<>(
                    "Производитель: " + cpu.getManufacturer());
            TreeItem<String> cModel = new TreeItem<>(
                    "Модель: " + cpu.getModel());
            TreeItem<String> cSocket = new TreeItem<>(
                    "Сокет: " + cpu.getSocket());
            TreeItem<String> cCores = new TreeItem<>(
                    "Количество ядер: " + cpu.getNumberOfCores());

            cpuItem.getChildren().addAll(
                    cManufacturer, cModel, cSocket, cCores);
            cpuItem.setExpanded(true);
            tree.getRoot().getChildren().add(cpuItem);
        });
        return null;
    }
}
