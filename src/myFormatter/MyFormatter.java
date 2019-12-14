package myFormatter;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return record.getLevel() + ": In :" + record.getLoggerName() + " method: " + record.getSourceMethodName() + " \n" + record.getMessage() + "\n";
    }
}
