function symmetricNumbers(input) {
    let n = Number(input[0]);
    let result = '';

    for (let i = 1; i <= n; i++) {
        if (isPalindrome(i)) {
            result += i + " ";
        }
    }

    console.log(result);

    function isPalindrome(num) {

        let n = parseInt(num);
        let rev = 0;

        while (num > 0) {
            let dig = parseInt(num % 10);
            rev = parseInt(rev * 10 + dig);
            num = parseInt(num / 10);
        }

        if (n === rev) {
            return true;
        }

        return false;
    }
}

symmetricNumbers(['750']);