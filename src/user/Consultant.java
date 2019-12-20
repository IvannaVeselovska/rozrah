package user;

import commands.*;
import credit.Credit;

import java.util.logging.Logger;

public class Consultant {
    public static final Logger log = Logger.getLogger(Credit.class.getName());

    private Command command;


    public Consultant(Command command) {
        this.command = command;
    }

    public void execute() throws Exception {
        command.execute();
    }


}
