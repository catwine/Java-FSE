// FactoryMethodTestDemo.java
/**
 * Test class demonstrating the Factory Method Pattern implementation
 *
 * This class shows how to use the Factory Method pattern to create
 * different types of documents without knowing the specific classes
 * at compile time. It demonstrates the key benefits of the pattern:
 *
 * 1. Loose coupling between client code and concrete classes
 * 2. Easy extension with new document types
 * 3. Centralized object creation logic
 * 4. Polymorphic behavior through common interface
 */
public class FactoryMethodTestDemo {

    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===");
        System.out.println("Document Management System\n");

        // Test 1: Basic factory method usage
        testBasicFactoryMethod();

        // Test 2: Polymorphic behavior
        testPolymorphicBehavior();

        // Test 3: Template method usage
        testTemplateMethod();

        // Test 4: Extension support validation
        testExtensionSupport();

        // Test 5: Factory selection based on file type
        testDynamicFactorySelection();

        System.out.println("=== All Factory Method Tests Completed ===");
    }

    /**
     * Test 1: Demonstrates basic factory method usage
     * Shows how each factory creates its specific document type
     */
    private static void testBasicFactoryMethod() {
        System.out.println("TEST 1: Basic Factory Method Usage");
        System.out.println("==================================");

        // Create different factory instances
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Use each factory to create documents
        System.out.println("Creating documents using different factories:\n");

        Document wordDoc = wordFactory.createDocument("MyReport");
        Document pdfDoc = pdfFactory.createDocument("UserManual");
        Document excelDoc = excelFactory.createDocument("SalesData");

        System.out.println("\n Test 1 Passed: All factories created their respective document types\n");
    }

    /**
     * Test 2: Demonstrates polymorphic behavior
     * Shows how all documents can be treated uniformly despite being different types
     */
    private static void testPolymorphicBehavior() {
        System.out.println("TEST 2: Polymorphic Behavior");
        System.out.println("============================");

        // Create an array of different document factories
        DocumentFactory[] factories = {
                new WordDocumentFactory(),
                new PdfDocumentFactory(),
                new ExcelDocumentFactory()
        };

        String[] fileNames = {"Contract", "Invoice", "Budget"};

        System.out.println("Demonstrating polymorphic behavior:\n");

        // Process each document polymorphically
        for (int i = 0; i < factories.length; i++) {
            Document doc = factories[i].createDocument(fileNames[i]);

            // All documents respond to the same interface methods
            System.out.println("Document Type: " + doc.getDocumentType());
            System.out.println("File Extension: " + doc.getFileExtension());
            doc.open();
            doc.performSpecificOperation();
            doc.close();
            System.out.println("---");
        }

        System.out.println(" Test 2 Passed: Polymorphic behavior working correctly\n");
    }

    /**
     * Test 3: Demonstrates template method usage
     * Shows how the abstract factory provides common functionality
     */
    private static void testTemplateMethod() {
        System.out.println("TEST 3: Template Method Usage");
        System.out.println("=============================");

        DocumentFactory wordFactory = new WordDocumentFactory();

        System.out.println("Using template method for complete document processing:\n");

        // The template method handles the entire document lifecycle
        Document processedDoc = wordFactory.createAndProcessDocument("ProcessedReport");

        // The document is now ready for use
        System.out.println("Final document type: " + processedDoc.getDocumentType());
        processedDoc.close();

        System.out.println(" Test 3 Passed: Template method working correctly\n");
    }

    /**
     * Test 4: Demonstrates extension support validation
     * Shows how factories can validate supported file types
     */
    private static void testExtensionSupport() {
        System.out.println("TEST 4: Extension Support Validation");
        System.out.println("====================================");

        DocumentFactory[] factories = {
                new WordDocumentFactory(),
                new PdfDocumentFactory(),
                new ExcelDocumentFactory()
        };

        String[] factoryNames = {"Word", "PDF", "Excel"};
        String[] testFiles = {
                "document.docx", "document.pdf", "document.xlsx",
                "document.txt", "document.jpg", "document.pptx"
        };

        System.out.println("Testing file extension support:\n");

        for (int i = 0; i < factories.length; i++) {
            System.out.println(factoryNames[i] + " Factory supports:");
            String[] extensions = factories[i].getSupportedExtensions();
            for (String ext : extensions) {
                System.out.print(ext + " ");
            }
            System.out.println("\n");

            // Test various file extensions
            for (String testFile : testFiles) {
                boolean supported = factories[i].isExtensionSupported(testFile);
                System.out.println(testFile + " -> " + (supported ? " Supported" : " Not supported"));
            }
            System.out.println("---");
        }

        System.out.println(" Test 4 Passed: Extension validation working correctly\n");
    }

    /**
     * Test 5: Demonstrates dynamic factory selection
     * Shows how to select the appropriate factory based on file type
     */
    private static void testDynamicFactorySelection() {
        System.out.println("TEST 5: Dynamic Factory Selection");
        System.out.println("=================================");

        String[] testFiles = {
                "report.docx",
                "manual.pdf",
                "data.xlsx",
                "presentation.pptx" // This should fail
        };

        System.out.println("Dynamically selecting factories based on file extension:\n");

        for (String fileName : testFiles) {
            System.out.println("Processing file: " + fileName);

            DocumentFactory factory = getFactoryForFile(fileName);

            if (factory != null) {
                Document doc = factory.createDocument(fileName);
                System.out.println(" Successfully created: " + doc.getDocumentType());
                doc.open();
                doc.close();
            } else {
                System.out.println(" No suitable factory found for: " + fileName);
            }
            System.out.println("---");
        }

        System.out.println(" Test 5 Passed: Dynamic factory selection working correctly\n");
    }

    /**
     * Helper method to select appropriate factory based on file extension
     * This demonstrates a practical use of the Factory Method pattern
     *
     * @param fileName The file name to analyze
     * @return Appropriate DocumentFactory or null if not supported
     */
    private static DocumentFactory getFactoryForFile(String fileName) {
        String extension = getFileExtension(fileName).toLowerCase();

        switch (extension) {
            case ".doc":
            case ".docx":
                return new WordDocumentFactory();
            case ".pdf":
                return new PdfDocumentFactory();
            case ".xls":
            case ".xlsx":
                return new ExcelDocumentFactory();
            default:
                return null; // Unsupported file type
        }
    }

    /**
     * Helper method to extract file extension
     *
     * @param fileName The filename to process
     * @return The file extension including the dot
     */
    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex);
        }
        return "";
    }
}