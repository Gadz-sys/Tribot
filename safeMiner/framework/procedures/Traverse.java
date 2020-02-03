package scripts.safeMiner.framework.procedures;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.safeMiner.data.Finals;
import scripts.safeMiner.framework.MainFramework;
import scripts.safeMiner.util.Calculations;

public class Traverse extends MainFramework {
    private Calculations calculations = new Calculations();
    private Finals finals = new Finals();

    @Override
    public String status() {
        return "Walking to mine";
    }

    @Override
    public boolean shouldProceed() {
        return !Inventory.isFull() && !calculations.findMine(calculations.oreToTile(), calculations.oreToArea()).contains(Player.getPosition());
    }

    @Override
    public void proceed() {
        DaxWalker.walkTo(calculations.findMine(calculations.oreToTile(), calculations.oreToArea()).getRandomTile());
    }
}
