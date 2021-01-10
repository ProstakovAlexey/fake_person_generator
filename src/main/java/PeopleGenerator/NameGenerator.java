package PeopleGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameGenerator {
    final Random random = new Random();
    private final List<String> manNames;
    private final List<String> manFamilies;
    private final List<String> womenNames;
    private final List<String> womenFamilies;
    private static NameGenerator instance;


    public static synchronized NameGenerator getInstance() {
        if (instance == null) {
            instance = new NameGenerator();
        }
        return instance;
    }
    private NameGenerator() {
        manNames = new ArrayList<>();
        manFamilies = new ArrayList<>();
        womenNames = new ArrayList<>();
        womenFamilies = new ArrayList<>();
        loader();
    }

    public String getName(Sex sex) {
        if (sex.equals(Sex.MAN)) return manNames.get(random.nextInt(manNames.size()));
        else return womenNames.get(random.nextInt(womenNames.size()));
    }

    public String getFamile() {
        return manFamilies.get(random.nextInt(manFamilies.size()));
    }

    private void loader() {
        try {
            namesLoader();
        }
        catch (Exception ex) {
            System.out.println("Ошибка при загрузке данных " + ex.getMessage());
        }
    }

    private void namesLoader() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("dicts/russian_names.csv"));
        // Пропускаю первую, т.к. там заголовок
        String row = csvReader.readLine();
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(";");
            if (data[2].equals("Ж")) womenNames.add(data[1]);
            else manNames.add(data[1]);
        }
        csvReader.close();
    }


}
