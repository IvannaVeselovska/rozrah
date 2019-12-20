package commands;

import credit.Credits;
import logging.MyLogger;
import menu.JavaMailUtil;

import java.io.IOException;
import java.util.logging.Logger;

public class FindByMaxSummCommand implements Command {
    private static final Logger log = Logger.getLogger(FindByMaxSummCommand.class.getName());
    Credits credits;
    public FindByMaxSummCommand(Credits credits) {
        this.credits = credits;
    }
    @Override
    public void execute() throws Exception {
        try {
            credits.findBySum();
        } catch (IOException e) {
            MyLogger.mySevereLogger(log);
            String msg ="Input error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }
}

