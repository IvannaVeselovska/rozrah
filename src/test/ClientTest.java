package test;

import credit.Credit;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import user.Client;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void getCurrentBalance() {
        Client client = new Client(new Credit());
        int rezult = client.getClientsCredit().getCurrentSum();
        int expected = (int)(client.getClientsCredit().getCurrentSum() +
                client.getClientsCredit().getCurrentSum()*client.getClientsCredit().getPercent()/100);

        Assert.assertEquals(expected,rezult);
    }
}