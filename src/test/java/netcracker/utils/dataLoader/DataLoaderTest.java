package netcracker.utils.dataLoader;

import com.netcracker.utils.dataLoader.DataLoader;
import com.netcracker.utils.reflection.InjectionException;
import com.netcracker.utils.reflection.Injector;
import org.junit.jupiter.api.Test;


import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class DataLoaderTest {

    @Test
    void readAll() throws InjectionException {
        try {
            Injector i = new Injector();
            DataLoader kbk = new DataLoader();
            Arrays.asList(kbk.readAll(new FileReader("csvnetcracker.csv")));
        } catch (InjectionException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}