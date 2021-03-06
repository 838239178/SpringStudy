<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>操作数据库的测试实例</title>
</head>
<body>
<%
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //隐式装载驱动程序
    String url = "jdbc:sqlserver://localhost:1433;database=testbase";
    String user = "sa"; //数据库的用户名
    String password = "sa"; //数据库的密码
    Connection conn = DriverManager.getConnection(url, user, password); //建立连接
    Statement stmt = conn.createStatement(); //创建Statment
    String sql = "select * from lesson"; //构造所要执行的SQL语句,dbo.person是tempdb数据库中的一个表
    ResultSet rs = stmt.executeQuery(sql); //执行sql语句并返回结果给所定义的结果集
%>x 
第一个字段 &nbsp;&nbsp;&nbsp; 第二个字段<br />
<%
    //下面通过循环把字段的内容显示出来
    while (rs.next()) {%>
       <%=rs.getString(1)%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <%=rs.getString(2)%>
       <%="<br />"%>
    <%}%>
<%="<br/>数据库操作成功!"%>
<%
    rs.close(); //关闭结果集
    stmt.close(); //关闭Statment
    conn.close(); //关闭连接
%>
</body>
</html>
