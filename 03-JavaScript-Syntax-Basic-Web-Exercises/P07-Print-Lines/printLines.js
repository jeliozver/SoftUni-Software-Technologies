function printLines(args) {
   var inputLines = args
       .toString()
       .split(',');

   for (let i = 0; i < inputLines.length; i++){
       if (inputLines[i] !== "Stop"){
           console.log(inputLines[i]);
       } else {
           break;
       }
   }
}

printLines([
    '3',
    '4',
    '5',
    '4',
    'Stop',
    '10',
    '12'
]);