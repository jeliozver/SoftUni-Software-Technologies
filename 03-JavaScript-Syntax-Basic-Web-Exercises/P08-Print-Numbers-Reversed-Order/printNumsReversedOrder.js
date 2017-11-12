function printNumbersReversedOrder(args) {
    let input = args.toString().split(',');

    for (let i = input.length - 1; i >= 0; i--) {
        console.log(input[i]);
    }
}

printNumbersReversedOrder([5,5.5,24,-3]);