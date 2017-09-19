package com.epam.jl.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    @Test
    void getXZero() {
        assertTrue(true);
    }

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
        private int x;
        private int y;

        public Tuple(IntSupplier source) {
            this(source.getAsInt(), source.getAsInt());
        }

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getSum() {
            return x + y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Tuple)) return false;
            final Tuple other = (Tuple) o;
            if (this.getX() != other.getX()) return false;
            if (this.getY() != other.getY()) return false;
            return true;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            result = result * PRIME + this.getX();
            result = result * PRIME + this.getY();
            return result;
        }

        public String toString() {
            return "CalculatorTest.Tuple(x=" + this.getX() + ", y=" + this.getY() + ")";
        }
    }

    @TestFactory
    Stream<DynamicTest> testGen() {
        Random random = new Random();
        return Stream.generate(() -> new Tuple(random::nextInt))
                .limit(100)
                .map(tuple -> DynamicTest.dynamicTest(
                        "Мама мыла раму",
                        () -> assertThat(
                                new Calculator().sum(tuple.getX(), tuple.getY()),
                                is(tuple.getSum()))));
    }

    @AfterEach
    void tearDown() {
        System.out.println("2");
    }
}