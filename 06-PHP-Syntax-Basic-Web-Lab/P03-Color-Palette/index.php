<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Color Palette</title>
        <style>
            div {
                display: inline-block;
                width: 150px;
                padding: 2px;
                margin: 5px;
            }
        </style>
    </head>
    <body>
        <?php
            for ($red = 0; $red <= 255; $red += 51) {
                for ($green = 0; $green <= 255; $green += 51) {
                    for ($blue = 0; $blue <= 255; $blue += 51) {
                        echo "<div style='background:rgb($red, $green, $blue)'>
                                    rgb($red, $green, $blue)
                             </div>";
                    }
                }
            }
        ?>
    </body>
</html>