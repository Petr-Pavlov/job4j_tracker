package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
    }

    @Test
    public void whenManyValidInput() {
        Output out = new StubOutput();
        String[] data = {"2", "4", "6"};
        Input in = new StubInput(data);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        int expected = Integer.parseInt(data[0]);
        assertThat(selected, is(expected));
        selected = input.askInt("Enter menu:");
        expected = Integer.parseInt(data[1]);
        assertThat(selected, is(expected));
        selected = input.askInt("Enter menu:");
        expected = Integer.parseInt(data[2]);
        assertThat(selected, is(expected));
    }

    @Test
    public void whenNegativeIntInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}
