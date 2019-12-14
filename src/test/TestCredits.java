package test;

import credit.Credit;
import credit.Credits;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TestCredits {

    @Test
    public void findBySum() throws IOException {
        List<Credit> credit = new LinkedList<>();
        for(int i = 0;i<4; i++){
            credit.add(new Credit());
        }
        Credits  newcred = new Credits(credit);
        Credits retur = newcred.findCreditsBySum(newcred, 20000);
        List<Credit> newlist = new LinkedList<>();
        int i = 0;
        while(i < 4) {
            if (20000 <= newcred.getCredits().get(i).getMaxSumOfCredit()) {
                newlist.add(newcred.getCredits().get(i++));
            } else i++;
        }
        Assert.assertEquals(new Credits(newlist),retur);
    }

    @Test
    public void findByPercent() {
    }

    @Test
    public void findCreditByBank() {
    }

    @Test
    public void findByTerm() {
    }
}