package PeopleGenerator;

public class SecondNameGenerator extends BaseGenerator {
    private static SecondNameGenerator instance;

    private SecondNameGenerator() {
        super("secondName.csv");
    }

    public static synchronized SecondNameGenerator getInstance() {
        if (instance == null) {
            instance = new SecondNameGenerator();
        }
        return instance;
    }
}
