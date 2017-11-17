const Calculator = require('../models/Calculator');

module.exports = {
    indexGet: (req, res) => {
        res.render('home/index');
    },

    indexPost: (req, res) => {
        let calculatorParams = req.body['calculator'];

        let calculator = new Calculator();
        calculator.leftOperand = Number(calculatorParams.leftOperand);
        calculator.rightOperand = Number(calculatorParams.rightOperand);
        calculator.operator = calculatorParams.operator;

        let errorMsg = '';
        if (!calculatorParams.leftOperand) {
            errorMsg = 'Please enter X parameter!';
        } else if (!calculatorParams.rightOperand
            && calculator.operator !== '√X'
            && calculator.operator !== 'X!') {
            errorMsg = 'Please enter Y parameter!';
        }

        if (errorMsg) {
            res.render('home/index', {error: errorMsg});
            return;
        }

        let result = calculator.calculateResult();

        res.render('home/index', {'calculator': calculator, 'result': result});
    }
};