public class second_exercise {
    public static void main(String[] args) {
        System.out.println(daysToMsecFromNow(-10L));
        System.out.println(daysToMsecFromNow(2000L));
        System.out.println(addDepositUpd(100000, 10000000));
        System.out.println(addDepositUpd(Integer.MAX_VALUE, 1));
        System.out.println(addDepositUpd(Integer.MIN_VALUE, -20));
        }

    private static int addDepositUpd(int deposit, int income) {
        boolean flag = true;
        int sum = deposit + income;
        if (deposit > 0 & income > 0 & sum < 0) flag = false;
        if (deposit < 0 & income < 0 & sum > 0) flag = false;
        return flag ? sum : 0;
    }

        private static long daysToMsecFromNow(long days) {
            long currentMs = System.currentTimeMillis();
            return currentMs + days * 24L * 60L * 60L * 1000L;
        }
    }


