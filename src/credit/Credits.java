package credit;

import logging.MyLogger;
import menu.JavaMailUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class  Credits {

    private static final Logger log = Logger.getLogger(Credits.class.getName());

    private List<Credit> credits;

    public Credits(List<Credit> credits) {
        setCredits(credits);
    }

    public List<Credit> getCredits() {
        return credits;
    }


    public Credits() {
    }

    @Override
    public String toString() {
        String rezult = "Credits{\n";
        int i = 0; ;
        while(i < credits.size()) rezult += credits.get(i++).toString() + '\n';

        return rezult + '}';
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public Credits findSum(Credits cre, int sum)
    {
        List<Credit> newlist = new LinkedList<>();
        int i = 0;
        while(i < cre.getCredits().size()) {
            if (sum <= cre.getCredits().get(i).getMaxSumOfCredit()) {
                newlist.add(cre.getCredits().get(i++));
            } else i++;
        }
            return new Credits(newlist);
    }

    public void findBySum() throws Exception {
        try{
            MyLogger.myLogger(log);

             Scanner sc = new Scanner(System.in);
             System.out.println("Input the sum you are looking for: ");
             int sum = sc.nextInt();
            System.out.println(findSum(this,sum));
        }
        catch (Exception O){
            MyLogger.myLogger(log);
            String msg ="In :" + log.getName() + " method: findBySum \n" +"Input sum error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }
    public Credits findPer(Credits cre,double percent){
        List<Credit> newlist = new LinkedList<>();
        int i = 0;
        while(i < cre.getCredits().size()){
            if((percent + 1.0 >= cre.getCredits().get(i).getPercent()) && (cre.getCredits().get(i).getPercent() >= percent - 1.0)) {
                newlist.add(cre.getCredits().get(i++));
            }
            else i++;
        }
        return new Credits(newlist);
    }
    public void findByPercent() throws Exception {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Input the percent you are looking for: ");
            double percent = sc.nextDouble();
            System.out.println(findPer(this,percent));

        }
        catch (Exception O){
            MyLogger.myLogger(log);
            String msg ="In :" + log.getName() + " method: findByPercent \n" +"Input percent error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }
    public void printAll(){
        System.out.println(this);
    }

    public Credits findBank(Credits cre,String bank){
        List<Credit> newList = new LinkedList<>();
        int i = 0;
        while(i < cre.getCredits().size()){
            if((bank.equals(cre.getCredits().get(i).getBank()))) {
                newList.add(cre.getCredits().get(i++));
            }
            else i++;
        }
        return new Credits(newList);
    }
    public void findCreditByBank() throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input the bank you are looking for: ");
            String bank = sc.nextLine();
            System.out.println(findBank(this,bank));
        }
        catch (Exception O){
            MyLogger.myLogger(log);
            String msg ="In :" + log.getName() + " method: findByBank \n" +"Input bank error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }

    public Credits findTerm(Credits cre,int term){
        List<Credit> newList = new LinkedList<>();
        int i = 0;
        while(i < cre.getCredits().size()){
            if(term <= cre.getCredits().get(i).getTermInMounths()) {
                newList.add(cre.getCredits().get(i++));
            }
            else i++;
        }
        return new Credits(newList);
    }
    public void findByTerm() throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input the term you are looking for: ");
            int term = sc.nextInt();
            System.out.println(findTerm(this,term));
        }
        catch (Exception O){
            MyLogger.myLogger(log);
            String msg ="In :" + log.getName() + " method: findByTerm \n" +"Input term error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }
}

