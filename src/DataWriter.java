import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Zsolt on 2017.03.28..
 */
public class DataWriter {

    public void dataWriter(String name, String email, String password, String role){

        try{
            FileWriter fw = new FileWriter("/home/ferenc/Desktop/Java/Web/Registration/UserPassword.txt", true);

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(name + "," + email + "," + password + "," + role);
            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

