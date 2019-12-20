package menu;

import commands.*;
import credit.Credit;
import credit.Credits;
import logging.MyLogger;
import logging.MyFormatter;
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
    public static void inputData() throws Exception {
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
            MyLogger.mySevereLogger(log);
            String msg ="In :" + log.getName() + " method: inputData \n" +"Input command error!";
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
            inputData();
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
            MyLogger.myInfoLogger(log);
            log.info(": Data downloaded successfully");

        }catch (IOException o){
            MyLogger.mySevereLogger(log);
            String msg ="In :" + log.getName() + " method: readFromFile \n" +"Read file error!";
            log.severe(msg);
           JavaMailUtil.sendMail(msg);
        }

        Credits credits1 = new Credits(credits);
        menu(credits1);

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

        MyLogger.myInfoLogger(log);
        log.info(": Data added successfully");

        Credits credits1 = new Credits(credits);
        menu(credits1);
    }

    public static void menu(Credits credits) throws Exception {
        Consultant consultant;
        Client client = new Client();
        try {
            Scanner sc = new Scanner(System.in);
            int idOfCommand = -1;
            int k = 0;
            help();
            while (idOfCommand != 0) {
                System.out.print("\tEnter command(8 - help, other - exit): ");
                idOfCommand = sc.nextInt();
                switch (idOfCommand) {
                    case (1):
                        consultant = new Consultant(new FindByMaxSummCommand(credits));
                        consultant.execute();
                        break;
                    case (2):
                        consultant = new Consultant(new FindByPercentCommand(credits));
                        consultant.execute();
                        break;
                    case (3):
                        consultant = new Consultant(new FindByTermCommand(credits));
                        consultant.execute();
                        break;
                    case (4):
                        consultant = new Consultant(new FindCreditByBankCommand(credits));
                        consultant.execute();
                        break;
                    case (5):
                        consultant = new Consultant(new PrintAllCommand(credits));
                        consultant.execute();
                        break;
                    case (6):
                        consultant = new Consultant(new ChooseCreditCommand(client,credits));
                        consultant.execute();
                        k++;
                        break;
                    case (7):
                        if (k != 0) {
                            consultant = new Consultant(new PayOffCreditCommand(client));
                            consultant.execute();
                        }
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
            System.out.println("Goodbye!");
        }catch (Exception o){
            MyLogger.mySevereLogger(log);
            String msg ="In :" + log.getName() + " method: menu \n" +"Input command error" ;
            log.severe(msg);
            JavaMailUtil.sendMail(msg);
            menu(credits);
        }
    }
    public static void help(){
        System.out.println("\t\t---HELP---\n1 - Find credit by max sum\n2 - Find credit by percent\n3 - Find credit by term\n4 - Find credit by bank\n" +
                "5 - Print all available credits\n6 - Choose your credit(inpur number of credit)\n7 - Pay off your credit");
    }
}
