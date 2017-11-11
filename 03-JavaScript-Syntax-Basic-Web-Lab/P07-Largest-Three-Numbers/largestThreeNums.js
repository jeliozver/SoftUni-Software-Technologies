function findLargestThreeNumbers(args) {
    let nums = args.map(Number);
    let numsSorted = nums.sort((a, b) => b - a);
    let count = Math.min(3, args.length);

    for (let i = 0; i < count; i++) {
        console.log(numsSorted[i]);
    }
}

findLargestThreeNumbers([
    '10',
    '30',
    '15',
    '20',
    '50',
    '5'
]);