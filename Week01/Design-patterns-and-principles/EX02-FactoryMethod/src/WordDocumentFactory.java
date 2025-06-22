// WordDocumentFactory.java
/**
 * Concrete factory for creating Word documents
 *
 * This is a "Concrete Creator" in the Factory Method pattern.
 * It implements the factory method to create WordDocument instances.
 */
public class WordDocumentFactory extends DocumentFactory {

    /**
     * Implementation of the factory method for Word documents
     *
     * @param fileName The name of the Word document to create
     * @return A new WordDocument instance
     */
    @Override
    public Document createDocument(String fileName) {
        System.out.println("WordDocumentFactory: Creating Word document...");

        // Ensure the filename has the correct extension
        if (!fileName.toLowerCase().endsWith(".docx")) {
            fileName += ".docx";
        }

        return new WordDocument(fileName);
    }

    /**
     * Returns the file extensions supported by this factory
     *
     * @return Array of supported Word document extensions
     */
    @Override
    public String[] getSupportedExtensions() {
        return new String[]{".doc", ".docx"};
    }
}