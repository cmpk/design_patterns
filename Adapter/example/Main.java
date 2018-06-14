public class Main {
    public static void main(String[] args) {
        LoggerInterface logger = new Logger();
        logger.printInformation("tanaka", "This is information.");
        logger.printError("tanaka", "This is an error.");
    }
}