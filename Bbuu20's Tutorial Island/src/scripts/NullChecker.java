package scripts;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSObject;

public class NullChecker {

    public RSNPC npcCheck(String npcName) {
        RSNPC[] npcs = NPCs.findNearest(npcName);
        for (RSNPC npc : npcs)
            if (npc != null)
                return npc;
        return null;
    }

    public RSObject objectCheck(String objectName) {
        RSObject[] objects = Objects.findNearest(2, objectName);
        for (RSObject object : objects)
            if (object != null)
                return object;
        return null;
    }

    public RSItem itemCheck(String itemName) {
        RSItem[] items = Inventory.find(itemName);
        for (RSItem item: items)
            if (item != null)
                return item;
        return null;
    }
}
