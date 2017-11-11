function threeIntegersSum(input) {

    let nums = input[0].split(' ');

    let numberOne = Number(nums[0]);
    let numberTwo = Number(nums[1]);
    let numberThree = Number(nums[2]);

    console.log(
        checkForSum(numberOne, numberTwo, numberThree) ||
        checkForSum(numberTwo, numberThree, numberOne) ||
        checkForSum(numberOne, numberThree, numberTwo) ||
        'No'
    );

    function checkForSum(first, second, sum) {
        if (first + second !== sum) {
            return false;
        }
        if (first > second) {
            [first, second] = [second, first];
        }

        return `${first} + ${second} = ${sum}`;
    }
}

threeIntegersSum(['8 15 7']);