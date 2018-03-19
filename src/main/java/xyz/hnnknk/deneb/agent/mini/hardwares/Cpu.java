package xyz.hnnknk.deneb.agent.mini.hardwares;

import java.util.ArrayList;

/**
 * The Processor.
 */
public class Cpu extends Hardware {

    /**
     * Indicates the sequence number of the manufacturer in the array.
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
     * Indicates the sequence number of the numberOfCores in the array.
     */
    private final int numberOfCoresId = 3;

    /**
     * Processor's manufacturer.
     */
    private String manufacturer;
    /**
     * Processor's model.
     */
    private String model;
    /**
     * Processor's socket.
     */
    private String socket;
    /**
     * Number of processor cores.
     */
    private String numberOfCores;

    /**
     * Instantiates a new Cpu.
     * Set default values for all fields.
     */
    public Cpu() {
        manufacturer = "Неизвестно";
        model = "Неизвестно";
        socket = "Неизвестно";
        numberOfCores = "Неизвестно";
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
     * Gets number of cores.
     *
     * @return the number of cores
     */
    public final String getNumberOfCores() {
        return numberOfCores;
    }

    /**
     * Sets number of processor cores.
     *
     * @param numberOfCores the number of processor cores
     */
    private void setNumberOfCores(final String numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    /**
     * Sets cpu information.
     *
     * @param input the list with information from wmi
     */
    @Override
    public final void setInfo(final ArrayList<String> input) {
        setManufacturer(input.get(manufacturerId));
        setModel(input.get(modelId));
        setSocket(input.get(socketId));
        setNumberOfCores(input.get(numberOfCoresId));
    }
}
