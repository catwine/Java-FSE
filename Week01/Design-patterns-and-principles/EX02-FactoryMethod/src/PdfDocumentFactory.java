//PdfDocumentFactory.java
/**
 * Concrete factory for creating PDF documents
 *
 * This factory is responsible for creating PdfDocument instances
 * and can include PDF-specific initialization logic.
 */
public class PdfDocumentFactory extends DocumentFactory {

    /**
     * Implementation of the factory method for PDF documents
     *
     * @param fileName The name of the PDF document to create
     * @return A new PdfDocument instance
     */
    @Override
    public Document createDocument(String fileName) {
        System.out.println("PdfDocumentFactory: Creating PDF document...");

        // Ensure the filename has the correct extension
        if (!fileName.toLowerCase().endsWith(".pdf")) {
            fileName += ".pdf";
        }

        return new PdfDocument(fileName);
    }

    /**
     * Returns the file extensions supported by this factory
     *
     * @return Array of supported PDF document extensions
     */
    @Override
    public String[] getSupportedExtensions() {
        return new String[]{".pdf"};
    }
}