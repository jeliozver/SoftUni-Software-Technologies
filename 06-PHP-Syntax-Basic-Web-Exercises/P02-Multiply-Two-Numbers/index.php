<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Multiply Two Numbers</title>
    </head>
    <body>
        <form>
            N: <input type="text" name="num1" />
            M: <input type="text" name="num2" />
            <input type="submit" />
        </form>
        <?php
            if (isset($_GET['num1']) && isset($_GET['num2'])) {
                $numberOne = floatval($_GET['num1']);
                $numberTwo = floatval($_GET['num2']);
                $result = $numberOne * $numberTwo;
                echo $result;
            }
        ?>
    </body>
</html>