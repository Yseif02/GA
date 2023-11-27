package edu.yu.cs.intro.ga;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ResourceTest {
    public static void main(String[] args) {
        GoogleAnalytics ga = new GoogleAnalytics();
        //Resource test = new Resource("456.html");
        //Resource test2 = new Resource("123.html");
        Resource resource1 = new Resource("123.html");
        Resource resource2 = new Resource("456.html");
        ga.addEvent("123.html", 10, 23.8, "search");
        ga.addEvent("123.html", 6, 2.8, "referral");
        ga.addEvent("456.html", 10, 23.8, "search");
        ga.addEvent("456.html", 6, 2.8, "referral");
        //ga.getAcquisitionTotals();
        //resource1.getTotalAcquisitionCounts();
        //resource1.getTotalConversion();
        //resource1.getEventsInChronologicalOrder();
        //resource1.getTotalDuration();


        /**
        //ga.addEvent("123.html", 9, 6.5, "direct");
        //test.setEvents();
        //System.out.println(test.getPath() + " " + test.getTotalDuration() + " " + test.getTotalConversion());
        //System.out.println(Arrays.toString(test.getTotalAcquisitionCounts()));
        //test.getEventsInChronologicalOrder();
         **/

    }

}