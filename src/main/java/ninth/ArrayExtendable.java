package ninth;

import fifth.Measureable;

public class ArrayExtendable implements MeasurableList {

    private Measureable[] current = null;
    private int size = 0;

    @Override
    public void add(Measureable objectToAdd) {
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

    @Override
    public Measureable get(int index) {
        if ((index >= 0) && (index < this.size)) {
            return this.current[index];
        } else {
            return null;
        }
    }

    @Override
    public boolean exists(Measureable objectToFind) {
        if (this.current == null) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (objectToFind == this.current[i]) {
                return true;
            }
        }
        return false;
    }

    private int getIndex(Measureable objectToFind) {
        if (this.current == null) {
            return -1;
        }
        for (int i = 0; i < this.size; i++) {
            if (objectToFind == this.current[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if ((index < 0) || (index > (this.size - 1)) || (this.current == null)) {
            return;
        }
        Measureable[] temporary = new Measureable[this.size - 1];
        System.arraycopy(this.current, 0, temporary, 0, index);
        System.arraycopy(this.current, index + 1, temporary, index, (this.size - 1 - index));
        this.current = temporary;
        this.size--;
    }

    @Override
    public void remove(Measureable measureable) {
        if (exists(measureable)) {
            int i = getIndex(measureable);
            remove(i);
        }
    }


    public int length() {
        return this.size;
    }
}
