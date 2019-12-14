package commands;

import credit.Credits;
import logging.MyLogger;
import menu.JavaMailUtil;

import java.io.IOException;
import java.util.logging.Logger;

public class FindCreditByBankCommand implements Command {
    private static final Logger log = Logger.getLogger(FindCreditByBankCommand.class.getName());
    Credits credits;
    public FindCreditByBankCommand(Credits credits) {
        this.credits = credits;
    }
    @Override
    public void Execute() throws Exception {
        try {
            credits.findCreditByBank();
        } catch (IOException e) {
            MyLogger.myLogger(log);
            String msg ="Input error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }
}