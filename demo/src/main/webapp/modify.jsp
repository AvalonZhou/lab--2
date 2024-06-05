<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.edu.hit.dao.StudentDao, cn.edu.hit.dao.impl.StudentDaoImpl" %>
<%@ page import="cn.edu.hit.entity.Student, java.util.List, java.util.ArrayList" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    String sid = request.getParameter("sid");
    StudentDao dao = new StudentDaoImpl();
    Student student = dao.getStudent(sid);
    String name = student.getName();
    int age = student.getAge();
    String birthday = student.getBirthday();
    String gender = student.getGender();
%>
<form action="student-servlet" method="post">
    <input type="hidden" name="action" value="modify"/>
    <table border="1">
        <tr>
            <td>学号</td>
            <td><input type="text" name="sid" value="<%=sid%>" readonly="true"/></td>
        </tr>

        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="<%=name%>"/></td>
        </tr>

        <tr>
            <td>性别</td>
            <td><input type="radio" name="gender" value="m"<%if(gender.equals("m")) out.print("checked");%>/>男
                <input type="radio" name="gender" value="f"<%if(gender.equals("f")) out.print("checked");%>/>女
            </td>
        </tr>

        <tr>
            <td>年龄</td>
            <td><input type="number" name="age" value="<%=age%>"/></td>
        </tr>

        <tr>
            <td>生日</td>
            <td><input type="date" name="birthday" value="<%=birthday%>"/></td>
        </tr>



        <tr>
            <td></td>
            <td><button type="">提交</button></td>
        </tr>
    </table>
</form>
</body>
</html>