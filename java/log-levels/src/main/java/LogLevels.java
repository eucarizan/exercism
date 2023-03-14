import static java.lang.String.format;

public class LogLevels {
    
    public static String message(String logLine) {
        // throw new UnsupportedOperationException("Please implement the (static) LogLine.message() method");
        return logLine.split(":")[1].trim();
    }

    public static String logLevel(String logLine) {
        // throw new UnsupportedOperationException("Please implement the (static) LogLine.logLevel() method");
        // String line = logLine.split(":")[0].toLowerCase();
        // return line.substring(1, line.length()-1);
        return logLine.split("]: ")[0].substring(1).toLowerCase();
    }

    public static String reformat(String logLine) {
        // throw new UnsupportedOperationException("Please implement the (static) LogLine.reformat() method");
        // String[] line = logLine.split(":");
        // return line[1].trim() + " (" + line[0].toLowerCase().substring(1, line[0].length()-1) + ")";
        return format("%s (%s)", message(logLine), logLevel(logLine));
    }
}
