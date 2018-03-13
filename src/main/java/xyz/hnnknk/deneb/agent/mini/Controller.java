package xyz.hnnknk.deneb.agent.mini;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import xyz.hnnknk.deneb.agent.mini.hardwares.Motherboard;
import xyz.hnnknk.deneb.agent.mini.tasks.MotherboardTask;

public class Controller {

    @FXML private Label motherboard;

    @FXML private Label cpu;

    @FXML private Label ram;

    @FXML private Label diskDrive;

    @FXML
    protected void getMotherboardManufacturer(ActionEvent actionEvent) throws Exception {

        Motherboard mother = new Motherboard();

        MotherboardTask mTask = new MotherboardTask(mother);
        motherboard.textProperty().bind(mTask.getMotherboard().getManufacturer());
        Thread t = new Thread(mTask);
        t.setDaemon(true);
        t.start();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
