package com.epam.jl.tdd;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Tag("ui")
@Tag("calc")
@ParameterizedTest
public @interface FastCalc {
}
