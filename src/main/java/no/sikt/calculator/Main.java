package no.sikt.calculator;

public class Main {
    public static void main(String [] args) {
        Calculator calculator = new Calculator("6 6 2 / +	9");
        System.out.println(calculator.getResult());
        


    }

}
