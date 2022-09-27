package twelfth;

public interface Dictionary<KEY, VALUE> {
    void put(KEY key, VALUE value);
    VALUE get(KEY key);
}
