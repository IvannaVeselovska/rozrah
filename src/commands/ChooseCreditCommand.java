package commands;

import credit.Credits;
import myFormatter.MyFormatter;
import user.Client;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class ChooseCreditCommand implements Command{
    public static final Logger log = Logger.getLogger(ChooseCreditCommand.class.getName());
    Credits credit;
    Client client;
    public ChooseCreditCommand(Client c, Credits credits) {
        this.client = c;
        this.credit = credits;
    }
    @Override
    public void Execute() throws IOException {
        try {
            client.setClientsCredit(credit);
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
