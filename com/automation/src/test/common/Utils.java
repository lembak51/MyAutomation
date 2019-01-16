package common;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Calendar;
import java.util.Random;

public class Utils {

    public static String getSystemName(){
        return System.getProperty("os.name");
    }

    /**
     * Generates a random string.
     *
     * @param length how many characters the string should be.
     * @return a randomly generated string `length` characters long.
     */
    public static String getRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }

    /**
     * Gets a random integer.
     */
    public static int getRandomInteger(int max){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(max);
    }

    public static int getRandomInt(int min, int max){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(max + 1 - min) + min;
    }

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (Exception ignored) {
        }
    }

    public static Calendar calendar = Calendar.getInstance();

    public static String getMonth(){
        int currentMonth = calendar.get(Calendar.MONTH);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String Month = months[currentMonth];

        return Month;
    }

    public static String getNextMonth(){
        int currentMonth = calendar.get(Calendar.MONTH);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String Month = months[currentMonth + 1];

        return Month;
    }

    public static String getNextThirdMonth(){
        int currentMonth = calendar.get(Calendar.MONTH);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String Month = months[currentMonth + 3];

        return Month;
    }

    public static String getNextSecondMonth(){
        int currentMonth = calendar.get(Calendar.MONTH);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String Month = months[currentMonth + 2];

        return Month;
    }

    public static String getPreviuosMonth(){
        int currentMonth = calendar.get(Calendar.MONTH);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String Month = months[currentMonth - 1];

        return Month;
    }

    public static int getDay(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getYear(){
        return calendar.get(Calendar.YEAR);
    }

    public static int getStartDay(){
        int StartDay = getDay();
        if (StartDay > 15) {
            StartDay = StartDay - 14;
        }
        return StartDay;
    }

    public static int getYesterdayDay(){
        return getDay() - 1;
    }

    public static int getEndDay(){
        int EndDay = getDay();
        if (EndDay <= 15) {
            EndDay = EndDay + 14;
        }
        return EndDay;
    }

    public static int getTime(){
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
}