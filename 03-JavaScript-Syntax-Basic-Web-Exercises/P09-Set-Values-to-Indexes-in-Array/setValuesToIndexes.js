function setValuesToIndexes(args) {
    let info = args
        .toString()
        .split(',');

    let arrLenght = Number(info[0]);
    let result = Array(arrLenght).fill(0);
    info.shift();

    for (let i = 0; i < info.length; i++) {
        let indexValue = info[i]
            .toString()
            .split(/ - /);

        let index = Number(indexValue[0]);
        let value = Number(indexValue[1]);
        result[index] = value;
    }

    for (let number of result) {
        console.log(number);
    }
}

setValuesToIndexes(['5', '0 - 3', '3 - -1', '4 - 2']);