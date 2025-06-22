// ExcelDocument.java
/**
 * Concrete implementation of Document interface for Excel documents
 *
 * This class represents a Microsoft Excel spreadsheet with
 * spreadsheet-specific behaviors and calculations.
 */
public class ExcelDocument implements Document {

    private String fileName;
    private boolean isOpen;
    private int numberOfSheets;

    /**
     * Constructor for ExcelDocument
     * @param fileName The name of the Excel document file
     */
    public ExcelDocument(String fileName) {
        this.fileName = fileName;
        this.isOpen = false;
        this.numberOfSheets = 1; // Default to one sheet
        System.out.println("Excel document '" + fileName + "' created.");
    }

    @Override
    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Opening Excel document: " + fileName);
            System.out.println("Loading Microsoft Excel interface...");
            System.out.println("Initializing " + numberOfSheets + " worksheet(s)...");
            System.out.println("Document ready for data entry and calculations.");
        } else {
            System.out.println("Excel document is already open.");
        }
    }

    @Override
    public void save() {
        if (isOpen) {
            System.out.println("Saving Excel document: " + fileName);
            System.out.println("Recalculating formulas and updating charts...");
            System.out.println("Document saved successfully in .xlsx format.");
        } else {
            System.out.println("Cannot save: Document is not open.");
        }
    }

    @Override
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Closing Excel document: " + fileName);
            System.out.println("Releasing Excel application resources...");
        } else {
            System.out.println("Document is already closed.");
        }
    }

    @Override
    public String getFileExtension() {
        return ".xlsx";
    }

    @Override
    public String getDocumentType() {
        return "Microsoft Excel Spreadsheet";
    }

    @Override
    public void performSpecificOperation() {
        System.out.println("Excel-specific operation: Running macro calculations...");
        System.out.println("Executing VBA macros and updating pivot tables...");
        System.out.println("All calculations completed successfully!");
    }

    /**
     * Excel-specific method to add a new worksheet
     * This demonstrates how concrete classes can have additional methods
     */
    public void addWorksheet(String sheetName) {
        numberOfSheets++;
        System.out.println("Added new worksheet: " + sheetName);
        System.out.println("Total worksheets: " + numberOfSheets);
    }
}