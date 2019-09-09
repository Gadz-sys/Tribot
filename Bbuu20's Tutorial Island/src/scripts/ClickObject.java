package scripts;

import org.tribot.api.General;
import org.tribot.api2007.types.RSObject;

import java.util.Random;

public class ClickObject {

    private NullChecker nullChecker = new NullChecker();
    private Random rand = new Random();

    public void clickObject(String objectName) {
        RSObject rsObject = nullChecker.objectCheck(objectName);
        System.out.print(rsObject);
        if (rsObject != null) {
            rsObject.click();
            General.sleep(rand.nextInt(1500) + 2500);
        }
    }
}
