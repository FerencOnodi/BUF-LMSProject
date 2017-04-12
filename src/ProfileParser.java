import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ferenc on 2017.03.30..
 */
public class ProfileParser {
    ArrayList<String[]> usersData= new ArrayList<>();

    public void profileParser(String path) {

        String csvFile = path;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {

            String[] user = line.split(cvsSplitBy);

            usersData.add(user);

        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
