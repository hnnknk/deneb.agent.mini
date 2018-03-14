package xyz.hnnknk.deneb.agent.mini.tasks;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import xyz.hnnknk.deneb.agent.mini.hardwares.Ram;
import xyz.hnnknk.deneb.agent.mini.wmic.WmiUtility;

import java.util.concurrent.TimeUnit;

public class RamTask extends Task<Void> {

    private Ram ram;
    private WmiUtility wmiUtility;
    private TreeView tree;

    public RamTask(Ram ram, TreeView tree) {
        this.ram = ram;
        wmiUtility = new WmiUtility();
        this.tree = tree;
    }

    @Override
    protected Void call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                ram.setInfo(wmiUtility.getRamInformation());

                TreeItem ramItem = new TreeItem("Оперативная память");

                for(int i = 1; i < ram.getRamCount(); i++) {

                    TreeItem r = new TreeItem("Оперативная память №" + i);

                    TreeItem rManufacturer = new TreeItem("Производитель: "
                            + ram.getRams().get("#" + i).get(0).getValue());
                    TreeItem rSpeed = new TreeItem("Скорость: "
                            + ram.getRams().get("#" + i).get(1).getValue() + "Ghz");
                    TreeItem rCapacity = new TreeItem("Емкость: "
                            + ram.getRams().get("#" + i).get(2).getValue() + " Mb") ;

                    r.setExpanded(true);
                    r.getChildren().addAll(rManufacturer, rSpeed, rCapacity);
                    ramItem.getChildren().add(r);

                }

                ramItem.setExpanded(true);
                tree.getRoot().getChildren().add(ramItem);

            }
        });
        return null;
    }
}
