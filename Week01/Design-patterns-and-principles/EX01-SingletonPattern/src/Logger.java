/**
 * Logger class implementing the Singleton Design Pattern
 * Singleton pattern ensures that a class has only one instance
 * and provides a global point of access to that instance.
 * This is particularly useful for logging utilities where we want
 * consistent logging behavior across the entire application.
 */
public class Logger {

    // Step 1: Create a private static instance variable
    // This will hold the single instance of the Logger class
    // 'volatile' keyword ensures thread safety in multithreaded environments
    // by preventing instruction reordering and ensuring visibility across threads
    private static volatile Logger instance;

    // Step 2: Make the constructor private
    // This prevents external classes from creating new instances
    // of the Logger class using the 'new' keyword
    private Logger() {
        // Private constructor prevents instantiation from outside the class
        System.out.println("Logger instance created!");
    }

    // Step 3: Provide a public static method to get the instance
    // This method implements the "Double-Checked Locking" pattern
    // which is thread-safe and efficient
    public static Logger getInstance() {
        // First check - if instance is null, we need to create it
        if (instance == null) {
            // Synchronize on the class to ensure thread safety
            // Only one thread can execute this block at a time
            synchronized (Logger.class) {
                // Second check - another thread might have created the instance
                // while we were waiting for the lock
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        // Return the single instance
        return instance;
    }

    // Step 4: Add logging functionality
    // These methods demonstrate the actual logging capability

    /**
     * Log an informational message
     * @param message The message to log
     */
    public void logInfo(String message) {
        System.out.println("[INFO] " + getCurrentTimestamp() + ": " + message);
    }

    /**
     * Log an error message
     * @param message The error message to log
     */
    public void logError(String message) {
        System.err.println("[ERROR] " + getCurrentTimestamp() + ": " + message);
    }

    /**
     * Log a warning message
     * @param message The warning message to log
     */
    public void logWarning(String message) {
        System.out.println("[WARNING] " + getCurrentTimestamp() + ": " + message);
    }

    /**
     * Helper method to get current timestamp
     * @return Current timestamp as string
     */
    private String getCurrentTimestamp() {
        return java.time.LocalDateTime.now().toString();
    }

    /**
     * Method to demonstrate that this is the same instance
     * @return Hash code of the instance
     */
    public int getInstanceHashCode() {
        return this.hashCode();
    }
}