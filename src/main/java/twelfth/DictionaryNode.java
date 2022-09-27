package twelfth;

public class DictionaryNode<KEY, VALUE> {
    public KEY key;
    public VALUE value;

    public DictionaryNode link;

    public DictionaryNode() {
        key = null;
        value = null;
        link = null;
    }

    public DictionaryNode(KEY k, VALUE v) {
        key = k;
        value = v;
        link = null;
    }

}
