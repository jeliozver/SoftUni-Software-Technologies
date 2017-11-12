function printingObjects(args) {
    let info = args
        .toString()
        .split(',');

    for (let i = 0; i < info.length; i++) {
        let infoSplit = info[i]
            .toString()
            .split(/ -> /);

        let name = infoSplit[0];
        let age = infoSplit[1];
        let grade = infoSplit[2];

        let obj = { name : name, age : age, grade : grade };

        console.log(`Name: ${obj.name}`);
        console.log(`Age: ${obj.age}`);
        console.log(`Grade: ${obj.grade}`);
    }
}

printingObjects([
    'Pesho -> 13 -> 6.00',
    'Ivan -> 12 -> 5.57',
    'Toni -> 13 -> 4.90'
]);