package PeopleGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class DataGenerator {
    // getTime получает с 1970 года
    final static long endDate = new Date().getTime();
    final static Random random = new Random(endDate);
    final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    static String birthDate() {
        long now = ThreadLocalRandom.current().nextLong(0, endDate);
        return dateFormat.format(new Date(now));
    }

    static String snilsGenerator() {
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
