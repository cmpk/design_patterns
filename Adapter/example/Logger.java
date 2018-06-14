public class Logger extends MyAppLogger implements LoggerInterface {
    public void printError(String username, String msg) {
        error("user: " + username + ", message: " + msg);
    }

    public void printInformation(String username, String msg) {
        info("user: " + username + ", message: " + msg);
    }
}