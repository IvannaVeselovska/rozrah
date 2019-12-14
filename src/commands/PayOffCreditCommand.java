package commands;

import menu.JavaMailUtil;
import myFormatter.MyFormatter;
import user.Client;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class PayOffCreditCommand implements Command{
    private static final Logger log = Logger.getLogger(PayOffCreditCommand.class.getName());

    Client client;

    public PayOffCreditCommand(Client client) {
        this.client = client;
    }
    @Override
    public void Execute() throws Exception {
        try {
            client.PayOff();
        } catch (IOException e) {
            Handler console = new ConsoleHandler();
            Handler file = new FileHandler();
            console.setFormatter(new MyFormatter());
            file.setFormatter(new MyFormatter());
            log.setUseParentHandlers(false);
            log.addHandler(console);
            log.addHandler(file);
            String msg ="Input error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }

    }
}
