package assignment4.TemplateMethodPattern;

public class PDFReportGenerator extends ReportGenerator {
    protected void formatHeader() {
        System.out.println("Formatting PDF Header");
    }

    protected void formatBody() {
        System.out.println("Formatting PDF Body");
    }

    protected void formatFooter() {
        System.out.println("Formatting PDF Footer");
    }
}
