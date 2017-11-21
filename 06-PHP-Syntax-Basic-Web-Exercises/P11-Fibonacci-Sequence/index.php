<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Fibonacci-Sequence</title>
    </head>
    <body>
    <form>
        N: <input type="text" name="num" />
        <input type="submit" />
    </form>
    <?php
        function fibonacciN(int $n) :int {

            if ($n < 2) return 1;

            $fibNumOne = 1;
            $fibNumTwo = 1;
            $fibNumNext = 0;

            for ($i = 0; $i < $n - 1; $i++) {

                $fibNumNext = $fibNumOne + $fibNumTwo;

                $fibNumOne = $fibNumTwo;
                $fibNumTwo = $fibNumNext;
            }

            return $fibNumNext;
        }

        if (isset($_GET['num'])) {

            $n = intval($_GET['num']);

            for ($i = 0; $i < $n; $i++) {
                echo fibonacciN($i) . " ";
            }
        }
    ?>
    </body>
</html>