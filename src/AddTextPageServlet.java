import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by vajni on 2017.04.11..
 */
@WebServlet(name = "AddTextPageServlet")
public class AddTextPageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Files.copy(request.getInputStream(), Paths.get("/home/vajni/Codecool Projects/Web_Projects/LMS/BUF-LMSProject/web/JSON/request.json"), StandardCopyOption.COPY_ATTRIBUTES);
        
    }
}

