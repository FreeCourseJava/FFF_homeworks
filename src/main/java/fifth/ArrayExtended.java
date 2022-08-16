package fifth;

public class ArrayExtended {

    private Measureable[] current = null;
    private int size = 0;

    public void addToArray(Measureable objectToAdd) {
        if (this.current == null) {
            Measureable[] temporary = new Measureable[1];
            temporary[0] = objectToAdd;
            this.current = temporary;
        } else {
            int numberOfObjects = this.size;
            Measureable[] temporary = new Measureable[numberOfObjects + 1];
            if (numberOfObjects >= 0) {
                System.arraycopy(this.current, 0, temporary, 0, numberOfObjects);
            }
            temporary[numberOfObjects] = objectToAdd;
            this.current = temporary;
        }
        this.size++;
    }

    public Measureable getFromArray(int index) {
        if ((index >= 0) & (index < this.size)) {
            return this.current[index];
        } else {
            return null;
        }
    }

    public int length() {
        return this.size;
    }
}
