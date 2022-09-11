package ninth;

import fifth.Measureable;

public class ArrayExtendable implements MeasurableList {

    private Measureable[] current = null;

    @Override
    public void add(Measureable objectToAdd) {
        if (this.current == null) {
            Measureable[] temporary = new Measureable[1];
            temporary[0] = objectToAdd;
            this.current = temporary;
        } else {
            int numberOfObjects = this.current.length;
            Measureable[] temporary = new Measureable[numberOfObjects + 1];
            if (numberOfObjects >= 0) {
                System.arraycopy(this.current, 0, temporary, 0, numberOfObjects);
            }
            temporary[numberOfObjects] = objectToAdd;
            this.current = temporary;
        }
    }

    @Override
    public Measureable get(int index) {
        if ((this.current == null) || (index < 0) || (index >= this.current.length)) {
            return null;
        }
        return this.current[index];
    }

    @Override
    public boolean exists(Measureable objectToFind) {
        if (this.current == null) {
            return false;
        }
        for (int i = 0; i < this.current.length; i++) {
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
        for (int i = 0; i < this.current.length; i++) {
            if (objectToFind == this.current[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if ((this.current == null) || (index < 0) || (index > (this.current.length - 1))) {
            return;
        }
        Measureable[] temporary = new Measureable[this.current.length - 1];
        System.arraycopy(this.current, 0, temporary, 0, index);
        System.arraycopy(this.current, index + 1, temporary, index, (this.current.length - 1 - index));
        this.current = temporary;
    }

    @Override
    public void remove(Measureable measureable) {
        if (exists(measureable)) {
            int i = getIndex(measureable);
            remove(i);
        }
    }

    @Override
    public int length() {
        if (this.current == null) {
            return 0;
        }
        return this.current.length;
    }
}
