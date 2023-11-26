package edu.yu.cs.intro.ga;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GoogleAnalyticsTest {
    public static void main(String[] args) {
        GoogleAnalytics ga = new GoogleAnalytics();
        //ga.addEvent(new Event("test.html", 30, 40.58, "search"));
        ga.setResources();
        ga.getResourcesSortedByPath();

    }
    @Test
    void getResourceForPath() {

    }

    @Test
    void getResourcesSortedByPath() {
    }

    @Test
    void getResourcesSortedByTotalDuration() {
    }

    @Test
    void getResourcesSortedByTotalConversion() {
    }

    @Test
    void getAcquisitionTotals() {
    }

    @Test
    void addEvent() {
    }

    @Test
    void testAddEvent() {
    }
}