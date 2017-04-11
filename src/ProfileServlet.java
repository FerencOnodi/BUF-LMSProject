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
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfileParser parser = new ProfileParser();
        parser.profileParser();

        String mail = (String)request.getAttribute("email");

        String name = "";
        String role = "";

        for(String[] data: parser.usersData ){
            if (data[1].equals(mail)) {
                name = data[0];
                role = data[3];
            }
        }

        PrintWriter out = response.getWriter();
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";
        request.setAttribute("role", role);
        out.println(docType +
                "<html lang=\"hu\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>" + name + "'s Profile" + "</title>\n" +
                "<link rel=\"stylesheet\" href=\"UserProfile.css\">\n" +
                "<link rel=\"icon\" href=\"icon.png\">\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Open+Sans\" rel=\"stylesheet\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"profile\">\n" +
                    "<p>" + "Name: " + name + "</p>\n" +
                    "<p>" + "Email: " + mail + "</p>\n" +
                    "<p>" + "Role: " + role + "</p>\n" +
                "<a href="+"\\" + "ListServlet?" +"role=" + role + "><input type=" + "\""+ "submit" + "\"" +
                ">" + "</a>" +
                "</div>\n" +
                "<a href="+"\\" + "AssPage.html><input type=" + "\""+ "submit" + "\"" +
                ">" + "</a>" +
                "</body>");
    }
}
