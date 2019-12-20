package commands;

import credit.Credits;
public class PrintAllCommand implements Command {
    Credits credits;
    public PrintAllCommand(Credits credits) {
        this.credits = credits;
    }
    @Override
    public void execute(){
        credits.printAll();
    }
}