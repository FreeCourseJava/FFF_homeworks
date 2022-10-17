package fourteenth;

import java.util.List;

public interface Filterable<VALUE> {

    List<VALUE> filter(ValueFilter<VALUE> valueValueFilter);

}
