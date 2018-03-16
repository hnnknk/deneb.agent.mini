package xyz.hnnknk.deneb.agent.mini.hardwares;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DiskDriveTest {

    private DiskDrive diskDrive;

    @Before
    public void init() {
        diskDrive = new DiskDrive();
    }

    @Test
    public void setInfoTestWithOneDrive() {
        ArrayList<String> info = new ArrayList<>(Arrays.asList("Toshiba Inc", "60000000000"));
        diskDrive.setInfo(info);
        assertEquals(1, diskDrive.getDiskDrives().size());
        assertEquals("Toshiba", diskDrive.getDiskDrives().get("#1").get(0));
        assertEquals("60", diskDrive.getDiskDrives().get("#1").get(1));
        assertEquals(1, diskDrive.getDiskCount());
    }

    @Test
    public void setInfoTestWithMultipleDrives() {
        ArrayList<String> info = new ArrayList<>(Arrays.asList("2","Toshiba Inc", "Seagate", "60000000000", "500000000000"));
        diskDrive.setInfo(info);
        assertEquals(2, diskDrive.getDiskDrives().size());
        assertEquals("Toshiba", diskDrive.getDiskDrives().get("#1").get(0));
        assertEquals("60", diskDrive.getDiskDrives().get("#1").get(1));

        assertEquals("Seagate", diskDrive.getDiskDrives().get("#2").get(0));
        assertEquals("500", diskDrive.getDiskDrives().get("#2").get(1));
        assertEquals(2, diskDrive.getDiskCount());
    }

    @Test
    public void setInfoTestWithOneSmallDrive() {
        ArrayList<String> info = new ArrayList<>(Arrays.asList("Seagate", "256000000"));
        diskDrive.setInfo(info);
        assertEquals(1, diskDrive.getDiskDrives().size());
        assertEquals("Seagate", diskDrive.getDiskDrives().get("#1").get(0));
        assertEquals("< 1", diskDrive.getDiskDrives().get("#1").get(1));
        assertEquals(1, diskDrive.getDiskCount());
    }

    @Test
    public void getDiskDrivesWithoutSetInfoShouldReturnZero() {
        assertNotNull(diskDrive.getDiskDrives());
        assertEquals(0, diskDrive.getDiskDrives().size());
    }

    @Test
    public void getDiskCountWithoutSetInfoShouldReturnZero() {
        assertEquals(0, diskDrive.getDiskCount());
    }
}