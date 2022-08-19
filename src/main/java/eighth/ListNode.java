package eighth;

import fifth.Measureable;

public class ListNode {
    protected Measureable nodeValue;
    protected ListNode nodeLink;

    public ListNode(){
        nodeValue=null;
        nodeLink=null;
    }

    public ListNode(Measureable value) {
        nodeValue = value;
        nodeLink = null;
    }
}
