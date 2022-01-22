package at.aau.ue5.bsp5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.DoubleBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyMathTest {

    private MyMath myMath;
    private Double x;
    private Double y;
    private Fraction fraction;

    @BeforeEach
    public void setup(){
        myMath = new MyMath();
        x = 10d;
        y = 5d;
        fraction = new Fraction();
    }

    @Test
    public void shouldReturnFifteen_WhenAddingTenAndFive(){
        assertEquals(15,(double)myMath.add(x,y));
    }

    @Test
    public void shouldReturnFive_WhenTenMinusFive(){
        assertEquals(5,(double)myMath.sub(x,y));
    }

    @Test
    public void shouldReturnFifty_WhenMultiplyingTenAndFive(){
        assertEquals(50,(double)myMath.mul(x,y));
    }

    @Test
    public void shouldReturnTwo_WhenDividingTenByFive(){
        assertEquals(2,(double)myMath.div(x,y));
    }

    @Test
    public void shouldReturnOneAndOne_WhenInputIsOneAndOne(){
        setNumAndDenum(1,1);

        assertEquals(new Fraction(1,1), myMath.reduce(fraction));
    }

    @Test
    public void shouldReturnFiveAndThree_WhenInputIsTenAndSix(){
        setNumAndDenum(10,6);

        assertEquals(new Fraction(5,3),myMath.reduce(fraction));
    }

    @Test
    public void shouldReturn2And1_WhenInputIs10And5(){
        setNumAndDenum(10,5);

        assertEquals(new Fraction(2,1),myMath.reduce(fraction));
    }

    @Test
    public void shouldReturn2d_WhenInputIs10And5(){
        setNumAndDenum(10,5);

        assertEquals(2, (double)myMath.toDouble(fraction));
    }

    @Test
    public void shouldReturn2dot5_WhenInputIs10And4(){
        setNumAndDenum(10,4);

        assertEquals(2.5, (double)myMath.toDouble(fraction));
    }

    @Test
    public void shouldReturnDoubleNan_WhenDividedBy0(){
        setNumAndDenum(10,0);

        assertEquals(Double.NaN ,(double)myMath.div(10d,0d));
    }

    @Test
    public void x2() {
        Fraction f = new Fraction(1,1);
        MyMath mm = new MyMath();
        Fraction reduced = mm.reduce(f);
        assertEquals(new Integer(1),reduced.getNumerator());
        assertEquals(new Integer(1),reduced.getDenumerator());

        f = new Fraction(10,6);
        mm = new MyMath();
        reduced = mm.reduce(f);
        assertEquals(new Integer(5),reduced.getNumerator());
        assertEquals(new Integer(3),reduced.getDenumerator());

        f = new Fraction(10,5);
        mm = new MyMath();
        reduced = mm.reduce(f);
        assertEquals(new Integer(2),reduced.getNumerator());
        assertEquals(new Integer(1),reduced.getDenumerator());

        f = new Fraction(10,5);
        mm = new MyMath();
        Double aDouble = mm.toDouble(f);
        assertEquals(new Double(2),aDouble);

        f = new Fraction(10,4);
        mm = new MyMath();
        aDouble = mm.toDouble(f);
        assertEquals(new Double(2.5d),aDouble);
    }

    public void setNumAndDenum(int numerator, int denumerator){
        this.fraction.setNumerator(numerator);
        this.fraction.setDenumerator(denumerator);
    }
}
