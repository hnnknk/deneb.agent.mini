package xyz.hnnknk.deneb.agent.mini.hardwares;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Cpu extends Hardware{

    private final StringProperty manufacturer;
    private final StringProperty model;
    private final StringProperty socket;
    private final StringProperty numberOfCores;

    public Cpu() {
        manufacturer = new SimpleStringProperty("Сбор информации");
        model = new SimpleStringProperty("Сбор информации");
        socket = new SimpleStringProperty("Сбор информации");
        numberOfCores = new SimpleStringProperty("Сбор информации");
    }

    public StringProperty getManufacturer() {
        return manufacturer;
    }

    private void setManufacturer(String manufacturer) {
        this.manufacturer.set(manufacturer);
    }

    public StringProperty getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model.set(model);
    }

    public StringProperty getSocket() {
        return socket;
    }

    private void setSocket(String socket) {
        this.socket.set(socket);
    }

    public StringProperty getNumberOfCores() {
        return numberOfCores;
    }

    private void setNumberOfCores(String numberOfCores) {
        this.numberOfCores.set(numberOfCores);
    }

    public void setInfo(ArrayList<String> input) {
        setManufacturer(input.get(0));
        setModel(input.get(1));
        setSocket(input.get(2));
        setNumberOfCores(input.get(3));
    }
}
