package PeopleGenerator;

public class FamilyGenerator extends BaseGenerator {
    private static FamilyGenerator instance;

    private FamilyGenerator() {
        super("familyName.csv");
    }

    public static synchronized FamilyGenerator getInstance() {
        if (instance == null) {
            instance = new FamilyGenerator();
        }
        return instance;
    }
}
