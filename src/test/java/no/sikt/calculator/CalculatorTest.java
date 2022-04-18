package no.sikt.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    
    @Test
    void validateExpressionWith3InputsPlus()  {
        var expected = 2;
        var expression = "1 1 +";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void validateExpressionWith3InputsMinus()  {
        var expected = 0;
        var expression = "1 1 -";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void validateExpressionWith3InputsMult()  {
        var expected = 4;
        var expression = "2 2 *";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void validateExpressionWith3InputsDiv()  {
        var expected = 5;
        var expression = "5 1 /";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void validateExpressionWith5InputsOrder1()  {
        var expected = 4;
        var expression = "5 1 + 2 -";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void validateExpressionWith5InputsOrder2()  {
        var expected = 60;
        var expression = "6 5 2 * *";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void validateExpressionWith5InputsLength2()  {
        var expected = 2;
        var expression = "16 5 3 + /";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void validateExpressionWith7InputsPlus()  {
        var expected = 13;
        var expression = "2 6 2 + 3 + +";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void validateExpressionWith7InputsMinus()  {
        var expected = -9;
        var expression = "2 6 2 + 3 + -";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void validateExpressionWith7InputsMult()  {
        var expected = 22;
        var expression = "2 6 2 + 3 + *";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void validateExpressionWith7InputsDiv()  {
        var expected = 1;
        var expression = "11 6 2 + 3 + /";
        var actual = new Calculator(expression).getResult();
        assertEquals(expected, actual);
    }

    @Test
    void throwExceptionShortInput() {
    var expression = "11";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        new Calculator(expression).getResult();;
    });
    String expectedMessage = "Input is to short!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void throwExceptionLettersInput() {
    var expression = "asd";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        new Calculator(expression).getResult();;
    });
    String expectedMessage = "Input is invalid, should not contain letters!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void throwExceptionNumbersOnlyInput() {
    var expression = "1 2 3 4 5 7";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        Calculator cal = new Calculator(expression);
        cal.getResult();
    });
    String expectedMessage = "Input is invalid, should contain math operators!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void throwExceptionTooManyValues() {
    var expression = "1 2 3 4 5 6 7 8";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        Calculator cal = new Calculator(expression);
        cal.getResult();
    });
    String expectedMessage = "Too many values!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void throwExceptionMathOperatorWrongPositioning1() {
    var expression = "/ 2 3";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        Calculator cal = new Calculator(expression);
        cal.getResult();
    });
    String expectedMessage = "First position can not be math operator!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void throwExceptionMathOperatorWrongPositioning2() {
    var expression = "2 / 3";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        Calculator cal = new Calculator(expression);
        cal.getResult();
    });
    String expectedMessage = "Second position can not be math operator!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void throwExceptionMathOperatorWrongPositioning3() {
    var expression = "2 3 / / / ";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        Calculator cal = new Calculator(expression);
        cal.getResult();
    });
    String expectedMessage = "Expression consisting of 5 inputs can not contain 3 math operators!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void throwExceptionMathOperatorWrongPositioning4() {
    var expression = "3 4 5 / / / /";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        Calculator cal = new Calculator(expression);
        cal.getResult();
    });
    String expectedMessage = "Expression consisting of 7 inputs can not contain 4 math operators!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void throwExceptionMathOperatorWrongPositioning5() {
    var expression = "3 4 / / / / /";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        Calculator cal = new Calculator(expression);
        cal.getResult();
    });
    String expectedMessage = "Expression consisting of 7 inputs can not contain 4 math operators!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void throwExceptionIfNoEmptyField() {
    var expression = "123/*";
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        Calculator cal = new Calculator(expression);
        cal.getResult();
    });
    String expectedMessage = "Every number/operator should be provided with empty field after it!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
    }




    
}
