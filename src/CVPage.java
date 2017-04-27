/**
 * Created by ferenc on 2017.04.27..
 */
public class CVPage {

    public String generateMentorPage(String content) {
        String page = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n" +
                "    <title>Curriculum view</title>\n" +
                "\n" +
                "    <!-- Bootstrap -->\n" +
                "    <link rel=\"icon\" href=\"icon.png\">\n" +
                "    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/Master.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/Addpage.css\">\n" +
                "\n" +
                "    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n" +
                "    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n" +
                "    <!--[if lt IE 9]>\n" +
                "    <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n" +
                "    <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n" +
                "    <![endif]-->\n" +
                "</head>\n" +
                "\n" +
                "<body onload=\"loadAssignments()\">\n" +
                "\n" +
                "<nav class=\"navbar navbar-inverse\">\n" +
                "    <div class=\"container-fluid\">\n" +
                "\n" +
                "        <!-- Brand and toggle get grouped for better mobile display -->\n" +
                "        <div class=\"navbar-header\">\n" +
                "            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n" +
                "                <span class=\"sr-only\">Toggle navigation</span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "            </button>\n" +
                "            <a href=\"#\"><img class=\"brand\" src=\"icon.png\" alt=\"icon\"></a>\n" +
                "        </div>\n" +
                "\n" +
                "        <!-- Collect the nav links, forms, and other content for toggling -->\n" +
                "        <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" +
                "            <ul class=\"nav navbar-nav\">\n" +
                "                <li><a href=\"#\">Profile</a></li>\n" +
                "                <li class=\"active\"><a href=\"#\">CV <span class=\"sr-only\">(current)</span></a></li>\n" +
                "            </ul>\n" +
                "            <form class=\"navbar-form navbar-right\">\n" +
                "                <!-- <button type=\"button\" class=\"btn btn-primary\" onclick=\"addAssignment()\">Add assignment</button>\n" +
                "                <button type=\"submit\" class=\"btn btn-primary\">Add text page</button> -->\n" +
                "                <a href=\"AddAssignmentPage.html\"><button type=\"button\" class=\"btn btn-primary\">Add Assignment</button></a>\n" +
                "                <a href=\"AddTextPage.html\"><button type=\"button\" class=\"btn btn-primary\">Add Text Page</button></a>\n" +
                "            </form>\n" +
                "        </div><!-- /.navbar-collapse -->\n" +
                "\n" +
                "    </div><!-- /.container-fluid -->\n" +
                "</nav>\n" +
                "<div class=\"dragable_list\">\n" +
                "\n" +
                "    <ul id=\"assignmentList\">\n" +
                        content +
                "    </ul>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
                "<!-- Include all compiled plugins (below), or include individual files as needed -->\n" +
                "<script src=\"js/bootstrap.min.js\"></script>\n" +
                "<script src=\"js/Curriculum.js\"></script>\n" +
                "</body>\n" +
                "</html>";

        return page;
    }

    public String generateStudentPage(String content) {
        String page = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n" +
                "    <title>Curriculum view</title>\n" +
                "\n" +
                "    <!-- Bootstrap -->\n" +
                "    <link rel=\"icon\" href=\"icon.png\">\n" +
                "    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/Master.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/Addpage.css\">\n" +
                "\n" +
                "    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n" +
                "    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n" +
                "    <!--[if lt IE 9]>\n" +
                "    <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n" +
                "    <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n" +
                "    <![endif]-->\n" +
                "</head>\n" +
                "\n" +
                "<body onload=\"loadAssignments()\">\n" +
                "\n" +
                "<nav class=\"navbar navbar-inverse\">\n" +
                "    <div class=\"container-fluid\">\n" +
                "\n" +
                "        <!-- Brand and toggle get grouped for better mobile display -->\n" +
                "        <div class=\"navbar-header\">\n" +
                "            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n" +
                "                <span class=\"sr-only\">Toggle navigation</span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "            </button>\n" +
                "            <a href=\"#\"><img class=\"brand\" src=\"icon.png\" alt=\"icon\"></a>\n" +
                "        </div>\n" +
                "\n" +
                "        <!-- Collect the nav links, forms, and other content for toggling -->\n" +
                "        <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" +
                "            <ul class=\"nav navbar-nav\">\n" +
                "                <li><a href=\"#\">Profile</a></li>\n" +
                "                <li class=\"active\"><a href=\"#\">CV <span class=\"sr-only\">(current)</span></a></li>\n" +
                "            </ul>\n" +
                "        </div><!-- /.navbar-collapse -->\n" +
                "\n" +
                "    </div><!-- /.container-fluid -->\n" +
                "</nav>\n" +
                "<div class=\"dragable_list\">\n" +
                "\n" +
                "    <ul id=\"assignmentList\">\n" +
                        content +
                "    </ul>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
                "<!-- Include all compiled plugins (below), or include individual files as needed -->\n" +
                "<script src=\"js/bootstrap.min.js\"></script>\n" +
                "<script src=\"js/Curriculum.js\"></script>\n" +
                "</body>\n" +
                "</html>";

        return page;
    }
}
