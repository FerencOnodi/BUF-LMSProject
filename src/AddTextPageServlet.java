import com.sun.org.apache.xpath.internal.SourceTree;
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

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/

        }
        ObjectMapper om = new ObjectMapper();
        AssignmentElement ae = om.readValue(jb.toString(), AssignmentElement.class);
        //DataWriter dw = new DataWriter();
        //dw.dataWriter(jb.toString(), "/home/vajni/Codecool Projects/Web_Projects/lofasz/BUF-LMSProject/web/Submissions/Assignments.txt");


       /* BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        System.out.println(json);
        DataWriter dw = new DataWriter();
        dw.dataWriter(json, "/home/vajni/Codecool Projects/Web_Projects/lofasz/BUF-LMSProject/web/Submissions/Assignments.txt");
    */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*DataParser dp = new DataParser();

        try (BufferedReader br = new BufferedReader(new FileReader("/home/vajni/Codecool Projects/Web_Projects/lofasz/BUF-LMSProject/web/Submissions/Assignments.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                dp.stringToMap(line);
            }
        }*/

        BufferedReader br = new BufferedReader(new FileReader("/home/vajni/Codecool Projects/Web_Projects/lofasz/BUF-LMSProject/web/AssignmentData/Assignments.txt"));
        StringBuffer sb = new StringBuffer();
        String json = "";
        while ((json = br.readLine()) != null) {
            sb.append(json);
        }
        br.close();

        ObjectMapper om = new ObjectMapper();
        String jsonString = om.writeValueAsString(sb.toString());

        PrintWriter out = response.getWriter();
        out.print(jsonString);
    }
}


