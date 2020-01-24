package ru.job4j.socet.client;

public class StubInput implements Input {

    private String value;

    public StubInput(String value) {
        this.value = value;
    }

    @Override
    public String ask() {
        return this.value;
    }
}
