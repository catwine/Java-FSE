// PdfDocument.java
/**
 * Concrete implementation of Document interface for PDF documents
 *
 * This class represents a PDF document with PDF-specific behaviors.
 * PDFs are typically read-only or require special editing tools.
 */
public class PdfDocument implements Document {

    private String fileName;
    private boolean isOpen;
    private boolean isEncrypted;

    /**
     * Constructor for PdfDocument
     * @param fileName The name of the PDF document file
     */
    public PdfDocument(String fileName) {
        this.fileName = fileName;
        this.isOpen = false;
        this.isEncrypted = false; // For simplicity, assume not encrypted
        System.out.println("PDF document '" + fileName + "' created.");
    }

    @Override
    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Opening PDF document: " + fileName);
            System.out.println("Loading PDF reader...");
            System.out.println("Document ready for viewing and annotation.");
        } else {
            System.out.println("PDF document is already open.");
        }
    }

    @Override
    public void save() {
        if (isOpen) {
            System.out.println("Saving PDF document: " + fileName);
            System.out.println("Applying PDF compression and optimization...");
            System.out.println("Document saved successfully in .pdf format.");
        } else {
            System.out.println("Cannot save: Document is not open.");
        }
    }

    @Override
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Closing PDF document: " + fileName);
            System.out.println("Releasing PDF reader resources...");
        } else {
            System.out.println("Document is already closed.");
        }
    }

    @Override
    public String getFileExtension() {
        return ".pdf";
    }

    @Override
    public String getDocumentType() {
        return "Portable Document Format (PDF)";
    }

    @Override
    public void performSpecificOperation() {
        System.out.println("PDF-specific operation: Adding digital signature...");
        System.out.println("Generating cryptographic signature...");
        System.out.println("Digital signature added successfully!");
    }
}
