import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Zsolt on 2017.03.28..
 */
public class DataWriter {

    public void dataWriter(String name, String email, String password, String role, String path){

        try{
            FileWriter fw = new FileWriter(path, true);

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(name + "," + email + "," + password + "," + role);
            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dataWriter(String str, String path){

        try{
            FileWriter fw = new FileWriter(path, true);

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(str);
            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

