package test;

import credit.Credit;
import org.junit.Assert;
import org.junit.Test;

public class TestCredit {
    @Test
    public void PayOff() {
        Credit c1 = new Credit();
        c1.PayOff(100);
        Credit c = new Credit();
        c.setCurrentSum(c.getCurrentSum() + (int)(c.getCurrentSum() * c.getPercent()/ 100) - 100);
        Assert.assertEquals(c.getCurrentSum(),c1.getCurrentSum());
    }

}
