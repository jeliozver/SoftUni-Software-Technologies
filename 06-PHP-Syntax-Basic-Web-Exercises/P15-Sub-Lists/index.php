<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Sub-Lists</title>
    </head>
    <body>
        <form>
            N: <input type="text" name="num1" />
            M: <input type="text" name="num2" />
            <input type="submit" />
        </form>
        <ul>
            <?php
                if (isset($_GET['num1']) && isset($_GET['num2'])) {
                    $n = intval($_GET['num1']);
                    $m = intval($_GET['num2']);

                    if ($n > 0) {
                        for ($i = 1; $i <= $n; $i++) { ?>
                            <li> List <?php echo $i ?>
                                <ul>
                                    <?php
                                        for ($j = 1; $j <= $m; $j++) {
                                            echo "<li>Element $i.$j</li>";
                                        }
                                    ?>
                                </ul>
                            </li>
                    <?php } ?>
                <?php } ?>
            <?php } ?>
        </ul>
    </body>
</html>