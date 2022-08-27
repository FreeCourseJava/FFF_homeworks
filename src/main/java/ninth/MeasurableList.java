package ninth;

import fifth.Measureable;

public interface MeasurableList {

    Measureable get( int index);

    boolean exists(Measureable measureable);

    void remove(Measureable measureable);

    void remove(int index);

    void add(Measureable measureable);

    int length();

}
