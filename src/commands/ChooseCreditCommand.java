package commands;

import credit.Credits;
import logging.MyLogger;
import menu.JavaMailUtil;
import user.Client;

import java.io.IOException;
import java.util.logging.Logger;

public class ChooseCreditCommand implements Command{
    private static final Logger log = Logger.getLogger(ChooseCreditCommand.class.getName());
    Credits credit;
    Client client;
    public ChooseCreditCommand(Client c, Credits credits) {
        this.client = c;
        this.credit = credits;
    }
    @Override
    public void execute() throws Exception {
        try {
            client.setClientsCredit(credit);
        } catch (IOException e) {
            MyLogger.mySevereLogger(log);
            String msg ="Input error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }
}
