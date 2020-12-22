package netcracker.utils.reflection;

import com.netcracker.utils.sort.Sorter;
import org.junit.jupiter.api.Test;

class InjectorTest {

    @Test
    void inject(Sorter sorter) {
        inject(sorter);
    }
}