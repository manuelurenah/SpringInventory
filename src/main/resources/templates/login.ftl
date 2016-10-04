<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <form role="form" action="/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <label for="username">Usuario</label>
            <input type="text" name="username" id="username" required autofocus>
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" required>
        </div>
        <div>
            <label for="remember-me">Recordar...</label>
            <input type="checkbox" name="remember-me" id="remember-me">
        </div>
        <button type="submit">Sign in</button>
    </form>
    <#if error??>
        <p>${error}</p>
        <p>usuario no existe....</p>
    </#if>
</body>
</html>