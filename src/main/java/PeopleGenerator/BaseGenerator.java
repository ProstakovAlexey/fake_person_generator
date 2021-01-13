package PeopleGenerator;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BaseGenerator {
    final private Logger LOG = Logger.getLogger("org.example.fake_generator");
    final Random random = new Random();
    private final List<String> man;
    private final List<String> women;
    private final int manListSize;
    private final int womenListSize;
    private static BaseGenerator instance;

    public BaseGenerator(String fileName) {
        LOG.log(Level.FINE, "Создаю генератор для " + fileName);
        man = new ArrayList<>();
        women = new ArrayList<>();
        loader(fileName);
        manListSize = man.size();
        womenListSize = women.size();
    }

    public String getRandom(Sex sex) {
        if (sex.equals(Sex.MAN)) {
            return man.get(random.nextInt(manListSize));
        }
        else {
            return women.get(random.nextInt(womenListSize));
        }
    }

    /*
    Load file with names from project resource path.
    Names will write in men and women ArraysList
     */
    private void loader(String fileName) {
        try {
            BufferedReader csvReader = new BufferedReader(new InputStreamReader(getFileFromResource(fileName)));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                if (data[1].equals("Ж")) women.add(data[0]);
                else man.add(data[0]);
            }
            csvReader.close();
        }
        catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error for data loading: " + ex.getMessage());
            System.exit(2);
        }
    }

    private InputStream getFileFromResource(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream(fileName);;
        if (resourceStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return resourceStream;
        }
    }
}
