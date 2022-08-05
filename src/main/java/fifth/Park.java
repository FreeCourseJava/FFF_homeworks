package fifth;

public class Park {
    String name;
    int length;
    int width;

    public Park() {
        this.name = "Nope";
        this.length = 0;
        this.width = 0;
    }

    public Park(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public int calcParkArea(){
        return this.length*this.width;
    }

}
