import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamToFile {

    public void inputToFile(InputStream input, String outputPath) {

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            // read this file into InputStream
            inputStream = input;

            // write the inputStream to a FileOutputStream
            outputStream =
                    new FileOutputStream(new File(outputPath));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}