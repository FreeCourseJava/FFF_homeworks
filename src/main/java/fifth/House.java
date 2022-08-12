package fifth;

public class House extends Measureable {
    private int number;

    public House(int number) {
        super(10, 100);
        this.number = number;
    }

    public House(int number, int length, int width) {
        super(length, width);
        this.number = number;
    }

}
