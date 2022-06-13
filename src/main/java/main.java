public class main {
    public static void main(String[] args) {
        System.out.println(add_deposit(1000000, 500000));
        char_convert('П', -15);
        char_convert('A', 100);
        sheep_count(10000);
    }

    public static int add_deposit (int deposit, int income)
    {
        // что может пойти не так:
        // - переполнение суммарного счета
        // - некорректный ввод (отрицательное число)
        return deposit+income;
    }

    public static void char_convert(char init_char, int offset)
    {
        System.out.println( (char)(init_char + offset));
    }

    public static void sheep_count (int count)
    {
        System.out.println("Результат равен "+count+" овец");
    }


}
