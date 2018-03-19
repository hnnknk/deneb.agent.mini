package xyz.hnnknk.deneb.agent.mini.hardwares;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Disk drive.
 */
public class DiskDrive extends Hardware {

    /**
     * Indicates the sequence number of the manufacturer
     * in the array.
     */
    private final int manufacturerId = 0;
    /**
     * Indicates the sequence number of the capacity in the array.
     */
    private final int sizeId = 1;
    /**
     * Standard prefix kilo.
     */
    private final int kilo = 1000;
    /**
     * Disk drives count types of information from
     * wmi (name/manufacturer and capacity).
     */
    private final int drivesInformationCount = 2;

    /**
     * Map with disk drives in system with appropriate look.
     */
    private final HashMap<String, ArrayList<String>> diskDrives;
    /**
     * Disk drives count.
     */
    private int diskCount;

    /**
     * Instantiates a new Disk drive.
     * Sets default values for some methods.
     */
    public DiskDrive() {
        diskDrives = new HashMap<>();
        diskCount = 0;
    }

    /**
     * Sets disk drives information with one of two ways.
     *
     * @param input the list with information from wmi
     */
    @Override
    public final void setInfo(final ArrayList<String> input) {
        if (input.size() % drivesInformationCount == 1) {
            for (int i = 1; i < input.size() / drivesInformationCount + 1; i++) {
                ArrayList<String> list = new ArrayList<>();
                list.add(optimizeDriveName(input.get(i)));
                list.add(optimizeSize(input.get(i + 2)));
                diskCount++;
                diskDrives.put("#" + diskCount, list);
            }
        } else {
            diskCount = 1;
            ArrayList<String> list = new ArrayList<>();
            list.add(optimizeDriveName(input.get(manufacturerId)));
            list.add(optimizeSize(input.get(sizeId)));
            diskDrives.put("#1", list);
        }
    }

    /**
     * Gets first name from and cut others useless.
     *
     * @param input raw disk drive name from wmi
     *
     * @return first disk drive name
     */
    private String optimizeDriveName(final String input) {
        return input.split("\\s+")[0];
    }

    /**
     * Gets optimize size.
     *
     * @param input raw size from wmi
     *
     * @return optimize size in gigabytes or if less - '< 1'
     */
    private String optimizeSize(final String input) {
        long l = Long.parseLong(input.trim());
        l = l / (kilo * kilo * kilo);
        if (l == 0) {
            return "< 1";
        } else {
            return Long.toString(l);
        }
    }

    /**
     * Gets disk drives.
     *
     * @return the disk drives
     */
    public final HashMap<String, ArrayList<String>> getDiskDrives() {
        return diskDrives;
    }

    /**
     * Gets disk count.
     *
     * @return the disk count
     */
    public final int getDiskCount() {
        return diskCount;
    }
}
