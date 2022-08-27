package ninth;

import fifth.Measureable;

public class ListLinked implements MeasurableList {

    private Node headOfList;
    private int sizeOfList;

    public ListLinked() {
        headOfList = new Node();
        sizeOfList = 0;
    }

    public int getSize() {
        return this.sizeOfList;
    }

    @Override
    public void add(Measureable valueToAdd) {
        if (headOfList.nodeValue == null) {
            headOfList.nodeValue = valueToAdd;
        } else {
            Node temp = new Node(valueToAdd);
            temp.nodeLink = headOfList;
            headOfList = temp;
        }
        sizeOfList++;
    }

    @Override
    public Measureable get(int index) {
        Node temp = headOfList;
        if (((index < 0) || (index > sizeOfList)) || (headOfList.nodeValue == null)) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.nodeLink;
        }
        return temp.nodeValue;
    }

    @Override
    public boolean exists(Measureable measureable) {
        Node temp = headOfList;
        for (int i = 0; i < sizeOfList; i++) {
            if (temp.nodeValue == measureable) {
                return true;
            }
            temp = temp.nodeLink;
        }
        return false;
    }

    private int getIndex(Measureable measureable) {
        Node temp = headOfList;
        for (int i = 0; i < sizeOfList; i++) {
            if (temp.nodeValue == measureable) {
                return i;
            }
            temp = temp.nodeLink;
        }
        return -1;
    }

    @Override
    public void remove(Measureable measureable) {
        if (exists(measureable)) {
            int i = getIndex(measureable);
            remove(i);
        }
    }

    @Override
    public void remove(int index) {
        Node temp = headOfList;
        Node temp2 = temp;
        if (((index < 0) || (index > sizeOfList)) || (headOfList.nodeValue == null)) {
            return;
        }
        for (int i = 0; i < (index - 1); i++) {
            temp = temp.nodeLink;
        }
        if (index == sizeOfList) {
            temp2.nodeLink = null;
        } else {
            for (int i = 0; i < index; i++) {
                temp2 = temp2.nodeLink;
            }
        }
        temp.nodeLink = temp2.nodeLink;
        sizeOfList--;
    }
}
