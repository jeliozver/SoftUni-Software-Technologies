<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Sum Two Numbers</title>
    </head>
    <body>
        <?php
            if (isset($_GET['num1']) && isset($_GET['num2'])) {
                $numOne = intval($_GET['num1']);
                $numTwo = intval($_GET['num2']);
                $result = $numOne + $numTwo;
                echo "$numOne + $numTwo = $result";
            }
        ?>
        <form>
            <div>First Number:</div>
            <input type="number" name="num1" />
            <div>Second Number:</div>
            <input type="number" name="num2 />
            <div><input type="submit" /></div>
        </form>
    </body>
</html>