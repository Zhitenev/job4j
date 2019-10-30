package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    @Test
    public void whenUseSimpleStackWithInteger() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        simpleStack.poll();
        simpleStack.poll();
        simpleStack.push(7);
        assertThat(simpleStack.poll(), is(7));
    }

    @Test
    public void whenUseSimpleStackWithString() {
        SimpleStack<String> simpleStack = new SimpleStack<>();
        simpleStack.push("a");
        simpleStack.push("b");
        simpleStack.push("v");
        simpleStack.poll();
        simpleStack.poll();
        simpleStack.push("d");
        assertThat(simpleStack.poll(), is("d"));
    }

    @Test
    public void whenUseSimpleStackWithStringOnePoll() {
        SimpleStack<String> simpleStack = new SimpleStack<>();
        simpleStack.push("a");
        simpleStack.push("b");
        simpleStack.push("v");
        simpleStack.poll();
        assertThat(simpleStack.poll(), is("b"));
    }
}
