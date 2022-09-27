package twelfth;

public class DictionaryLinkedList<KEY, VALUE> {

    private DictionaryNode<KEY, VALUE> headOfList;

    public DictionaryLinkedList() {
        headOfList = new DictionaryNode<>();
    }

    public DictionaryLinkedList(KEY key, VALUE value) {
        headOfList = new DictionaryNode<>(key, value);
    }


    public void add(KEY key, VALUE value) {
        if (headOfList.key == null) {
            headOfList.key = key;
            headOfList.value = value;
        } else {
            DictionaryNode<KEY, VALUE> temp = new DictionaryNode<>(key, value);
            temp.link = headOfList;
            headOfList = temp;
        }
    }

    public DictionaryNode<KEY, VALUE> get(KEY key) {
        DictionaryNode<KEY, VALUE> temp = headOfList;
        do {
            if (temp.key == key) {
                return temp;
            }
            temp = temp.link;
        } while (temp.link != null);
        return null;
    }

}
