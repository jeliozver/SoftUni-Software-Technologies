<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Prime-Numbers-from-N-to-1</title>
    </head>
    <body>
    <form>
        N: <input type="text" name="num" />
        <input type="submit" />
    </form>
        <?php
            function isPrime(int $n) :bool {
                if ($n < 2) return false;

                for ($i = 2; $i <= sqrt($n) ; $i++) {
                    if ($n % $i == 0) return false;
                }

                return true;
            }

            if (isset($_GET['num'])) {

                $n = intval($_GET['num']);

                for ($i = $n; $i >= 1; $i--) {

                    if (isPrime($i) == true) {
                        echo $i . " ";
                    }
                }
            }
        ?>
    </body>
</html>