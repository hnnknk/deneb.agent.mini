package xyz.hnnknk.deneb.agent.mini.hardwares;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The random access memory.
 */
public class Ram extends Hardware {

    /**
     * Indicates the sequence number of the manufacturer
     * in the array.
     */
    private final int manufacturerId = 0;
    /**
     * Indicates the sequence number of the ram's speed in
     * the array.
     */
    private final int speedId = 1;
    /**
     * Indicates the sequence number of the rams capacity in
     * the array.
     */
    private final int capacityId = 2;
    /**
     * Ram count types of information from
     * wmi (manufacturer, speed and capacity).
     */
    private final int ramsInformationCount = 3;

    /**
     * Standard prefix kibi.
     */
    private final int kibi = 1024;

    /**
     * Map with rams in system with appropriate look.
     */
    private final HashMap<String, ArrayList<String>> rams;
    /**
     * Rams count.
     */
    private int ramCount;

    /**
     * Instantiates a new Disk drive.
     * Sets default values for some methods.
     */
    public Ram() {
        rams = new HashMap<>();
        ramCount = 0;
    }

    /**
     * Sets ram's information with one of two ways.
     *
     * @param input the list with information from wmi
     */
    @Override
    public final void setInfo(final ArrayList<String> input) {
        int step = 2;
        if (input.size() % ramsInformationCount == 1) {
            for (int i = 1; i < input.size() / ramsInformationCount + 1; i++) {
                ArrayList<String> list = new ArrayList<>();
                list.add(input.get(i));
                list.add(input.get(i + step));
                list.add(optimizeCapacity(input.get(i + step * 2)));
                ramCount++;
                rams.put("#" + ramCount, list);

            }
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(input.get(manufacturerId));
            list.add(input.get(speedId));
            list.add(optimizeCapacity(input.get(capacityId)));
            ramCount = 1;
            rams.put("#1", list);
        }
    }

    /**
     * Gets optimize size.
     *
     * @param input raw size from wmi
     *
     * @return optimize size in megabytes
     */
    private String optimizeCapacity(final String input) {
        long l = Long.parseLong(input.trim());
        l = l / (kibi * kibi);
        return Long.toString(l);
    }

    /**
     * Gets rams.
     *
     * @return the rams
     */
    public final HashMap<String, ArrayList<String>> getRams() {
        return rams;
    }

    /**
     * Gets ram count.
     *
     * @return the ram count
     */
    public final int getRamCount() {
        return ramCount;
    }
}
