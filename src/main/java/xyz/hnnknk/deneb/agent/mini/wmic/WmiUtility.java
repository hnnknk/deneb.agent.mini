package xyz.hnnknk.deneb.agent.mini.wmic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * The type Wmi utility.
 */
public class WmiUtility {

    /**
     * List with information from wmi.
     */
    private ArrayList<String> information;

    /**
     * Gets motherboard information.
     *
     * @return the motherboard information
     */
    public final ArrayList<String> getMotherboardInformation() {
        information = new ArrayList<>();
        information.addAll(executeCommand("baseboard", "manufacturer"));
        information.addAll(executeCommand("baseboard", "product"));
        information.addAll(executeCommand("cpu", "socketdesignation"));
        return information;
    }

    /**
     * Gets disk drive information.
     *
     * @return the disk drive information
     */
    public final ArrayList<String> getDiskDriveInformation() {
        information = new ArrayList<>();
        ArrayList<String> list = executeCommand("diskdrive", "caption");
        if (list.size() > 1) {
            information.add(Integer.toString(list.size()));
        }
        information.addAll(list);
        information.addAll(executeCommand("diskdrive", "size"));
        return information;
    }

    /**
     * Gets cpu information.
     *
     * @return the cpu information
     */
    public final ArrayList<String> getCpuInformation() {
        information = new ArrayList<>();
        information.addAll(executeCommand("cpu", "manufacturer"));
        information.addAll(executeCommand("cpu", "name"));
        information.addAll(executeCommand("cpu", "socketdesignation"));
        information.addAll(executeCommand("cpu", "numberofcores"));
        return information;
    }

    /**
     * Gets ram information.
     *
     * @return the ram information
     */
    public final ArrayList<String> getRamInformation() {
        information = new ArrayList<>();
        ArrayList<String> list = executeCommand("memorychip", "manufacturer");
        if (list.size() > 1) {
            information.add(Integer.toString(list.size()));
        }
        information.addAll(list);
        information.addAll(executeCommand("memorychip", "speed"));
        information.addAll(executeCommand("memorychip", "capacity"));

        return information;
    }

    /**
     * Gets information from wmi cmd command.
     *
     * @param hardware the hardware's name for cmd command
     * @param type the type of information for cmd command
     * @return list with information from wmi
     */
    private synchronized ArrayList<String> executeCommand(
            final String hardware, final String type) {
        ArrayList<String> results = new ArrayList<>();
        String lastPart = "WMIC " + hardware + " GET " + type;
        String[] command = {"CMD", "/C", lastPart};

        try {
            Process p = Runtime.getRuntime().exec(command);
            p.getOutputStream().close();

            String s;
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            while ((s = reader.readLine()) != null) {
                if (s.length() > 0) {
                    results.add(s);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).toLowerCase().contains(type)) {
                results.remove(i);
            }
        }
        return results;
    }
}
