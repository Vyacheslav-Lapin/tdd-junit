package com.epam.jl.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    @BeforeEach
    void setUp() {
        System.out.println("1");
    }

    @FastCalc
//    @ValueSource(ints = {1,2,3})
//    @CsvSource({"1,2,3", "2,3,5"})
    @MethodSource("paramGen")
    void getX(int x, int y, int z) {
//        int y = 5, z = x + y;
        assertEquals(z, new Calculator().sum(x, y));
    }

    private static Stream<Arguments> paramGen() {
        return Stream.of(
                () -> new Integer[]{1, 2, 3},
                () -> new Integer[]{3, 2, 5});
    }


    static class Tuple {
        public int x;
        public int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getSum() {
            return x + y;
        }
    }

    @TestFactory
    Stream<DynamicTest> testGen() {
        Random random = new Random();
        return IntStream.generate(random::nextInt)
                .limit(100)
                .mapToObj(operand -> new Tuple(operand, random.nextInt()))
                .map(tuple -> DynamicTest.dynamicTest(
                        "Мама мыла раму",
                        () -> assertEquals(
                                tuple.getSum(),
                                new Calculator().sum(tuple.x, tuple.y))));
    }

    @Test
    void getXZero() {
        assertTrue(true);
    }

    @AfterEach
    void tearDown() {
        System.out.println("2");
    }
}