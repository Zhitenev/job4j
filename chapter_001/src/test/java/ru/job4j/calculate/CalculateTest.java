package ru.job4j.calculate;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Class это учебный класс.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class CalculateTest {
	/**
	 * Test echo.
	 */
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Oleg Zhitenev";
		String expect = "Echo, echo, echo : Oleg Zhitenev";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}