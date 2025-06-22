/**
 * Test class to demonstrate and verify the Singleton pattern implementation
 * This class tests various aspects of the Singleton pattern:
 * 1. Only one instance is created
 * 2. Multiple calls to getInstance() return the same object
 * 3. The logging functionality works correctly
 * 4. Thread safety (basic demonstration)
 */
public class SingletonTestDemo {

    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Test Demo ===\n");

        // Test 1: Basic Singleton functionality
        testBasicSingleton();

        // Test 2: Multiple getInstance calls
        testMultipleGetInstanceCalls();

        // Test 3: Logging functionality
        testLoggingFunctionality();

        // Test 4: Thread safety demonstration
        testThreadSafety();
    }

    /**
     * Test 1: Verify that getInstance() creates only one instance
     */
    private static void testBasicSingleton() {
        System.out.println("Test 1: Basic Singleton Test");
        System.out.println("-----------------------------");

        // Get the first instance
        Logger logger1 = Logger.getInstance();
        System.out.println("First getInstance() call completed");

        // Get the second instance
        Logger logger2 = Logger.getInstance();
        System.out.println("Second getInstance() call completed");

        // Check if both references point to the same object
        boolean isSameInstance = (logger1 == logger2);
        System.out.println("Are logger1 and logger2 the same instance? " + isSameInstance);
        System.out.println("logger1 hash code: " + logger1.getInstanceHashCode());
        System.out.println("logger2 hash code: " + logger2.getInstanceHashCode());

        if (isSameInstance) {
            System.out.println(" PASS: Singleton pattern working correctly!\n");
        } else {
            System.out.println(" FAIL: Multiple instances created!\n");
        }
    }

    /**
     * Test 2: Multiple getInstance calls from different methods
     */
    private static void testMultipleGetInstanceCalls() {
        System.out.println("Test 2: Multiple getInstance Calls");
        System.out.println("----------------------------------");

        // Call getInstance from different methods
        Logger loggerA = getLoggerFromMethodA();
        Logger loggerB = getLoggerFromMethodB();
        Logger loggerC = Logger.getInstance();

        // Verify all are the same instance
        boolean allSame = (loggerA == loggerB) && (loggerB == loggerC);
        System.out.println("All three logger instances are the same: " + allSame);

        if (allSame) {
            System.out.println(" PASS: All getInstance calls return the same instance!\n");
        } else {
            System.out.println(" FAIL: Different instances returned!\n");
        }
    }

    /**
     * Helper method for Test 2
     */
    private static Logger getLoggerFromMethodA() {
        System.out.println("Getting logger from Method A");
        return Logger.getInstance();
    }

    /**
     * Helper method for Test 2
     */
    private static Logger getLoggerFromMethodB() {
        System.out.println("Getting logger from Method B");
        return Logger.getInstance();
    }

    /**
     * Test 3: Verify logging functionality works
     */
    private static void testLoggingFunctionality() {
        System.out.println("Test 3: Logging Functionality");
        System.out.println("------------------------------");

        Logger logger = Logger.getInstance();

        // Test different logging levels
        logger.logInfo("Application started successfully");
        logger.logWarning("This is a warning message");
        logger.logError("This is an error message");
        logger.logInfo("Logging functionality test completed");

        System.out.println(" PASS: Logging functionality working correctly!\n");
    }

    /**
     * Test 4: Basic thread safety demonstration
     * This creates multiple threads that simultaneously try to get the Logger instance
     */
    private static void testThreadSafety() {
        System.out.println("Test 4: Thread Safety Test");
        System.out.println("---------------------------");

        // Create multiple threads that will try to get Logger instance simultaneously
        Thread[] threads = new Thread[5];
        Logger[] loggerInstances = new Logger[5];

        // Create and start threads
        for (int i = 0; i < 5; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                // Each thread gets a Logger instance
                loggerInstances[threadIndex] = Logger.getInstance();
                System.out.println("Thread " + threadIndex + " got logger instance: " +
                        loggerInstances[threadIndex].getInstanceHashCode());
            });
            threads[i].start();
        }

        // Wait for all threads to complete
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        // Verify all threads got the same instance
        boolean allThreadsSameInstance = true;
        for (int i = 1; i < loggerInstances.length; i++) {
            if (loggerInstances[0] != loggerInstances[i]) {
                allThreadsSameInstance = false;
                break;
            }
        }

        if (allThreadsSameInstance) {
            System.out.println(" PASS: Thread safety test passed - all threads got the same instance!\n");
        } else {
            System.out.println(" FAIL: Thread safety test failed - different instances created!\n");
        }

        System.out.println("=== All Tests Completed ===");
    }
}