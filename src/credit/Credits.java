package credit;

import myFormatter.MyFormatter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Credits {

    public static final Logger log = Logger.getLogger(Credit.class.getName());

    private List<Credit> credits;

    public Credits(List<Credit> credits) {
        this.credits = credits;
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

    public Credits  findCreditsBySum(Credits cre, int sum)
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

    public void FindBySum() throws IOException {
        try{
             Scanner sc = new Scanner(System.in);
             System.out.println("Input the sum you are looking for: ");
             int sum = sc.nextInt();
            System.out.println(findCreditsBySum(this,sum));
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
    public void FindByPercent() throws IOException{
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Input the percent you are looking for: ");
            double percent = sc.nextDouble();
            System.out.println(findPer(this,percent));

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
    public void PrintAll(){
        System.out.println(this);
    }
    public Credits findBank(Credits cre,String bank){
        List<Credit> newlist = new LinkedList<>();
        int i = 0;
        while(i < cre.getCredits().size()){
            if((bank.equals(cre.getCredits().get(i).getBank()))) {
                newlist.add(cre.getCredits().get(i++));
            }
            else i++;
        }
        return new Credits(newlist);
    }
    public void FindCreditByBank() throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input the bank you are looking for: ");
            String bank = sc.nextLine();
            System.out.println(findBank(this,bank));
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
    public Credits findTerm(Credits cre,int term){
        List<Credit> newlist = new LinkedList<>();
        int i = 0;
        while(i < cre.getCredits().size()){
            if(term <= cre.getCredits().get(i).getTermInMounths()) {
                newlist.add(cre.getCredits().get(i++));
            }
            else i++;
        }
        return new Credits(newlist);
    }
    public void FindByTerm() throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input the term you are looking for: ");
            int term = sc.nextInt();
            System.out.println(findTerm(this,term));
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

