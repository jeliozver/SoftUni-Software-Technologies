function Calculator(leftOperand, rightOperand, operator) {
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
    this.operator = operator;

    this.calculateResult = function () {
        let result = 0;

        switch (this.operator){
            case '+':
                result = this.leftOperand + this.rightOperand;
                break;
            case '-':
                result = this.leftOperand - this.rightOperand;
                break;
            case '*':
                result = this.leftOperand * this.rightOperand;
                break;
            case '/':
                result = this.leftOperand / this.rightOperand;
                break;
            case 'mod':
                result = this.leftOperand % this.rightOperand;
                break;
            case 'pow':
                result = Math.pow(this.leftOperand, this.rightOperand);
                break;
            case 'What is X% of Y':
                result = this.leftOperand / 100 * this.rightOperand;
                break;
            case 'X is what % of Y':
                result = this.leftOperand / this.rightOperand * 100;
                break;
            case '√X':
                result = Math.sqrt(this.leftOperand);
                break;
            case 'X!':
                function calcFactorial(n) {
                    let factorial = 1;
                    while (n> 1)
                    {
                        factorial *= n;
                        n--;
                    }

                    return factorial;
                }

                result = calcFactorial(this.leftOperand);
                break;
        }

        return result;
    }
}

module.exports = Calculator;