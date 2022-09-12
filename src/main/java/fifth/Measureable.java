package fifth;

public class Measureable {
    private int width;
    private int length;

    public Measureable(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int calcArea() {
        return length * width;
    }

    public int getWidth() {
        return width;
    }

    public int getLengthMeasureable() {
        return length;
    }


}
