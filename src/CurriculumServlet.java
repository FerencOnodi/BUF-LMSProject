
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;


/**
 * Created by vajni on 2017.04.10..
 */
@WebServlet(name = "CurriculumServlet")
@MultipartConfig
public class CurriculumServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        Cookie[] cookie = request.getCookies();
        String cookieVal;
        for (Cookie suti : cookie){
            if (suti.getName().equals("user")){
                cookieVal = suti.getValue();
                InputStreamToFile toFile = new InputStreamToFile();
                String path = "/home/vajni/Codecool Projects/Web_Projects/LMS/BUF-LMSProject/web/Submissions/" + cookieVal +
                    "." + fileName.substring(fileName.length()-3);
                toFile.inputToFile(fileContent, path);
            }
        }

        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* List<Datacointer>list = new ArrayList<Datacontainer>();

        ObjectMapper om = new ObjectMapper;
        response.setContentType("application/json");
        om.writeValue(response.getOutputStream(),list);*/
    }
}
