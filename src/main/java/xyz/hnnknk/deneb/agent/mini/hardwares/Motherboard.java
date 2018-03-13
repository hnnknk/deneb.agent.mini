package xyz.hnnknk.deneb.agent.mini.hardwares;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Motherboard {
    private StringProperty manufacturer;
    private StringProperty model;

    public Motherboard() {
        manufacturer = new SimpleStringProperty("Неизвестно");
        model = new SimpleStringProperty("Модель");
    }

    public StringProperty getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer.setValue(manufacturer);
    }

    public StringProperty getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model.setValue(model);
    }
}
