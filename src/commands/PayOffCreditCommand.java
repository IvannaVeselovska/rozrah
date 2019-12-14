package commands;

import myFormatter.MyFormatter;
import user.Client;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class PayOffCreditCommand implements Command{
    public static final Logger log = Logger.getLogger(PayOffCreditCommand.class.getName());

    Client client;

    public PayOffCreditCommand(Client client) {
        this.client = client;
    }
    @Override
    public void Execute() throws IOException {
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
            log.info("Input error!");
        }

    }
}
