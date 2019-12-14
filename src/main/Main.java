package main;

import menu.JavaMailUtil;
import menu.MenuAndData;

import java.io.IOException;

/**
 * @author Ivanna Veselovska
 */

public class Main {
    public static void main(String[] args) throws IOException, Exception {
            JavaMailUtil.sendMail("HALOO");
             MenuAndData.inputData();
    }
}

