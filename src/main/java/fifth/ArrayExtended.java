package fifth;

public class ArrayExtended {

    private Object[] current = null;
    private int size = 0;

    public void addToArray(Object objectToAdd) {
        if (this.current == null) {
            Object[] temporary = new Object[1];
            temporary[0] = objectToAdd;
            this.current = temporary;
        } else {
            int numberOfObjects = this.size;
            Object[] temporary = new Object[numberOfObjects + 1];
            for (int i = 0; i < numberOfObjects; i++) {
                temporary[i] = this.current[i];
            }
            temporary[numberOfObjects] = objectToAdd;
            this.current = temporary;
        }
        this.size++;
    }

    public Object getFromArray(int index) {
        if ((index >= 0) & (index < this.size)) {
            return this.current[index];
        } else {
            return null;
        }
    }

    public int length(){
        return this.size;
    }
}
