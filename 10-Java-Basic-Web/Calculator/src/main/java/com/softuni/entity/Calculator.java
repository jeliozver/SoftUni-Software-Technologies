package com.softuni.entity;

public class Calculator {
    private double leftOperand;
    private double rightOperand;
    private String operator;

    public Calculator(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double CalculateResult() {
        double result = 0;

        switch (this.operator) {
            case "+":
                result = this.getLeftOperand() + this.getRightOperand();
                break;
            case "-":
                result = this.getLeftOperand() - this.getRightOperand();
                break;
            case "*":
                result = this.getLeftOperand() * this.getRightOperand();
                break;
            case "/":
                result = this.getLeftOperand() / this.getRightOperand();
                break;
            case "mod":
                result = this.getLeftOperand() % this.getRightOperand();
                break;
            case "pow":
                result = Math.pow(this.getLeftOperand(), this.getRightOperand());
                break;
            case "And":
                result = (int)this.getLeftOperand() & (int)this.getRightOperand();
                break;
            case "Or":
                result = (int)this.getLeftOperand() | (int)this.getRightOperand();
                break;
            case "Xor":
                result = (int)this.getLeftOperand() ^ (int)this.getRightOperand();
                break;
            case "Not":
                result = ~ (int)this.getLeftOperand();
                break;
            case "ShiftLeft":
                result = (int)this.getLeftOperand() << (int)this.getRightOperand();
                break;
            case "ShiftRight":
                result = (int)this.getLeftOperand() >> (int)this.getRightOperand();
                break;
            case "What is X% of Y":
                result = this.getLeftOperand() / 100 * this.getRightOperand();
                break;
            case "X is what % of Y":
                if (this.getRightOperand() != 0) {
                    result = this.getLeftOperand() / this.getRightOperand() * 100;
                }
                break;
            case "√X":
                result = Math.sqrt(this.getLeftOperand());
                break;
            case "X!":
                result = calcFactorial(this.getLeftOperand());
                break;
        }

        return result;
    }

    private double calcFactorial(double n) {
        double factorial = 1.0;

        while (n > 1.0)
        {
            factorial *= n;
            n--;
        }

        return factorial;
    }
}