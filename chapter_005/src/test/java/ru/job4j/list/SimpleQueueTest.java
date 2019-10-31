package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    @Test
    public void whenUseSimpleSQueueWithInteger() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
    }

    @Test
    public void whenUseSimpleQueueWithString() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();
        simpleQueue.push("a");
        simpleQueue.push("b");
        simpleQueue.push("c");
        assertThat(simpleQueue.poll(), is("a"));
        assertThat(simpleQueue.poll(), is("b"));
        assertThat(simpleQueue.poll(), is("c"));
    }

    @Test
    public void whenUseSimpleQueueWithPushThenPollAndAgainPush() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();
        simpleQueue.push("a");
        simpleQueue.push("b");
        simpleQueue.push("c");
        assertThat(simpleQueue.poll(), is("a"));
        assertThat(simpleQueue.poll(), is("b"));
        simpleQueue.push("d");
        assertThat(simpleQueue.poll(), is("d"));
        assertThat(simpleQueue.poll(), is("c"));
    }
}