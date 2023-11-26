package edu.yu.cs.intro.ga;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ResourceTest {
    public static void main(String[] args) {
        Resource test = new Resource("456.html");
        test.setEvents();
        System.out.println(test.getPath() + " " + test.getTotalDuration() + " " + test.getTotalConversion());
        System.out.println(Arrays.toString(test.getTotalAcquisitionCounts()));
        test.getEventsInChronologicalOrder();
    }

}