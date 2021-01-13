import PeopleGenerator.*;

public class Person {
    private final String firstName;
    private final String family;
    private final String secondName;
    private final String birthDate;
    private final String snils;
    private final Sex sex;

    public Person() {
        sex = Sex.generateRandomSex();
        firstName = FirstNameGenerator.getInstance().getRandom(sex);
        secondName = SecondNameGenerator.getInstance().getRandom(sex);
        family = FamilyGenerator.getInstance().getRandom(sex);
        snils = DataGenerator.snilsGenerator();
        birthDate = DataGenerator.birthDate(20, 70);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", family='" + family + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", snils='" + snils + '\'' +
                '}';
    }

    public String toCSV() {
        return String.format("%s;%s;%s;%s;%s;%s\n", family, firstName, secondName, birthDate, sex, snils);
    }
}
