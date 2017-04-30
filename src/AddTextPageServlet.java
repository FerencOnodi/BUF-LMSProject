import com.sun.org.apache.xpath.internal.SourceTree;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vajni on 2017.04.11..
 */
@WebServlet(name = "AddTextPageServlet")
public class AddTextPageServlet extends HttpServlet {

    String title;
    String content;
    int maxPoints = 0;
    int score = 0;
    String subReq = "no";
    String published;
    DataInsertion dataInsertion = new DataInsertion();
    DataSelection dataSelection = new DataSelection();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
        Cookie[] cookies = request.getCookies();
        String username = cookies[1].getValue().replace("_", " ");

        int id = 0;
        try {
            id = Integer.parseInt(dataSelection.selectDataByHeader("UserID", "user", "UserName", username));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.title = request.getParameter("title");
        this.content = request.getParameter("content");
        this.published = request.getParameter("published");

        try {
            dataInsertion.insertAssignment(title, content, maxPoints, score, subReq, published, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //VAJNI RÉSZE VAN INNENTŐL
        /*StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/

        /*}
        ObjectMapper om = new ObjectMapper();
        AssignmentElement ae = om.readValue(jb.toString(), AssignmentElement.class);

        System.out.println(ae.toString());*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.sendRedirect("/CVServlet");

        //VAJNI RÉSZE VAN INNENTŐL
        /*BufferedReader br = new BufferedReader(new FileReader("/home/vajni/Codecool Projects/Web_Projects/lofasz/BUF-LMSProject/web/AssignmentData/Assignments.txt"));
        StringBuffer sb = new StringBuffer();
        String json = "";
        while ((json = br.readLine()) != null) {
            sb.append(json);
        }
        br.close();
        response.setContentType("application/json");

        ObjectMapper om = new ObjectMapper();
        //om.writeValue(response.getOutputStream(),list goes here);*/

    }
}


