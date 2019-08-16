<%--
  Created by IntelliJ IDEA.
  User: IS101_MaksimRozkov
  Date: 14.08.2019
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>

<div>
    <h1>Super app!</h1>
</div>

<div>
    <%
        if (request.getAttribute("errorName") == null && request.getAttribute("userName") != null) {
            out.println("<p>User '" + request.getAttribute("userName") + "' added!</p>");
        }else {
            if (request.getAttribute("errorName") != null) {
                out.println("<p>" + request.getAttribute("errorName") + "</p>");
            }
        }
    %>
    <div>
        <div>
            <h2>Add user</h2>
        </div>

        <form method="post">
            <label>Name:
                <input type="text" name="name"><br />
            </label>
            <label>Password:
                <input type="password" name="pass"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/index'">Back to main</button>
</div>
</body>
</html>
