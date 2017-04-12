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
        String path = request.getServletContext().getRealPath("/UserPassword.txt");
        parser.profileParser(path);

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
                    "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" +

                    "<title>" + name + "'s Profile" + "</title>\n" +
                    "<link rel=\"icon\" href=\"icon.png\">\n" +
                    "<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">" +
                    "<link rel=\"stylesheet\" href=\"css/Master.css\"><!-- MASTER -->\n" +
                    "<link rel=\"stylesheet\" href=\"css/UserProfile.css\"/><!-- LOGIN -->" +
                "</head>\n" +

                "<body>\n" +
                "<nav class=\"navbar navbar-inverse navbar-fixed-top\">\n" +
                        "        <div class=\"container-fluid\">\n" +
                        "            <!-- Brand and toggle get grouped for better mobile display -->\n" +
                        "            <div class=\"navbar-header\">\n" +
                        "                <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n" +
                        "                    <span class=\"sr-only\">Toggle navigation</span>\n" +
                        "                    <span class=\"icon-bar\"></span>\n" +
                        "                    <span class=\"icon-bar\"></span>\n" +
                        "                    <span class=\"icon-bar\"></span>\n" +
                        "                </button>\n" +
                        "                <a href=\"#\"><img class=\"brand\" src=\"icon.png\" alt=\"icon\"></a>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <!-- Collect the nav links, forms, and other content for toggling -->\n" +
                        "            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" +
                        "                <ul class=\"nav navbar-nav\">\n" +
                        "                    <li class=\"active\"><a href=\"#login\">My profile<span class=\"sr-only\">(current)</span></a></li>\n" +
                        "                    <li><a href=\"#\">CV</a></li>\n" +
                        "                    <li><a href=" + "\\" + "ListServlet?" + "role=" + role + ">Users</a></li>\n" +
                        "                </ul>\n" +
                        "                <form action=\"LoginPage.html\" class=\"navbar-form navbar-right\">" +
                        "                   <button type=\"submit\" class=\"btn btn-primary\">Log out</button>" +
                        "                </form>" +
                        "            </div><!-- /.navbar-collapse -->\n" +
                        "        </div><!-- /.container-fluid -->\n" +
                        "    </nav><!-- END OF NAVBAR -->" +

                "<div class=\"profile\">\n" +
                    "<table class=\"table table-hover\">" +
                        "<tr>\n" +
                            "<th>Name:</th>\n" +
                            "<td>" + name + "</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                            "<th>Email:</th>\n" +
                            "<td>" + mail + "</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                            "<th>Role:</th>\n" +
                            "<td>" +role + "</td>\n" +
                        "</tr>\n" +
                    "</table>" +
                    "<a href="+"\\" + "ListServlet?" +"role=" + role + "><input type=" + "\""+ "submit" + "\"" +
                    "value=" + "\"" + "List users" + "\"" + ">" + "</a>" +
                "</div>\n" +

                "<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
                "<!-- Include all compiled plugins (below), or include individual files as needed -->\n" +
                "<script src=\"js/bootstrap.min.js\"></script>" +

                "</body>");
    }
}
