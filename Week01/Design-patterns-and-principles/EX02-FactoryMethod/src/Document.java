// Document.java
/**
 * Document interface defining the contract for all document types
 *
 * This interface establishes a common set of operations that all
 * document types must implement. This is the "Product" interface
 * in the Factory Method pattern.
 *
 * Why use an interface?
 * - Provides a contract that all document types must follow
 * - Enables polymorphism - we can treat all documents uniformly
 * - Allows for easy extension with new document types
 */
public interface Document {

    /**
     * Opens the document for editing or viewing
     * Each document type will implement this differently
     */
    void open();

    /**
     * Saves the document to storage
     * Implementation varies based on document format
     */
    void save();

    /**
     * Closes the document and releases resources
     * Different document types may have different cleanup requirements
     */
    void close();

    /**
     * Gets the file extension for this document type
     * @return The file extension (e.g., ".docx", ".pdf", ".xlsx")
     */
    String getFileExtension();

    /**
     * Gets the document type name
     * @return Human-readable document type name
     */
    String getDocumentType();

    /**
     * Performs document-specific operations
     * This allows each document type to have unique functionality
     */
    void performSpecificOperation();
}

