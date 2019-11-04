package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NodeCycleTest {

    @Test
    public void whenHasCycleTrue() {
        NodeCycle<Integer> first = new NodeCycle<>(1);
        NodeCycle<Integer> two = new NodeCycle<>(2);
        NodeCycle<Integer> third = new NodeCycle<>(3);
        NodeCycle<Integer> four = new NodeCycle<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenHasCycleTrueInMid() {
        NodeCycle<Integer> first = new NodeCycle<>(1);
        NodeCycle<Integer> two = new NodeCycle<>(2);
        NodeCycle<Integer> third = new NodeCycle<>(3);
        NodeCycle<Integer> four = new NodeCycle<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = two;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenHasCycleFalse5Relation() {
        NodeCycle<Integer> first = new NodeCycle<>(1);
        NodeCycle<Integer> two = new NodeCycle<>(2);
        NodeCycle<Integer> third = new NodeCycle<>(3);
        NodeCycle<Integer> four = new NodeCycle<>(4);
        NodeCycle<Integer> five = new NodeCycle<>(5);
        NodeCycle<Integer> six = new NodeCycle<>(6);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        assertThat(first.hasCycle(first), is(false));
    }

    @Test
    public void whenHasCycleFalse4Relation() {
        NodeCycle<Integer> first = new NodeCycle<>(1);
        NodeCycle<Integer> two = new NodeCycle<>(2);
        NodeCycle<Integer> third = new NodeCycle<>(3);
        NodeCycle<Integer> four = new NodeCycle<>(4);
        NodeCycle<Integer> five = new NodeCycle<>(5);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        assertThat(first.hasCycle(first), is(false));
    }

    @Test
    public void whenHasCycleFalse3Relation() {
        NodeCycle<Integer> first = new NodeCycle<>(1);
        NodeCycle<Integer> two = new NodeCycle<>(2);
        NodeCycle<Integer> third = new NodeCycle<>(3);
        NodeCycle<Integer> four = new NodeCycle<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        assertThat(first.hasCycle(first), is(false));
    }

    @Test
    public void whenHasCycle2Relation() {
        NodeCycle<Integer> first = new NodeCycle<>(1);
        NodeCycle<Integer> two = new NodeCycle<>(2);
        NodeCycle<Integer> third = new NodeCycle<>(3);
        NodeCycle<Integer> four = new NodeCycle<>(4);
        first.next = two;
        two.next = third;
        assertThat(first.hasCycle(first), is(false));
    }

    @Test
    public void whenHasCycle1Relation() {
        NodeCycle<Integer> first = new NodeCycle<>(1);
        NodeCycle<Integer> two = new NodeCycle<>(2);
        NodeCycle<Integer> third = new NodeCycle<>(3);
        NodeCycle<Integer> four = new NodeCycle<>(4);
        first.next = two;
        assertThat(first.hasCycle(first), is(false));
    }
}
