public class second_exercise {
    public static void main(String[] args) {
        System.out.println(daysToMsecFromNow(-10L));
        System.out.println(daysToMsecFromNow(Long.MAX_VALUE));
        System.out.println(addDepositUpd(100000, 10000000));
        System.out.println(addDepositUpd(Integer.MAX_VALUE, 1));
        System.out.println(addDepositUpd(Integer.MIN_VALUE, -20));
    }

    private static int addDepositUpd(int deposit, int income) {
        boolean isOwerflow = true;
        if (Math.abs((long)deposit+(long)income)>Integer.MAX_VALUE) isOwerflow = false;
        return isOwerflow ? (deposit + income) : 0;
    }

    private static long daysToMsecFromNow(long days) {
        long timeInMS = System.currentTimeMillis() + days * 24L * 60L * 60L * 1000L;
        long overFlawCrit=(Long.MAX_VALUE-System.currentTimeMillis())/(24L * 60L * 60L * 1000L);
        return (days>overFlawCrit)? 0:timeInMS;
        }
    }



