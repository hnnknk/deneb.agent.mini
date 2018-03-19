package xyz.hnnknk.deneb.agent.mini.hardwares;

import java.util.ArrayList;

/**
 * The type Hardware.
 */
abstract class Hardware {

    /**
     * Sets info.
     *
     * @param input the list with information from wmi
     */
    public abstract void setInfo(ArrayList<String> input);
}
