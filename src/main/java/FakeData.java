import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.*;

public class FakeData {
    final static private Logger LOG = Logger.getLogger("org.example.fake_generator");

    public static void main(String[] args) {
        try {
            setLoggerParams();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при создании логера");
            System.exit(1);
        }
        Person name;
        try {
            BufferedWriter csvWriter = new BufferedWriter(new FileWriter("data.csv"));
            for (int i = 1; i <= 1e6; i++) {
                name = new Person();
                csvWriter.write(name.toCSV());
                if (i % 1000 == 0) {
                    LOG.log(Level.FINE, "Создан пользователь #" + i);
                    csvWriter.flush();
                }
            }
            csvWriter.flush();
            csvWriter.close();
        }
        catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ошибка при создании: " + ex.getMessage());
            System.exit(1);
        }
    }

    private static void setLoggerParams() throws IOException {
        Handler consoleHandler;
        Handler fileHandler;
        LogFormatter formatter = new LogFormatter();
        LOG.setUseParentHandlers(false);

        //Консольный handler
        consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(formatter);
        Properties p = System.getProperties();
        String os = p.getProperty("os.name");

        // Файловый handler
        fileHandler = new FileHandler("./fake_generator.log", 1000000, 1);
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(formatter);

        // Кодирование файла в зависимости от ОС
        if (os.equals("Linux") | os.contains("Mac OS")) {
            consoleHandler.setEncoding("utf-8");
            fileHandler.setEncoding("utf-8");
        } else {
            consoleHandler.setEncoding("cp866");
            fileHandler.setEncoding("cp1251");
        }

        LOG.addHandler(consoleHandler);
        LOG.addHandler(fileHandler);
        LOG.setLevel(Level.FINE);

    }
}
