package PeopleGenerator;

public class Person {
    private final String firstName;
    private final String family;
    private final String secondName;
    private final String birthDate;
    private final String snils;
    private final Sex sex;

    public Person() {
        NameGenerator nameGenerator = NameGenerator.getInstance();
        sex = Sex.generateRandomSex();
        firstName = nameGenerator.getName(sex);
        secondName = nameGenerator.getName(sex);
        family = nameGenerator.getName(sex);
        snils = DataGenerator.snilsGenerator();
        birthDate = DataGenerator.birthDate();
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
        return String.format("%s;%s;%s;%s;%s;%s\n", family, secondName, firstName, birthDate, sex, snils);
    }
}
