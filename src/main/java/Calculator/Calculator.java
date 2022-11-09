package Calculator;

public class Calculator {
    /**
     * Класс-калькулятор
     * Упрощаем его до одного метода
     * Рефакторинг класса-калькулятора
     * что делается - метод calculate
     */

    //перечисление
    public enum Command {
        COMMAND_SUM,
        COMMAND_DIV
    }

    public int calculate(Command command, int argument1, int argument2) {

        int argAbs1 = Math.abs(argument1);
        int argAbs2 = Math.abs(argument2);

        switch (command) {
            case COMMAND_SUM: return sum(argAbs1, argAbs2);

            case COMMAND_DIV: return div(argAbs1, argAbs2);


            default: return 0;

        }
    }

    private int sum(int argument1, int argument2) {
            return argument1 + argument2;
    }

    private int div(int dividend, int divisor) {
        if(divisor == 0) throw new IllegalArgumentException("Divisor cannot be zero!");
        else
            return dividend / divisor;
    }
}
