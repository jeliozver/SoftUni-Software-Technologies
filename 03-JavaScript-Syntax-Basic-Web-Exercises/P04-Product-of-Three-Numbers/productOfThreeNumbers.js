function productOfThreeNumbers(args) {
    let numbers = [
        Number(args[0]),
        Number(args[1]),
        Number(args[2])
    ];

    let negativesCount = 0;

    for (let i = 0; i < numbers.length; i++){
        if (Number(numbers[i]) < 0) {
            negativesCount++;
        }
    }

    if (numbers.some(x => x === 0)) {
        console.log("Positive");
    } else if (negativesCount % 2 === 0) {
        console.log("Positive");
    } else {
        console.log("Negative");
    }
}

productOfThreeNumbers(['-3', '-4', '5']);