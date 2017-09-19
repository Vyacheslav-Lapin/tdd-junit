package com.epam.jl.tdd.demo;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class JUnit5Test {

    @Test
    void testWithSoftAssert() {
        User user = new User("Vasily", 27);

        assertAll(
                () -> assertThat(user.getName(), is("Petr")),
                () -> assertThat(user.getAge(), is(26))
        );
    }

    @UiFastTest
    void someTest() {
        assertTrue(true);
    }
}
