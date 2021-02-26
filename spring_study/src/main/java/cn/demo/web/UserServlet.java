package cn.demo.web;
import cn.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
@Controller
public class UserServlet extends HttpServlet {

//    @Autowired
//    private WebApplicationContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        assert context != null;
        String usrname = req.getParameter("usrname");
        String pwd = req.getParameter("pwd");
        System.out.println(usrname + ":" + pwd);
        UserService service = context.getBean(UserService.class);
        boolean success = service.login(usrname, pwd);
        PrintWriter writer = resp.getWriter();
        writer.write(String.format("{\"%s\"" + ":" + "\"%s\"}", "success", success));
        writer.close();
    }
}
