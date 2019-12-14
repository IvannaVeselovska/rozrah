package user;

import credit.Credit;
import credit.Credits;
import myFormatter.MyFormatter;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Client {

    public static final Logger log = Logger.getLogger(Client.class.getName());

    Credit clientsCredit;

    public Client(Credit clientsCredit) {
        this.clientsCredit = clientsCredit;
    }

    public Client() {
    }

    public void PayOff() throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input the sum of refund(balance = " +
                    (int)(clientsCredit.getCurrentSum()+clientsCredit.getCurrentSum()*clientsCredit.getPercent()/100) + " ): ");
            int pay_sum = sc.nextInt();
            clientsCredit.PayOff(pay_sum);
        }
        catch (Exception O){
            Handler console = new ConsoleHandler();
            Handler file = new FileHandler();
            console.setFormatter(new MyFormatter());
            file.setFormatter(new MyFormatter());
            log.setUseParentHandlers(false);
            log.addHandler(console);
            log.addHandler(file);
            log.info("Input error!");
        }

    }

    public void setClientsCredit(Credits credits) throws IOException {
        try{
            Scanner s = new Scanner(System.in);
            System.out.println("Input the number of credit: ");
            int i = s.nextInt();
            if (i >= credits.getCredits().size()|| i < 0) return;
            this.clientsCredit = credits.getCredits().get(i);
            System.out.println("Input the sum of the loan: ");
            int sum = s.nextInt();
            this.clientsCredit.setCurrentSum(sum);
        }
        catch (Exception O){
            Handler console = new ConsoleHandler();
            Handler file = new FileHandler();
            console.setFormatter(new MyFormatter());
            file.setFormatter(new MyFormatter());
            log.setUseParentHandlers(false);
            log.addHandler(console);
            log.addHandler(file);
            log.info("Input error!");
        }
    }
}
