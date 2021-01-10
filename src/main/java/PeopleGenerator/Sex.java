package PeopleGenerator;

import java.util.Random;

public enum Sex {
    MAN,
    WOMAN;

    public static Sex generateRandomSex() {
        Sex[] values = Sex.values();
        int randIndex = new Random().nextInt(values.length);
        return values[randIndex];
    }
}
