import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vajni on 2017.04.11..
 */
@WebServlet(name = "AddTextPageServlet")
public class AddTextPageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Files.copy(request.getInputStream(), Paths.get("/home/vajni/Codecool Projects/Web_Projects/LMS/BUF-LMSProject/web/JSON/request.json"), StandardCopyOption.REPLACE_EXISTING);
        List<Datacontainer> list = new ArrayList<Datacontainer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }

        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 3. Convert received JSON to Article
        Datacontainer datacontainer = mapper.readValue(json, Datacontainer.class);

        // 4. Set response type to JSON
        response.setContentType("application/json");

        // 5. Add article to List<Article>
        list.add(datacontainer);

        // 6. Send List<Article> as JSON to client
        mapper.writeValue(response.getOutputStream(), datacontainer);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

