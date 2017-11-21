<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Extract Capital-Case Words</title>
    </head>
    <body>
        <?php
           if (isset($_GET['text'])) {
               $text = $_GET['text'];

               preg_match_all('/\w+/', $text, $words);
               $words = $words[0];

               $uppercaseWords = array_filter($words, function($word) {
                   return strtoupper($word) == $word;
               });
               echo implode(", ", $uppercaseWords);
           }
        ?>
        <form>
            <textarea rows="10" name="text"></textarea>
            <br />
            <input type="submit" value="Extract">
        </form>
    </body>
</html>