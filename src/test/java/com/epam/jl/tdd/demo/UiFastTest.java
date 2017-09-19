package com.epam.jl.tdd.demo;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Test
@Tag("UI")
@Tag("Fast")
@Retention(RUNTIME)
public @interface UiFastTest {
}
