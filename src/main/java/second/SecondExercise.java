package second;

public class SecondExercise {
    public static void main(String[] args) {

        System.out.println(daysToMsecFromNow(-10));
        System.out.println(daysToMsecFromNow(Integer.MAX_VALUE));

        System.out.println(addDepositUpd(100000, 10000000));
        System.out.println(addDepositUpd(Integer.MAX_VALUE, 1));
        System.out.println(addDepositUpd(Integer.MIN_VALUE, -20));
    }

    private static long daysToMsecFromNow(int days) {
        long timeInMS = System.currentTimeMillis() + days * 24L * 60L * 60L * 1000L;
        return timeInMS;
    }

    private static int addDepositUpd(int deposit, int income) {
        long sumLong = (long) deposit + (long) income;
        int sumInt = deposit + income;
        if (sumLong == sumInt) {
            return sumInt;
        }
        return 0;

    }
}




