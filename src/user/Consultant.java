package user;

import commands.*;
import credit.Credit;
import logging.MyLogger;
import menu.JavaMailUtil;
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

    

    public void findCreditByMaxSum() throws Exception {

        try {
            maxSum.Execute();
        } catch (Exception e) {
            MyLogger.myLogger(log);
            String msg ="Input sum error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }

    }

    public void findCreditByPercent() throws Exception {
        try {
            percent.Execute();
        } catch (Exception e) {
            MyLogger.myLogger(log);
            String msg ="Input credit error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }

    public void findCreditByTerm() throws Exception {
        try {
            term.Execute();
        } catch (Exception e) {
            MyLogger.myLogger(log);
            String msg = "Input term error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }

    public void findCreditByBank() throws Exception {
        try {
            bank.Execute();
        } catch (Exception e) {
            MyLogger.myLogger(log);
            String msg ="Input bank error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }

    public void printAll() throws Exception {
        try {
            printAl.Execute();
        } catch (Exception e) {
            MyLogger.myLogger(log);
            String msg ="Input error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }

    public void chooseCredit() throws Exception {
        try {
            chooseCredit.Execute();
        } catch (Exception e) {
            MyLogger.myLogger(log);
            String msg ="Input credit number error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }

    public void payOffCredit() throws Exception {
        try {
            payOff.Execute();
        } catch (Exception e) {
            MyLogger.myLogger(log);
            String msg ="Input pay sum error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }
}


