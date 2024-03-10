package lesson_2;

import lesson_2.common.Connector;
import lesson_2.common.MobileConnector;
import lesson_2.common.OfficeConnector;

public class LessonTwo {

    public static void main(String[] args) {
        // Encapsulation
        var connector = new Connector();
        connector.createConnection("host");

        // Inheritance
        var mobileConnector = new MobileConnector("temp", "localhost", 8080);
        mobileConnector.connect(); // abstract, we don't have implementation

        var officeConnector = new OfficeConnector("localhost", 8080);
        officeConnector.connect(); // own

        // Polymorphism
        var office = new Office("Budva-1");
        var officeConnectorOne = new OfficeConnector("localhost", 8080);

        office.connectToAnotherOffice(officeConnectorOne);

        var officeBar = new Office("Bar-1");
        var mobileConnectorOne = new MobileConnector("MTEL", "localhost", 8081);
        officeBar.connectToAnotherOffice(mobileConnectorOne);
    }
}
