// DocumentFactory.java
/**
 * Abstract DocumentFactory class implementing the Factory Method Pattern
 *
 * This is the "Creator" class in the Factory Method pattern.
 * It defines the factory method that subclasses must implement
 * to create specific types of documents.
 *
 * Why use an abstract class instead of interface?
 * - We can provide common functionality that all factories share
 * - We can enforce the factory method contract through abstract methods
 * - We can add template methods that use the factory method
 */
public abstract class DocumentFactory {

    /**
     * Abstract factory method - this is the core of the Factory Method pattern
     *
     * Each concrete factory must implement this method to create
     * the appropriate type of document. This method is called
     * the "Factory Method" because it's responsible for creating objects.
     *
     * @param fileName The name of the document file to create
     * @return A concrete Document instance
     */
    public abstract Document createDocument(String fileName);

    /**
     * Template method that uses the factory method
     *
     * This method demonstrates how the abstract factory can provide
     * common functionality while delegating object creation to subclasses.
     * This is a template method pattern working with factory method pattern.
     *
     * @param fileName The name of the document to create and process
     * @return The processed document
     */
    public Document createAndProcessDocument(String fileName) {
        System.out.println("=== Document Creation and Processing ===");

        // Step 1: Create the document using the factory method
        System.out.println("Step 1: Creating document...");
        Document document = createDocument(fileName);

        // Step 2: Open the document
        System.out.println("\nStep 2: Opening document...");
        document.open();

        // Step 3: Perform document-specific operations
        System.out.println("\nStep 3: Performing document-specific operations...");
        document.performSpecificOperation();

        // Step 4: Save the document
        System.out.println("\nStep 4: Saving document...");
        document.save();

        System.out.println("\n=== Document processing completed ===\n");

        return document;
    }

    /**
     * Utility method to get supported file extensions
     * This demonstrates additional functionality that can be provided
     * by the abstract factory class.
     *
     * @return Array of supported file extensions
     */
    public abstract String[] getSupportedExtensions();

    /**
     * Method to validate if a file extension is supported
     *
     * @param fileName The file name to validate
     * @return true if the extension is supported, false otherwise
     */
    public boolean isExtensionSupported(String fileName) {
        String[] extensions = getSupportedExtensions();
        String fileExtension = getFileExtension(fileName);

        for (String extension : extensions) {
            if (extension.equalsIgnoreCase(fileExtension)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method to extract file extension from filename
     *
     * @param fileName The filename to process
     * @return The file extension including the dot (e.g., ".docx")
     */
    private String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex);
        }
        return "";
    }
}


