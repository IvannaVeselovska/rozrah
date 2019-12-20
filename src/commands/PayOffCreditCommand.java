package commands;

import logging.MyLogger;
import menu.JavaMailUtil;
import user.Client;

import java.io.IOException;
import java.util.logging.Logger;

public class PayOffCreditCommand implements Command{
    private static final Logger log = Logger.getLogger(PayOffCreditCommand.class.getName());

    Client client;

    public PayOffCreditCommand(Client client) {
        this.client = client;
    }
    @Override
    public void execute() throws Exception {
        try {
            client.payOff();
        } catch (IOException e) {
            MyLogger.mySevereLogger(log);
            String msg ="Input error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }

    }
}
