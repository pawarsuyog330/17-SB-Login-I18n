<%@page import="java.time.LocalDateTime"%>
<h2>Hello ${user}, <br>
Login Status: Success <br>
Login Time: <%= java.time.LocalDateTime.now() %>
</h2>