<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>50-Shades-of-Grey</title>
        <style>
            div {
                display: inline-block;
                margin: 5px;
                width: 20px;
                height: 20px;
            }
        </style>
    </head>
    <body>
        <?php
            for ($i = 0; $i < 255; $i += 51) {
                $inc = $i;
                    for ($j = 0; $j < 10; $j++) {
                        echo "<div style='background-color:rgb($inc, $inc, $inc)'></div>";
                        $inc += 5;
                    }
               echo "<br />";
            }
        ?>
    </body>
</html>