import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Zsolt on 2017.03.28..
 */
public class DataValidator {

    public boolean dataValidator(String email, String password){

        File file = new File("/home/vajni/Codecool Projects/Web_Projects/LMS/BUF-LMSProject/UserPassword.txt");

        try {
            Scanner scanner = new Scanner(file);
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                if(line.contains(email) && line.contains(password)) {
                    return true;
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
