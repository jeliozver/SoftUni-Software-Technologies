function objectToJSON(args) {
    let obj = {};
    let key = '';
    let value = '';

    args.forEach(string => {
        let kvp = string
            .toString()
            .split(/ -> /);

        key = kvp[0];
        if (isNaN(Number(kvp[1]))) {
            value = kvp[1];
        } else {
            value = Number(kvp[1]);
        }

        obj[key] = value;
    });
    
   let result = JSON.stringify(obj);
   console.log(result);
}

objectToJSON([
    'name -> Angel',
    'surname -> Georgiev',
    'age -> 20',
    'grade -> 6.00',
    'date -> 23/05/1995',
    'town -> Sofia'
]);