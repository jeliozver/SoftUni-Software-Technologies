<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Hello, Person!</title>
    </head>
    <body>
        <?php
            if (isset($_GET['person'])) {
                $personName = htmlspecialchars($_GET['person']);
                echo "Hello, $personName!";
            } else {
         ?>
           <form>
               Name: <input type="text" name="person" />
               <input type="submit" />
           </form>
        <?php } ?>
    </body>
</html>