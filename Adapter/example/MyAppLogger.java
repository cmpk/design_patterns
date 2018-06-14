import java.util.Calendar;
import java.text.SimpleDateFormat;

public class MyAppLogger {
    public static final String TIME_FORMAT = "yyyy/MM/dd hh:mm:ss";
    private SimpleDateFormat sdf = null;

    public MyAppLogger() {
        sdf = new SimpleDateFormat(TIME_FORMAT);
    }
    
    public void info(String msg) {
        System.out.println(getTime() + " INF " + msg);
    }
    
    public void error(String msg) {
        System.out.println(getTime() + " ERR " + msg);
    }

    private String getTime() {
        Calendar c = Calendar.getInstance();
        return sdf.format(c.getTime());
    }
}