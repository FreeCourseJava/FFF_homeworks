package twelfth;

public class DictionaryHashTable<KEY, VALUE> implements Dictionary<KEY, VALUE> {
    private DictionaryLinkedList<KEY, VALUE>[] dictionary = new DictionaryLinkedList[32];

    @Override
    public void put(KEY key, VALUE value) {
        int index = getIndex(key);
        if (dictionary[index] == null) {
            dictionary[index] = new DictionaryLinkedList<>(key, value);
        } else {
            dictionary[index].add(key, value);
        }
    }

    @Override
    public VALUE get(KEY key) {
        int index = getIndex(key);
        if (dictionary[index] == null) {
            return null;
        }
        return dictionary[index].get(key).value;
    }

    private int getIndex(KEY key) {
        int hash = key.hashCode();
        return (dictionary.length - 1) & hash;
    }

}



