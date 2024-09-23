package dev.nicolasmartins.model;

public class CalculatorModel {
    double result;

    public CalculatorModel() {
        result = 0;
    }

    public double getResult() {
        return result;
    }

    public void add(double number) {
        result += number;
    }

    public void subtract(double number) {
        result -= number;
    }

    public void multiply(double number) {
        result *= number;
    }

    //The division method throws an exception if there is an attempt to divide by zero.
    public void divide(double number) throws ArithmeticException{
        if(number == 0) {
            throw new ArithmeticException("impossivel realizar divisão por zero");
        } else {
            result /= number;
        }
    }
}
