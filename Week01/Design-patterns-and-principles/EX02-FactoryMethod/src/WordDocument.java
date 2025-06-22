// WordDocument.java
/**
 * Concrete implementation of Document interface for Word documents
 *
 * This class represents a Microsoft Word document with specific
 * behaviors and characteristics. It's a "Concrete Product" in
 * the Factory Method pattern.
 */
public class WordDocument implements Document {

    private String fileName;
    private boolean isOpen;

    /**
     * Constructor for WordDocument
     * @param fileName The name of the Word document file
     */
    public WordDocument(String fileName) {
        this.fileName = fileName;
        this.isOpen = false;
        System.out.println("Word document '" + fileName + "' created.");
    }

    @Override
    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Opening Word document: " + fileName);
            System.out.println("Loading Microsoft Word interface...");
            System.out.println("Document ready for text editing and formatting.");
        } else {
            System.out.println("Word document is already open.");
        }
    }

    @Override
    public void save() {
        if (isOpen) {
            System.out.println("Saving Word document: " + fileName);
            System.out.println("Applying Word-specific formatting and styles...");
            System.out.println("Document saved successfully in .docx format.");
        } else {
            System.out.println("Cannot save: Document is not open.");
        }
    }

    @Override
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Closing Word document: " + fileName);
            System.out.println("Releasing Word application resources...");
        } else {
            System.out.println("Document is already closed.");
        }
    }

    @Override
    public String getFileExtension() {
        return ".docx";
    }

    @Override
    public String getDocumentType() {
        return "Microsoft Word Document";
    }

    @Override
    public void performSpecificOperation() {
        System.out.println("Word-specific operation: Checking spelling and grammar...");
        System.out.println("Running Word's built-in spell checker...");
        System.out.println("Spell check completed successfully!");
    }
}
