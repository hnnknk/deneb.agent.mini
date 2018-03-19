package xyz.hnnknk.deneb.agent.mini.hardwares;

import java.util.ArrayList;

/**
 * The Motherboard.
 */
public class Motherboard extends Hardware {

    /**
     * Indicates the sequence number of the manufacturer
     * in the array.
     */
    private final int manufacturerId = 0;
    /**
     * Indicates the sequence number of the model in the array.
     */
    private final int modelId = 1;
    /**
     * Indicates the sequence number of the socket in the array.
     */
    private final int socketId = 2;

    /**
     * Motherboard's manufacturer.
     */
    private String manufacturer;
    /**
     * Motherboard's model.
     */
    private String model;
    /**
     * Motherboard's socket.
     */
    private String socket;

    /**
     * Instantiates a new Motherboard.
     * Sets default values for some methods.
     */
    public Motherboard() {
        manufacturer = "Неизвестно";
        model = "Неизвестно";
        socket = "Неизвестно";
    }

    /**
     * Gets manufacturer.
     *
     * @return the manufacturer
     */
    public final String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets manufacturer.
     *
     * @param manufacturer the manufacturer
     */
    private void setManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public final String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    private void setModel(final String model) {
        this.model = model;
    }

    /**
     * Gets socket.
     *
     * @return the socket
     */
    public final String getSocket() {
        return socket;
    }

    /**
     * Sets socket.
     *
     * @param socket the socket
     */
    private void setSocket(final String socket) {
        this.socket = socket;
    }

    /**
     * Sets motherboard information.
     *
     * @param input the list with information from wmi
     */
    @Override
    public final void setInfo(final ArrayList<String> input) {
        setManufacturer(input.get(manufacturerId));
        setModel(input.get(modelId));
        setSocket(input.get(socketId));
    }
}
