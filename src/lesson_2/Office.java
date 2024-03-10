package lesson_2;

import lesson_2.common.AbstractConnector;

public class Office {

    private String name;

    public Office(String name) {
        this.name = name;
    }

    public void connectToAnotherOffice(AbstractConnector connector) {
        connector.connect(); // use abstract method
    }
}
