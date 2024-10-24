package kalkulator;

public class Calculator {
    private int state = 0;
    private int memory = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void add(int value) {
        state += value;
    }

    public void mult(int value) {
        state *= value;
    }

    public void sub(int value) {
        state -= value;
    }

    public void div(int value) throws ArithmeticException {
        if (value == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        state /= value;
    }

    public void storeInMemory() {
        memory = state;
    }

    public int recallFromMemory() {
        return memory;
    }

    public void clearMemory() {
        memory = 0;
    }

    public void addMemory() {
        state += memory;
    }

    public void multMemory() {
        state *= memory;
    }
}
