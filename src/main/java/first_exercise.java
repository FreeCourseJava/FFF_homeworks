public class first_exercise {
    public static void main(String[] args) {
        System.out.println(addDeposit(1000000, 500000));
        charConvert('П', -15);
        charConvert('A', 100);
        sheepCount(10000);
        }

    public static int addDeposit (int deposit, int income)
    {
        // что может пойти не так:
        // - переполнение суммарного счета
        // - некорректный ввод (отрицательное число)
        return deposit+income;
    }

    public static void charConvert(char init_char, int offset)
    {
        System.out.println( (char)(init_char + offset));
    }

    public static void sheepCount (int count)
    {
        System.out.println("Результат равен "+count+" овец");
    }


}
