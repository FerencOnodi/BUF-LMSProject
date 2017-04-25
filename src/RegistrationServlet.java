import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by ferenc on 2017.03.29..
 */
public class RegistrationServlet extends javax.servlet.http.HttpServlet {

    String name;
    String email;
    String password;
    String role;
    DataInsertion insertData = new DataInsertion();


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
        String path = request.getServletContext().getRealPath("/UserPassword.txt");

        this.name = request.getParameter("name");
        this.email = request.getParameter("email");
        this.password = request.getParameter("password");
        this.role = request.getParameter("role");

        try {
            insertData.insertUser(name,email,role,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");

        response.sendRedirect("/LoginPage.html");
    }
}