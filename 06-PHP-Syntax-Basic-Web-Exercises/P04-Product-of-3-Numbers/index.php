<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Product of 3 Numbers</title>
    </head>
    <body>
        <form>
            X: <input type="text" name="num1" />
            Y: <input type="text" name="num2" />
            Z: <input type="text" name="num3" />
            <input type="submit" />
        </form>
        <?php
            if (isset($_GET['num1']) && isset($_GET['num2']) && isset($_GET['num3'])) {
                $numberOne = floatval($_GET['num1']);
                $numberTwo = floatval($_GET['num2']);
                $numberThree = floatval($_GET['num3']);
                $numbers = [$numberOne, $numberTwo, $numberThree];
                $negativesCount = 0;

                foreach ($numbers as $number) {
                    if ($number == 0) {
                        echo "Positive";
                        return;
                    }
                    if ($number < 0) {
                        $negativesCount++;
                    }
                }

                if ($negativesCount % 2 != 0) {
                    echo "Negative";
                } else {
                    echo "Positive";
                }
            }
    ?>
    </body>
</html>