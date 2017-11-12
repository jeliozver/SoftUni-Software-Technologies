function printValueOfGivenKey(args) {
    let info = args
        .toString()
        .split(',');
    
    let result = {};
    let key = '';
    let value = '';
    let isKeyFound = false;

    for (let i = 0; i < info.length; i++) {
        let infoSplit = info[i]
            .toString()
            .split(' ');

        key = infoSplit[0];
        value = infoSplit[1];

        if (value !== undefined) {
            result[key] = value;
        }
    }

    let keys = Object.keys(result);

    for (let k of keys) {
        if (k === key) {
            console.log(result[k]);
            isKeyFound = true;
        }
    }

    if(!isKeyFound) {
        console.log('None');
    }
}

printValueOfGivenKey([
    '3 bla',
    '3 alb',
    '2'
]);