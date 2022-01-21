package at.aau.ue5.bsp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CashMachineStateTest {

    CashMachine cashMachine = new CashMachine();

    @Test
    public void test1(){
        cashMachine.insertCard("1234");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_INSERTED);
        cashMachine.inputPIN("1234");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.PIN_OK);
        cashMachine.selectAmount(10);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.AMOUNT_VALID);
        cashMachine.takeCash();
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CASH_GIVEN);
        cashMachine.removeCard();
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_TAKEN);
    }

    @Test
    public void test2(){
        cashMachine.insertCard("1234");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_INSERTED);
        cashMachine.inputPIN("1234");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.PIN_OK);
        cashMachine.selectAmount(15);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.AMOUNT_NOT_VALID);
        assertThrows(IllegalStateException.class, ()-> cashMachine.takeCash());
    }

    @Test
    public void test3(){
        cashMachine.insertCard("1234");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_INSERTED);
        cashMachine.inputPIN("12345");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.PIN_NOT_OK);
        cashMachine.inputPIN("1234");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.PIN_OK);
        cashMachine.selectAmount(10);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.AMOUNT_VALID);
        cashMachine.takeCash();
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CASH_GIVEN);
        cashMachine.removeCard();
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_TAKEN);
    }

    @Test
    public void test4(){
        cashMachine.insertCard("1234");
        cashMachine.inputPIN("12345");
        cashMachine.inputPIN("12345");
        cashMachine.inputPIN("12345");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_RETAINED);
    }

    @Test
    public void test5(){
        cashMachine.insertCard("1234");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_INSERTED);
        cashMachine.inputPIN("12345");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.PIN_NOT_OK);
        cashMachine.inputPIN("1234");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.PIN_OK);
        cashMachine.selectAmount(9);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.AMOUNT_NOT_VALID);
        cashMachine.selectAmount(14);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.AMOUNT_NOT_VALID);
        cashMachine.selectAmount(10);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.AMOUNT_VALID);
        cashMachine.takeCash();
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CASH_GIVEN);
        cashMachine.removeCard();
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_TAKEN);
    }

    @Test
    public void test6(){
        cashMachine.insertCard("12342");
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_RETAINED);
    }

}
