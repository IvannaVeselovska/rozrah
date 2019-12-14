package logging;

import menu.JavaMailUtil;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class MyLogger {
    public static void myLogger(Logger log) throws Exception {
        Handler console = new ConsoleHandler();
        Handler file = null;
        try {
            file = new FileHandler();
        } catch (Exception e) {
            String msg ="FileHandler error!";
            Logger.getLogger(MyLogger.class.getName()).severe(msg);
            JavaMailUtil.sendMail(msg);
        }
        console.setFormatter(new MyFormatter());
        file.setFormatter(new MyFormatter());
        log.setUseParentHandlers(false);
        log.addHandler(console);
        log.addHandler(file);
    }

}
