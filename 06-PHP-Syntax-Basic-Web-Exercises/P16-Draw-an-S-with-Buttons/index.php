<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Draw-an-S-with-Buttons</title>
    </head>
    <body>
        <?php
            for ($i = 1; $i <= 9; $i++) {
                for ($j = 1; $j <= 5; $j++) {
                    if ($i == 1 || $i == 5 || $i == 9) {
                        echo "<button style='background-color: blue'>1</button>";
                    } else if ($i == 2 || $i == 3 || $i == 4) {
                        if ($j == 1) {
                            echo "<button style='background-color: blue'>1</button>";
                        } else {
                            echo "<button>0</button>";
                        }

                    } else {
                        if ($j == 5) {
                            echo "<button style='background-color: blue'>1</button>";
                        } else {
                            echo "<button>0</button>";
                        }
                    }
                }
                echo "<br .>";
            }
        ?>
    </body>
</html>