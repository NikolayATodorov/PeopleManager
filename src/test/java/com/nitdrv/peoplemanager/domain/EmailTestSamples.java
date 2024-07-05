package com.nitdrv.peoplemanager.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class EmailTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Email getEmailSample1() {
        return new Email().id(1L).emailType("emailType1").email("email1");
    }

    public static Email getEmailSample2() {
        return new Email().id(2L).emailType("emailType2").email("email2");
    }

    public static Email getEmailRandomSampleGenerator() {
        return new Email().id(longCount.incrementAndGet()).emailType(UUID.randomUUID().toString()).email(UUID.randomUUID().toString());
    }
}
