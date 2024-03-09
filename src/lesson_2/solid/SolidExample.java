package lesson_2.solid;

import lesson_2.solid.lp.InternetConnector;
import lesson_2.solid.lp.MobileConnector;
import lesson_2.solid.lp.Router;

public class SolidExample {

    public static void main(String[] args) {
        // lp
        var mobileConnector = new MobileConnector();
        var internetConnector = new InternetConnector();

        var router = new Router(mobileConnector);
        // and replace it
        router.setConnector(internetConnector);
    }
}
