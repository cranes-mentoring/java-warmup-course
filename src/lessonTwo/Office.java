package lessonTwo;

import lessonTwo.common.AbstractConnector;

public class Office {

    private String name;

    public Office(String name) {
        this.name = name;
    }

    public void connectToAnotherOffice(AbstractConnector connector) {
        connector.connect(); // use abstract method
    }
}
