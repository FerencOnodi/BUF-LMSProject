import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

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

        Cookie[] cookies = request.getCookies();
        String cookieRole = cookies[2].getValue();
        DataParser dd = new DataParser();
        List<List<String>> usersData = null;

        if(cookieRole.equals("Mentor")) {
            try {
                usersData = dd.listDataParser("Mentor");
                for (List element : usersData){
                    content += "<tr><td>" + element.get(0) + "</td><td>" + element.get(1) +
                            "</td><td>" + element.get(2) + "</td></tr><br>";}
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            try {
                usersData = dd.listDataParser("Student");
                for (List element : usersData){
                    content += "<tr><td>" + element.get(0) + "</td><td>" + element.get(1) +
                            "</td><td>" + element.get(2) + "</td></tr><br>";}
            } catch (SQLException e) {
                e.printStackTrace();
            }


        PrintWriter out = response.getWriter();

        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";

        out.println(docType +
                "<html lang=\"hu\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" +

                "<title>" + "User list" + "</title>\n" +
                "<link rel=\"icon\" href=\"icon.png\">\n" +
                "<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">" +
                "<link rel=\"stylesheet\" href=\"css/Master.css\"><!-- MASTER -->\n" +
                "<link rel=\"stylesheet\" href=\"css/ListPage.css\"/><!-- LOGIN -->" +
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
                "                    <li><a href=\"#\">My Profile</a></li>\n" +
                "                    <li><a href=\"CVPage.html\">CV</a></li>\n" +
                "                    <li class=\"active\"><a href=\"#\">Users<span class=\"sr-only\">(current)</span></a></li>\n" +
                "                </ul>\n" +
                "                <form action=\"LoginPage.html\" class=\"navbar-form navbar-right\">" +
                "                   <button type=\"submit\" class=\"btn btn-primary\">Log out</button>" +
                "                </form>" +
                "            </div><!-- /.navbar-collapse -->\n" +
                "        </div><!-- /.container-fluid -->\n" +
                "    </nav><!-- END OF NAVBAR -->" +

                "<table align=\"center\"><th id=\"title\" colspan=3>List of users</th>" +
                        "<tr><td><strong>Name: </strong>" + "</td><td><strong>Email: </strong>" +
                        "</td><td><strong>Role: </strong>" + "</td></tr><br>" +
                content +
                        "</table>" +

                "<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
                "<!-- Include all compiled plugins (below), or include individual files as needed -->\n" +
                "<script src=\"js/bootstrap.min.js\"></script>" +
                "</body>");
    }
}}
