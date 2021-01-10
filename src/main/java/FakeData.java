import PeopleGenerator.NameGenerator;
import PeopleGenerator.Person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FakeData {

    public static void main(String[] args) {
        Person name;
        try {
            BufferedWriter csvWriter = new BufferedWriter(new FileWriter("data.csv"));
            for (int i = 1; i <= 1e6; i++) {
                name = new Person();
                csvWriter.write(name.toCSV());
                if (i % 1000 == 0) {
                    System.out.println("Создан пользователь " + i);
                    csvWriter.flush();
                }
            }
            csvWriter.flush();
            csvWriter.close();
        }
        catch (Exception ex) {
            System.out.println("Ошибка при создании: " + ex.getMessage());
        }
    }
}
