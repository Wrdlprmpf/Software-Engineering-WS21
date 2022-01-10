package at.aau.ue3.bsp2;

import org.junit.Assert;
import org.junit.Test;

public class RelationCheckerTest {
    //TODO fill tests

    @Test
    public void ifXandYIsZero_ThenReturnZero(){
        Assert.assertEquals(0, RelationChecker.checkRelation(0,0));


    }
}
