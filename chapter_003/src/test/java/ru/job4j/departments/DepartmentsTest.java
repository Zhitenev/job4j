package ru.job4j.departments;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        Departments deps = new Departments();
        List<String> input = List.of("k1/sk1");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k1")),
                new Departments.Org(List.of("k1", "sk1"))
        );
        List<Departments.Org> result = deps.convert(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissedTwo() {
        Departments deps = new Departments();
        List<String> input = List.of("k1");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k1"))
        );
        List<Departments.Org> result = deps.convert(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissedThree() {
        Departments deps = new Departments();
        List<String> input = List.of("k2/sk1");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k2")),
                new Departments.Org(List.of("k2", "sk1"))
        );
        List<Departments.Org> result = deps.convert(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissedFour() {
        Departments deps = new Departments();
        List<String> input = List.of("k1", "k2/sk1");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k1")),
                new Departments.Org(List.of("k2")),
                new Departments.Org(List.of("k2", "sk1"))
        );
        List<Departments.Org> result = deps.convert(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAsc() {
        Departments deps = new Departments();
        List<String> input = List.of("k1/sk1", "k2");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k1")),
                new Departments.Org(List.of("k1", "sk1")),
                new Departments.Org(List.of("k2"))
        );
        List<Departments.Org> result = deps.sortAsc(deps.convert(input));
        assertThat(result, is(expect));
    }

    @Test
    public void whenDesc() {
        Departments deps = new Departments();
        List<String> input = List.of("k1/sk1", "k2");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k2")),
                new Departments.Org(List.of("k1")),
                new Departments.Org(List.of("k1", "sk1"))
        );
        List<Departments.Org> result = deps.sortDesc(deps.convert(input));
        assertThat(result, is(expect));
    }
}