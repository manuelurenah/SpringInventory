<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2><@spring.message "hello_msg" />, ${name}</h2><br /><br />
    <div>
        <p><@spring.message "change_locale_msg" />
            <a href="?lang=en"><@spring.message "default_lang_msg" /></a>|
            <a href="?lang=es"><@spring.message "spanish_lang_msg" /></a>
        </p>
    </div>
</body>
</html>