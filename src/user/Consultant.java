package user;

import commands.*;
import credit.Credit;
import myFormatter.MyFormatter;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Consultant {
    public static final Logger log = Logger.getLogger(Credit.class.getName());

    Command maxSum;
    Command percent;
    Command term;
    Command bank;
    Command printAl;
    Command payOff;
    Command chooseCredit;
    


    public Consultant(Command maxSum, Command percent, Command term, Command bank, Command printAl, Command choose, Command payOff) {
        this.maxSum = maxSum;
        this.percent = percent;
        this.term = term;
        this.bank = bank;
        this.printAl = printAl;
        this.chooseCredit = choose;
        this.payOff = payOff;
    }
    public Consultant(Command maxSum, Command percent, Command term, Command bank, Command printAl) {
        this.maxSum = maxSum;
        this.percent = percent;
        this.term = term;
        this.bank = bank;
        this.printAl = printAl;
    }
    

    public void findCreditByMaxSum() throws IOException {

        try {
            maxSum.Execute();
        } catch (Exception e) {
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

    public void findCreditByPercent() {
        try {
            percent.Execute();
        } catch (Exception e) {
            Handler console = new ConsoleHandler();
            Handler file = null;
            try {
                file = new FileHandler();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            console.setFormatter(new MyFormatter());
            file.setFormatter(new MyFormatter());
            log.setUseParentHandlers(false);
            log.addHandler(console);
            log.addHandler(file);
            log.info("Input error!");
        }
    }

    public void findCreditByTerm() {
        try {
            term.Execute();
        } catch (Exception e) {
            Handler console = new ConsoleHandler();
            Handler file = null;
            try {
                file = new FileHandler();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            console.setFormatter(new MyFormatter());
            file.setFormatter(new MyFormatter());
            log.setUseParentHandlers(false);
            log.addHandler(console);
            log.addHandler(file);
            log.info("Input error!");
        }
    }

    public void findCreditByBank() throws IOException {
        try {
            bank.Execute();
        } catch (Exception e) {
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

    public void printAll() throws IOException {
        try {
            printAl.Execute();
        } catch (Exception e) {
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

    public void chooseCredit() throws IOException {
        try {
            chooseCredit.Execute();
        } catch (Exception e) {
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

    public void payOffCredit() throws IOException {
        try {
            payOff.Execute();
        } catch (Exception e) {
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


