import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder(1000);
        builder.append(df.format(new Date(record.getMillis())));
        builder.append(" ").append(record.getLevel());
        builder.append(" ").append(record.getSourceClassName()).append(".");
        builder.append(record.getSourceMethodName()).append(" ");
        builder.append(formatMessage(record));
        // Определение формата окончания строки в лог файле, чтобы удобно читать в linux и windows
        Properties p =  System.getProperties();
        String os = p.getProperty("os.name");
        if (os.equals("Linux")) {
            builder.append("\n");
        }
        else {
            builder.append("\r\n");
        }
        return builder.toString();
    }

    public String getHead(Handler h) {
        return super.getHead(h);
    }

    public String getTail(Handler h) {
        return super.getTail(h);
    }
}
