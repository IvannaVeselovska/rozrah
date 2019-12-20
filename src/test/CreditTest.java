package test;

import credit.Credit;
import org.junit.Assert;
import org.junit.Test;

public class CreditTest {
    @Test
    public void percentRise() {
        Credit credit = new Credit();
        credit.percentRise();
        double rezult = credit.getPercent();
        Credit credit1 = new Credit();
        credit1.setPercent(credit1.getPercent() + credit1.getPercent()*0.1);

        Assert.assertEquals(credit1.getPercent(),rezult,0.0001);
    }

    @Test
    public void changeCurrentSum() throws Exception {
        Credit credit = new Credit();
        credit.setCurrentSum(1000);
        int rezult = credit.changeCurrentSum(1000);
        credit.setCurrentSum(1000);
        int expected = (int)(credit.getCurrentSum()+(int)credit.getCurrentSum()*credit.getPercent()/100 - 1000);
        Assert.assertEquals(expected,rezult);
    }

}
