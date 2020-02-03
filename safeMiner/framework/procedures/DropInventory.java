package scripts.safeMiner.framework.procedures;

import scripts.safeMiner.data.Finals;
import scripts.safeMiner.framework.MainFramework;
import org.tribot.api2007.Inventory;

import static scripts.safeMiner.data.Vars.shouldBank;

public class DropInventory extends MainFramework {
    private Finals finals = new Finals();
    @Override
    public String status() {
        return "Dropping Inventory";
    }

    @Override
    public boolean shouldProceed() {
        return !shouldBank && Inventory.isFull();
    }

    @Override
    public void proceed() {
        Inventory.dropAllExcept(finals.PICK_IDS);
    }
}
