function printKeyValues(args) {
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
            if (result[key]) {
                result[key].push(value);
            } else {
                result[key] = [value];
            }
        }
    }

    let keys = Object.keys(result);

    for (let k of keys) {
        if (k === key) {
            isKeyFound = true;
            for (let val of result[k]) {
                console.log(val);
            }
        }
    }

    if(!isKeyFound) {
        console.log('None');
    }
}

printKeyValues([
   '3 bla',
   '3 alb',
   '2'
]);