// ExcelDocumentFactory.java
/**
 * Concrete factory for creating Excel documents
 *
 * This factory handles the creation of ExcelDocument instances
 * and can perform Excel-specific initialization.
 */
public class ExcelDocumentFactory extends DocumentFactory {

    /**
     * Implementation of the factory method for Excel documents
     *
     * @param fileName The name of the Excel document to create
     * @return A new ExcelDocument instance
     */
    @Override
    public Document createDocument(String fileName) {
        System.out.println("ExcelDocumentFactory: Creating Excel document...");

        // Ensure the filename has the correct extension
        if (!fileName.toLowerCase().endsWith(".xlsx") &&
                !fileName.toLowerCase().endsWith(".xls")) {
            fileName += ".xlsx";
        }

        return new ExcelDocument(fileName);
    }

    /**
     * Returns the file extensions supported by this factory
     *
     * @return Array of supported Excel document extensions
     */
    @Override
    public String[] getSupportedExtensions() {
        return new String[]{".xls", ".xlsx"};
    }
}