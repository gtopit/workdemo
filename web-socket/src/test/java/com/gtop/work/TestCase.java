package com.gtop.work;

import org.junit.Test;

public class TestCase {

    @Test
    public void test() {
        PushingEvent event = new PushingEvent();
        event.setDistance(1000);
        event.setHappenedTime("2020-12-10");
        event.setEventType("123");
        event.setLicenceNo("粤A12345");
        event.setPosition("大兴");
        event.setSeeTime("2020-12-10");

        PushingEvent event2 = new PushingEvent();
        event2.setDistance(1000);
        event2.setHappenedTime("2020-12-10");
        event2.setEventType("123");
        event2.setLicenceNo("粤A12345");
        event2.setPosition("大兴");
        event2.setSeeTime("2020-12-10");

        System.out.println(event.equals(event2));

    }

}
