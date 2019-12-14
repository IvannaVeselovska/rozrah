package commands;

import credit.Credits;
import logging.MyLogger;
import menu.JavaMailUtil;
import myFormatter.MyFormatter;

import java.io.IOException;
import java.util.logging.Logger;

public class FindByPercentCommand implements Command {
    private static final Logger log = Logger.getLogger(FindByPercentCommand.class.getName());
    Credits credits;
    public FindByPercentCommand(Credits credits) {
        this.credits = credits;
    }
    @Override
    public void Execute() throws Exception {
        try {
            credits.findByPercent();
        } catch (IOException e) {
            MyLogger.myLogger(log);
            String msg ="Input error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }
}

