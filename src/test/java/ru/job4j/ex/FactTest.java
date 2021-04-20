package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FactTest {

    @Test
    public void whenIsFromFive() {
        int expected = 120;
        int rsl = Fact.calc(5);
        assertThat(rsl, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIsIllegalArgument() {
        Fact.calc(-5);
    }
}
