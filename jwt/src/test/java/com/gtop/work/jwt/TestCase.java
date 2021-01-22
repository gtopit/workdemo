package com.gtop.work.jwt;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCase {

    @Test
    public void test() {

        String token = JWTUtil.getToken();

        String token1 = JWTUtil.getToken();

    }

    @Test
    public void test2() {
        String str = "{reportTime}上报";

        System.out.println(str.replaceFirst("\\{reportTime}", "XXXXX"));
    }

    @Test
    public void test3() {
        System.out.println(new Date().getTime());
        System.out.println((1 + 0.0) / 3);
    }

    @Test
    public void test4() {
        String str = "65 车站北里16号楼北侧西";

        System.out.println(str.replaceFirst("^\\S*(\\s|-)", ""));

    }

    @Test
    public void test5() {
        AtomicInteger count = new AtomicInteger(0);

        count.getAndSet(1);

        count.getAndAdd(1);

        System.out.println(count.get());

    }

}
