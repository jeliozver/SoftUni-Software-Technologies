<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>N-Factorial</title>
    </head>
    <body>
    <form>
        N: <input type="text" name="num" />
        <input type="submit" />
    </form>
    <?php
        if (isset($_GET['num'])) {
            function calculateFactorial (int $n) :int {
                $factorial = 1;

                while ($n > 1)
                {
                    $factorial *= $n;
                    $n--;
                }

                return $factorial;
            }

            $n = intval($_GET['num']);
            echo calculateFactorial($n);
        }
    ?>
    </body>
</html>