package lessonTwo.solid;


import lessonTwo.solid.lp.InternetConnector;
import lessonTwo.solid.lp.MobileConnector;
import lessonTwo.solid.lp.Router;

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
