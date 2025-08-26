package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomFileReader {
    /**
     * Used to read .properties file
     *
     * @param path the path to the file
     * @return the file in a Properties class as to access the different properties' values
     * <p>
     * Throws runtime exception as to stop the execution of the test
     */
    public Properties readPropFile(String path) {
        Properties prop = new Properties();
        try {
            prop.load(new FileReader(path));
        } catch (IOException e) {
            System.out.printf("Error while opening file: %s, exception %s%n", path, e);
        }
        return prop;
    }


    public File readFile(String path) {
        return new File(path);
    }

    public <T> T readJsonFile(String path, Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(new FileReader(path), tClass);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        return null;
    }


    public Object[][] getDataFormFile(String path) {
        List<Object[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(","); // Split by comma
                Object[] row = new Object[tokens.length];

                for (int i = 0; i < tokens.length; i++) {
                    String token = tokens[i].trim();
                    row[i] = Integer.parseInt(token);
                }
                dataList.add(row);
            }
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }

        Object[][] dataArray = dataList.toArray(new Object[0][]);

        return dataArray;
    }

}
