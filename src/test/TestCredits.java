package test;

import credit.Credit;
import credit.Credits;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class TestCredits {

    @Test
    public void findBySum() {
        List<Credit> credit = new LinkedList<>();
        for(int i = 0;i<4; i++){
            credit.add(new Credit());
        }
        Credits  newcred = new Credits(credit);

        List<Credit> newlist = new LinkedList<>();
        int i = 0;
        while(i < 4) {
            if (20000 <= newcred.getCredits().get(i).getMaxSumOfCredit()) {
                newlist.add(newcred.getCredits().get(i++));
            } else i++;
        }
        Assert.assertEquals(newlist,newcred.findCreditsBySum(newcred,20000).getCredits());
    }

    @Test
    public void findByPercent() {
        List<Credit> credit = new LinkedList<>();
        for(int i = 0;i<4; i++){
            credit.add(new Credit());
        }
        Credits  newcred = new Credits(credit);

        List<Credit> newlist = new LinkedList<>();
        int i = 0;
        while(i < 4) {
            if ((20 + 1.0 >= newcred.getCredits().get(i).getPercent()) && (newcred.getCredits().get(i).getPercent() >= 20 - 1.0)) {
                newlist.add(newcred.getCredits().get(i++));
            } else i++;
        }
        Assert.assertEquals(newlist,newcred.findPer(newcred,20).getCredits());
    }

    @Test
    public void findCreditByBank() {
        List<Credit> credit = new LinkedList<>();
        for(int i = 0;i<4; i++){
            credit.add(new Credit());
        }
        Credits  newcred = new Credits(credit);

        List<Credit> newlist = new LinkedList<>();
        int i = 0;
        while(i < 4) {
            if ((newcred.getCredits().get(i).getBank().equals("bank"))) {
                newlist.add(newcred.getCredits().get(i++));
            } else i++;
        }
        Assert.assertEquals(newlist,newcred.findBank(newcred,"bank").getCredits());
    }


    @Test
    public void findByTerm() {
        List<Credit> credit = new LinkedList<>();
        for(int i = 0;i<4; i++){
            credit.add(new Credit());
        }
        Credits  newcred = new Credits(credit);

        List<Credit> newlist = new LinkedList<>();
        int i = 0;
        while(i < 4) {
            if (24 <= newcred.getCredits().get(i).getTermInMounths()) {
                newlist.add(newcred.getCredits().get(i++));
            } else i++;
        }
        Assert.assertEquals(newlist,newcred.findTerm(newcred,24).getCredits());
    }
}