package at.aau.ue5.bsp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CashMachineRandomTest {

    /** Zufällige Aufrufsequenz der Methoden zum testen
     * CashMachine Klasse mit folgenden Methoden:
     *
     * insertCard, inputPin, selectAmount, takeCash, removeCard
     *
     *
     *
     */

    CashMachine cashMachine = new CashMachine();

    @Test
    public void testSequenz1(){
        //insertCard, takeCash, selectAmount, inputPin, removeCard

        cashMachine.insertCard("1234");
        assertThrows(Exception.class, ()->cashMachine.takeCash());
        assertThrows(Exception.class, ()->cashMachine.selectAmount(100));
        cashMachine.inputPIN("1234");
        assertThrows(Exception.class, ()->cashMachine.removeCard());
    }

    @Test
    public void testSequenz2(){
        //insertCard, inputPin, takeCash, selectAmount, removeCard

        cashMachine.insertCard("1234");
        cashMachine.inputPIN("1234");
        assertThrows(Exception.class, ()->cashMachine.takeCash());
        cashMachine.selectAmount(150);
        assertThrows(Exception.class, ()->cashMachine.removeCard());
    }

    @Test
    public void testSequenz3(){
        //insertCard, selectAmount, takeCash, inputPin, removeCard

        cashMachine.insertCard("002242");
        assertThrows(Exception.class, ()->cashMachine.selectAmount(24));
        assertThrows(Exception.class, ()->cashMachine.takeCash());
        assertThrows(Exception.class, ()->cashMachine.inputPIN("0011"));
        assertThrows(Exception.class, ()->cashMachine.removeCard());
    }
}
