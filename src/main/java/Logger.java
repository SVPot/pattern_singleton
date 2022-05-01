import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    protected Date date = new Date();

    protected int num = 1;

    public void log(String msg) {
        System.out.println("[" + dateFormat.format(date) + " " + num++ + "] " + msg);
    }

    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

}