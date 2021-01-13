package PeopleGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class DataGenerator {
    final static Random random = new Random();
    final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static String birthDate(int minAge, int maxAge) {
        Calendar calendar = new GregorianCalendar();
        int deltaDay = (int) (-365*(minAge + Math.random()*(maxAge-minAge)));
        calendar.add(Calendar.DATE, deltaDay);
        return dateFormat.format(calendar.getTime());
    }

    public static String snilsGenerator() {
        int one;
        int summ = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<9; i++) {
            one = random.nextInt(10);
            stringBuilder.append(one);
            summ += one * (9-i);

        }
        if (summ >= 100) {
            if (summ == 100 || summ == 101) summ = 0;
            else summ = summ % 101;
        }
        stringBuilder.append(String.format("%02d", summ));
        return stringBuilder.toString();
    }
}
