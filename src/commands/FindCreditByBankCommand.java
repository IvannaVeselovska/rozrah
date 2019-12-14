package commands;

import credit.Credits;
import menu.JavaMailUtil;
import myFormatter.MyFormatter;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
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