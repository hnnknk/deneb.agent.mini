package xyz.hnnknk.deneb.agent.mini.hardwares;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Motherboard extends Hardware {
    private final StringProperty manufacturer;
    private final StringProperty model;
    private final StringProperty socket;

    public Motherboard() {
        manufacturer = new SimpleStringProperty("Сбор информации");
        model = new SimpleStringProperty("Сбор информации");
        socket = new SimpleStringProperty("Сбор информации");
    }

    public StringProperty getManufacturer() {
        return manufacturer;
    }

    private void setManufacturer(String manufacturer) {
        this.manufacturer.setValue(manufacturer);
    }

    public StringProperty getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model.setValue(model);
    }

    public StringProperty getSocket() {
        return socket;
    }

    private void setSocket(String socket) {
        this.socket.setValue(socket);
    }

    @Override
    public void setInfo(ArrayList<String> input) {
        setManufacturer(input.get(0));
        setModel(input.get(1));
        setSocket(input.get(2));
    }
}
