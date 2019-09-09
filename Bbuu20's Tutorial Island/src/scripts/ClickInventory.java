package scripts;

import org.tribot.api.General;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.types.RSItem;

import java.util.Random;

public class ClickInventory {

    private NullChecker nullChecker = new NullChecker();
    private Random rand = new Random();

    public void clickInventory(String inventoryItem) {
        if (GameTab.TABS.INVENTORY.isOpen()) {
            RSItem item = nullChecker.itemCheck(inventoryItem);
            System.out.print(item);
            if (item != null) {
                item.click();
                General.sleep(rand.nextInt(500) + 1500);
            }
        }
        else
            GameTab.TABS.INVENTORY.open();
    }
}
