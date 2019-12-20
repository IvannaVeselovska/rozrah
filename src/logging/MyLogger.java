package logging;

import menu.JavaMailUtil;
import java.util.logging.*;

public class MyLogger {
    public static void mySevereLogger(Logger log) throws Exception {
        LogManager.getLogManager().readConfiguration();
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

    public static void myInfoLogger(Logger log){
        Handler console = new ConsoleHandler();
        console.setFormatter(new MyFormatter());
        log.setUseParentHandlers(false);
        log.addHandler(console);
    }
}
