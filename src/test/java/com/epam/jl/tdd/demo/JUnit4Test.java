package com.epam.jl.tdd.demo;

import org.junit.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit4Test {

    @Test
    @Tag("UI")
    @Tag("Fast")
    public void someTest() throws Exception {
        assertTrue(true);
    }
}
