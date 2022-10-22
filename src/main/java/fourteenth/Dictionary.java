package fourteenth;

public interface Dictionary<KEY, VALUE> {

    VALUE get(KEY key);

    void put(KEY key, VALUE value);

}
