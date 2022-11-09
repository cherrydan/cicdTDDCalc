package Calculator;

import Calculator.Calculator.Command;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ! JUnit v. 4x
 * 1. Пишем тест калькулятора, когда сама сущность калькулятора ещё не написана
 * 2. Создаём класс калькулятора и метод, который тестируем, но не реализуем их (будет происходить компиляция)
 * 3. Чтобы тест не упал, просто без вычислений пусть он возвращает "правильное" значение
 * 4. оформить уже работающий метод со всеми нормальными вычислениями
 * 5. Тестируем сложение с отрицательными числами
 * 6. Зарефакторить наши тесты, создав приватное поле класса с калькулятором и проинициализировав его один раз в
 * Before
 * 7. Тестируем деление на 0. Имеет смысл делать значимые именнованые константы
 * 8. Научим калькулятор выкидывать исключение, когда делитель равен 0
 * 9. Убедимся, что наш тест ожидает наше исключение
 * 10. Тестируем деление с отрицательными числами
 * 11. Наши тесты берут агрумент по модулю, поэтому нам непринципиально, отрицательные ли числа вообще
 * 12. Рефакторим тесты под модель "что дано, что делается и что ожидаем получить"
 * 13. что дано - это аргументы, закрытые поля тестового класса
 */
public class CalculatorTest {

    private static final int ZERO = 0;

   private int result;

    private int argument1;
    private int argument2;

    private Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

   @Test
    public void testSum() {
       setArguments(2, 2); //что дано
       whenCommandIs(Command.COMMAND_SUM);
       whenResultIs(4);

    }

    @Test
    public void testSum2() {
        setArguments(3, 3);
        whenCommandIs(Command.COMMAND_SUM);
        whenResultIs(6);
    }

    @Test
    public void testDiv() {
       setArguments(20, 5);
       whenCommandIs(Command.COMMAND_DIV);
       whenResultIs(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivOnZero() {
        setArguments(100, ZERO);
        whenCommandIs(Command.COMMAND_DIV);
        whenResultThrowsException();

    }

    @Test
    public void testSumABS() {
        setArguments(5, -3);
        whenCommandIs(Command.COMMAND_SUM);
        whenResultIs(8);
    }

    @Test
    public void testDivABS() {
        setArguments(10, -2);
        whenCommandIs(Command.COMMAND_DIV);
        whenResultIs(5);

    }


    private void setArguments(int argument1, int argument2) {
        this.argument1 = Math.abs(argument1);
        this.argument2 = Math.abs(argument2);
    }

    private void whenCommandIs(Command command) {
       this.result = calculator.calculate(command, argument1, argument2);
    }

    private void whenResultIs(int expectedResult) {
        Assert.assertEquals(this.result, expectedResult);
    }

    private void whenResultThrowsException() {
        Assert.fail();
    }

}
