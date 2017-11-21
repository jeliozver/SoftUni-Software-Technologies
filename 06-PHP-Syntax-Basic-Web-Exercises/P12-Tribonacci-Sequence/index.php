<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Tribonacci-Sequence</title>
    </head>
    <body>
    <form>
        N: <input type="text" name="num" />
        <input type="submit" />
    </form>
    <?php
        function tribonacciN(int $n) :int {

            if ($n < 2) return 1;
            if ($n == 2) return 2;

            $tribNumOne = 1;
            $tribNumTwo = 1;
            $tribNumThree = 2;
            $tribNumNext = 0;

            for ($i = 0; $i < $n - 2; $i++) {

                $tribNumNext = $tribNumOne + $tribNumTwo + $tribNumThree;

                $tribNumOne = $tribNumTwo;
                $tribNumTwo = $tribNumThree;
                $tribNumThree = $tribNumNext;
            }

            return $tribNumNext;
        }

        if (isset($_GET['num'])) {

            $n = intval($_GET['num']);
            if ($n == 0) {
                echo 1;
                return;
            }

            for ($i = 0; $i < $n; $i++) {
                echo tribonacciN($i) . " ";
            }
        }
    ?>
    </body>
</html>