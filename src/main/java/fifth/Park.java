package fifth;

public class Park extends Measureable {
    private String name;


    public Park() {
        super(0, 0);
        this.name = "Nope";
    }

    public Park(String name, int length, int width) {
        super(length, width);
        this.name = name;
    }

}
