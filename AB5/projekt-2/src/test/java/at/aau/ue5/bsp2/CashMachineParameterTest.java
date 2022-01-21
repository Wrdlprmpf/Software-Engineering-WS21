package at.aau.ue5.bsp2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CashMachineParameterTest {

    private CashMachine cashMachine = new CashMachine();

    @ParameterizedTest
    @ValueSource(strings = {"3141","1001","10","99102","9891","999331"})
    public void shouldReturnTrue_WhenCodeEndsNotWith42(String number){
        cashMachine.insertCard(number);
        assertTrue(cashMachine.getCurrentState()==CashMachineState.CARD_INSERTED);
    }

    @ParameterizedTest
    @ValueSource(strings = {"42","0199242","12342","42424242","000042","100000000042"})
    public void shouldReturnTrue_WhenCodeEndsWith42(String number){
        cashMachine.insertCard(number);
        assertTrue(cashMachine.getCurrentState()==CashMachineState.CARD_RETAINED);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234"})
    public void shouldReturnTrue_WhenCorrectCodeIsGiven(String pin){
        insertValidCard();
        cashMachine.inputPIN(pin);
        assertTrue(cashMachine.getCurrentState()==CashMachineState.PIN_OK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12443","01992","024240"})
    public void shouldReturnTrue_WhenWrongCodeIsGiven(String pin){
        insertValidCard();
        cashMachine.inputPIN(pin);
        assertTrue(cashMachine.getCurrentState()==CashMachineState.PIN_NOT_OK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12443","01992","024240"})
    public void shouldReturnTrue_WhenWrongCodeIsEntered(String pin){
        insertValidCard();
        cashMachine.inputPIN(pin);
        cashMachine.inputPIN(pin);
        cashMachine.inputPIN(pin);
        assertTrue(cashMachine.getCurrentState()==CashMachineState.CARD_RETAINED);
    }

    @ParameterizedTest
    @ValueSource(ints = {100,1000,40,50,10,240})
    public void shouldReturnTrue_WhenCorrectAmountIsEntered(int amount){
        insertValidCard();
        inputValidPin();
        cashMachine.selectAmount(amount);
        assertTrue(cashMachine.getCurrentState()==CashMachineState.AMOUNT_VALID);
    }

    @ParameterizedTest
    @ValueSource(ints = {11,1,25,36,101,157,1555,99})
    public void shouldReturnTrue_WhenWrongAmountIsEntered(int amount){
        insertValidCard();
        inputValidPin();
        cashMachine.selectAmount(amount);
        assertTrue(cashMachine.getCurrentState()==CashMachineState.AMOUNT_NOT_VALID);
    }

    private void insertValidCard(){
        cashMachine.insertCard("12345");
    }

    private void inputValidPin(){
        cashMachine.inputPIN("1234");
    }

    private void inputValidAmount(){
        cashMachine.selectAmount(10);
    }

    private void tookCash(){
        cashMachine.takeCash();
    }
}
