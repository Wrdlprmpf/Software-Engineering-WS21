package at.aau.ue4.bsp3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class McCabeTest {
    @Test
    public void basistest1() {
        assertEquals(1, McCabe.ggt(1,0));
    }

    @Test
    public void basistest2(){
        assertEquals(3, McCabe.ggt(9,3));
    }

    @Test
    public void basistest3(){
        assertEquals(1, McCabe.ggt(5,32));
    }

}
