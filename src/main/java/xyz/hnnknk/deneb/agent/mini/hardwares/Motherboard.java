package xyz.hnnknk.deneb.agent.mini.hardwares;

import java.util.ArrayList;

public class Motherboard extends Hardware {
    private String manufacturer;
    private String model;
    private String socket;

    public Motherboard() {
        manufacturer = "Неизвестно";
        model = "Неизвестно";
        socket = "Неизвестно";
    }

    public String getManufacturer() {
        return manufacturer;
    }

    private void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public String getSocket() {
        return socket;
    }

    private void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public void setInfo(ArrayList<String> input) {
        setManufacturer(input.get(0));
        setModel(input.get(1));
        setSocket(input.get(2));
    }
}
