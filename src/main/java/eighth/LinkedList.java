package eighth;

import fifth.Measureable;

public class LinkedList {

    private ListNode headOfList;
    private int sizeOfList;

    public LinkedList() {
        headOfList = new ListNode();
        sizeOfList = 0;
    }

    public int getSize() {
        return this.sizeOfList;
    }

    public void addNode(Measureable valueToAdd) {
        if (headOfList.nodeValue == null) {
            headOfList.nodeValue = valueToAdd;
        } else {
            ListNode temp = new ListNode(valueToAdd);
            temp.nodeLink = headOfList;
            headOfList = temp;
        }
        sizeOfList++;
    }

    public Measureable getNode(int index) {
        ListNode temp = headOfList;
        if ((index < 0) & (index > sizeOfList)) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.nodeLink;
        }
        return temp.nodeValue;
    }

}
