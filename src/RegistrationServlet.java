import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ferenc on 2017.03.29..
 */
public class RegistrationServlet extends javax.servlet.http.HttpServlet {

    String name;
    String email;
    String password;
    String role;
    DataWriter dw = new DataWriter();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
        String path = request.getServletContext().getRealPath("/UserPassword.txt");

        this.name = request.getParameter("name");
        this.email = request.getParameter("email");
        this.password = request.getParameter("password");
        this.role = request.getParameter("role");

        dw.dataWriter(name, email, password, role, path);


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        /*PrintWriter printWriter = response.getWriter();
        printWriter.println(request.getParameter("name"));
        printWriter.println(request.getParameter("email"));
        printWriter.println(request.getParameter("password"));
        printWriter.println(request.getParameter("role"));*/
        response.sendRedirect("/LoginPage.html");
    }
}