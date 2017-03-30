import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ferenc on 2017.03.30..
 */
@WebServlet(name = "ListServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = "";

        ProfileParser parser = new ProfileParser();
        parser.profileParser();

        String role = (String)request.getParameter("role");

        if(role.equals("Mentor")) {
            for(String[] data : parser.usersData ) {
                content += "Name: " + data[0] + "  Email: " + data[1] + "  Role: " + data[3] + "<br>";
            }
        } else {
            for(String[] data : parser.usersData ) {
                if(data[3].equals("Student")) {
                    content += "Name: " + data[0] + "  Email: " + data[1] + "  Role: " + data[3] + "<br>";
                }
            }
        }


        PrintWriter out = response.getWriter();
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";

        out.println(docType +
                "<html lang=\"hu\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>List of users</title>\n" +
                "<link rel=\"stylesheet\" href=\"ListPage.css\">\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Roboto+Slab\" rel=\"stylesheet\">\n" +
                "<link rel=\"icon\" href=\"icon.png\">\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Open+Sans\" rel=\"stylesheet\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"userbox\">\n" +
                "<p id=\"title\">List of users</p>\n" +
                "<p>" + content + "</p>\n" +
                "<a href=\"LoginPage.html\">Login Page</a>\n" +
                "</div>\n" +
                "</body>");
    }
}
