function multiplyOrDivideNumbers(args) {
    let numberOne = Number(args[0]);
    let numberTwo = Number(args[1]);

    let result = 0;

    if (numberTwo >= numberOne) {
        result = numberOne * numberTwo;
    } else {
        result = numberOne / numberTwo;
    }

    console.log(result);
}

multiplyOrDivideNumbers(['3', '2']);