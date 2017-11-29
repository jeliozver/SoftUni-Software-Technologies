package com.softuni.bindingModel;

import javax.validation.constraints.NotNull;

public class CalculatorBindingModel {

    @NotNull
    private String leftOperand;

    @NotNull
    private String operator;

    @NotNull
    private String rightOperand;

    public String getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(String leftOperand) {
        this.leftOperand = leftOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(String rightOperand) {
        this.rightOperand = rightOperand;
    }
}