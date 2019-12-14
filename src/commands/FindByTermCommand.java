package commands;

import credit.Credit;
import credit.Credits;
import myFormatter.MyFormatter;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;


public class FindByTermCommand implements Command {

    public static final Logger log = Logger.getLogger(FindByTermCommand.class.getName());

    Credits credits;
    public FindByTermCommand(Credits credits) {
        this.credits = credits;
    }
    @Override
    public void Execute() throws IOException {
        try {
            credits.FindByTerm();
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
