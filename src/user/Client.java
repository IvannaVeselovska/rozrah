package user;

import credit.Credit;
import credit.Credits;
import logging.MyLogger;
import menu.JavaMailUtil;

import java.util.Scanner;
import java.util.logging.Logger;

public class Client {

    public static final Logger log = Logger.getLogger(Client.class.getName());

    Credit clientsCredit;

    public Client(Credit clientsCredit) {
        setClientsCredit(clientsCredit);
    }

    public Client() {
    }

    public Credit getClientsCredit() {
        return clientsCredit;
    }

    public void setClientsCredit(Credit clientsCredit) {
        this.clientsCredit = clientsCredit;
    }

    public int getCurrentBalance(){
        return (int)(clientsCredit.getCurrentSum()+clientsCredit.getCurrentSum()*clientsCredit.getPercent()/100);
    }

    public void payOff() throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input the sum of refund(balance = " +
                     getCurrentBalance() + " ): ");
            int pay_sum = sc.nextInt();
            clientsCredit.payOff(pay_sum);
            MyLogger.myInfoLogger(log);
            log.info(": Payed off successfully");
        }
        catch (Exception O){
            MyLogger.mySevereLogger(log);
            String msg ="In :" + log.getName() + " method: payOff \n" +"Input pay sum error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }

    }

    public void setClientsCredit(Credits credits) throws Exception {
        try{
            Scanner s = new Scanner(System.in);
            System.out.println("Input the number of credit: ");
            int i = s.nextInt();
            if (i > credits.getCredits().size()|| i <= 0) throw  new Exception();
            this.clientsCredit = credits.getCredits().get(i-1);
            System.out.println("Input the sum of the loan: ");
            int sum = s.nextInt();
            this.clientsCredit.setCurrentSum(sum);
            MyLogger.myInfoLogger(log);
            log.info(": Credit added successfully");
        }
        catch (Exception O){
            MyLogger.mySevereLogger(log);
            String msg ="In :" + log.getName() + " method: setClientsCredit \n" +"Input credit number error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
            System.out.println("Try again!");
            setClientsCredit(credits);
        }
    }
}
