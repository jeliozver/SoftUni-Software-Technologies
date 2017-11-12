function addOrRemove(args) {
    let info = args
        .toString()
        .split(',');

    let result = [];

    for (let i = 0; i < info.length; i++) {

        let infoSplit = info[i]
            .toString()
            .split(' ');

        let command = infoSplit[0];
        let index = Number(infoSplit[1]);

        if (command === "add") {
            result.push(index);
        } else {
            if (index > 0 || index <= result.length - 1) {
                result.splice(index, 1);
            }
        }
    }

    for (let number of result) {
        console.log(number);
    }
}

addOrRemove([
    'add 3',
    'add 5',
    'remove 2',
    'remove 0',
    'add 7'
]);