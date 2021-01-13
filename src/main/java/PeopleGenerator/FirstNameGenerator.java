package PeopleGenerator;

public class FirstNameGenerator extends BaseGenerator {
    private static FirstNameGenerator instance;

    private FirstNameGenerator() {
        super("firstName.csv");
    }

    public static synchronized FirstNameGenerator getInstance() {
        if (instance == null) {
            instance = new FirstNameGenerator();
        }
        return instance;
    }
}
