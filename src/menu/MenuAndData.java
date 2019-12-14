package menu;

import commands.*;
import credit.Credit;
import credit.Credits;
import myFormatter.MyFormatter;
import user.Client;
import user.Consultant;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

public class MenuAndData {
    private static final Logger log = Logger.getLogger(MenuAndData.class.getName());
    public static void inputData() throws IOException {
        try {
            System.out.println("\tChoose data sourse for credits(1 - file; 2 - program)");
            Scanner sc = new Scanner(System.in);
            int choise = sc.nextInt();
            switch (choise) {
                case 1:
                    readFromFile();
                    break;
                case 2:
                    programData();
                    break;
                default:
                    log.warning("\tYour input is incorrect. Try again, please");
                    inputData();
                    break;
            }
        }catch (Exception o){
            Handler console = new ConsoleHandler();
            Handler file = new FileHandler();
            console.setFormatter(new MyFormatter());
            file.setFormatter(new MyFormatter());
            log.setUseParentHandlers(false);
            log.addHandler(console);
            log.addHandler(file);
            log.warning("Input from command error!");
        }

    }
    public static void readFromFile() throws Exception {
        List<Credit> credits = new LinkedList<>();
        try {
            Scanner sc;
            File f = new File("SOURSE.txt");

            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                // read from file
                String str = sc.nextLine();
                String[] arr_of_data = str.split(" ");

                //saving the data
                Credit c = new Credit(arr_of_data[0], arr_of_data[1], Double.parseDouble(arr_of_data[2]),
                        Integer.parseInt(arr_of_data[3]), Integer.parseInt(arr_of_data[4]));
                credits.add(c);
            }
            Handler console = new ConsoleHandler();
            console.setFormatter(new MyFormatter());
            log.setUseParentHandlers(false);
            log.addHandler(console);
            log.info("Data downloaded successfully");

        }catch (IOException o){
            Handler console = new ConsoleHandler();
            Handler file = new FileHandler();
            console.setFormatter(new MyFormatter());
            file.setFormatter(new MyFormatter());
            log.setUseParentHandlers(false);
            log.addHandler(console);
            log.addHandler(file);
            log.severe("Input from file error!");
        }

        Credits credits1 = new Credits(credits);
        customerServise(credits1);

    }
    public static void programData() throws Exception {
        List<Credit> credits = new LinkedList<>();
        credits.add(new Credit("PrivatBank", "HouseOnCredit", 17.9, 240, 2000000));
        credits.add(new Credit("PrivatBank", "Collateral", 22.9, 60, 1000000));
        credits.add(new Credit("PrivatBank", "Quick", 62.27, 24, 50000));
        credits.add(new Credit("PrivatBank", "AutoByInstallments", 0.5, 84, 2000000));
        credits.add(new Credit("PrivatBank", "Universal", 3.6, 84, 50000));
        credits.add(new Credit("MonoBank", "CreditLimit", 3.2, 12, 10000));
        credits.add(new Credit("OshchadBank", "ForElectricCars", 0.1, 84, 10000000));
        credits.add(new Credit("OshchadBank", "ForSecondHandCars", 19.99, 84, 1000000));

        Credits credits1 = new Credits(credits);
        customerServise(credits1);
    }
    public static void customerServise(Credits credits) throws Exception {
        Consultant consultant;
        Client client = new Client();
        consultant = new Consultant(new FindByMaxSummCommand(credits),new FindByPercentCommand(credits),
                new FindByTermCommand(credits),new FindCreditByBankCommand(credits),new PrintAllCommand(credits),
                new ChooseCreditCommand(client,credits),new PayOffCreditCommand(client));
        menu(consultant,client);

    }
    public static void menu(Consultant consultant, Client client) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int idOfCommand = -1;
            int k = 0;
            help();
            while (idOfCommand != 0) {
                System.out.print("\tEnter command(8 - help): ");
                idOfCommand = sc.nextInt();
                switch (idOfCommand) {
                    case (1):
                        consultant.findCreditByMaxSum();

                        break;
                    case (2):
                        consultant.findCreditByPercent();
                        break;
                    case (3):
                        consultant.findCreditByTerm();
                        break;
                    case (4):
                        consultant.findCreditByBank();
                        break;
                    case (5):
                        consultant.printAll();
                        break;
                    case (6):
                        consultant.chooseCredit();
                        k++;
                        break;
                    case (7):
                        if (k != 0)
                            consultant.payOffCredit();
                        else System.out.println("\tChoose a credit first");
                        break;
                    case (8):
                        help();
                        break;
                    default:
                        System.out.println("\tAre you sure you want to exit? ( 0 - yes, -1 - continue )");
                        idOfCommand = sc.nextInt();
                        break;
                }
            }
        }catch (Exception o){
            Handler console = new ConsoleHandler();
            Handler file = new FileHandler();
            console.setFormatter(new MyFormatter());
            file.setFormatter(new MyFormatter());
            log.setUseParentHandlers(false);
            log.addHandler(console);
            log.addHandler(file);
            String msg ="Input command error";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
        }
    }
    public static void help(){
        System.out.println("\t\t---HELP---\n1 - Find credit by max sum\n2 - Find credit by percent\n3 - Find credit by term\n4 - Find credit by bank\n" +
                "5 - Print all available credits\n6 - Choose your credit(inpur number of credit)\n7 - Pay off your credit");
    }

}
