package ninth;

import fifth.Measureable;

public class Node {
    protected Measureable nodeValue;
    protected Node nodeLink;

    public Node(){
        nodeValue=null;
        nodeLink=null;
    }

    public Node(Measureable value) {
        nodeValue = value;
        nodeLink = null;
    }
}
