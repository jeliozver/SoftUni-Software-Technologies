<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Multiply a Number by Two</title>
    </head>
    <body>
        <form>
            N: <input type="text" name="num" />
            <input type="submit" />
        </form>
        <?php
            if (isset($_GET['num'])) {
                $number = floatval($_GET['num']);
                $result = $number * 2;
                echo $result;
            }
        ?>
    </body>
</html>