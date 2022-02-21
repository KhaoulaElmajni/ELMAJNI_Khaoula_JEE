package metier;

import org.junit.Assert;
import org.junit.Test;

public class CalculTest {
    private Calcul calcul;
    @Test
    public void testSomme(){
        calcul = new Calcul();
        double a=5 , b =9,expected=14;
        double rs = calcul.somme(a,b);

        Assert.assertTrue(rs==expected);
    }
}
