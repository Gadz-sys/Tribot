package scripts.safeMiner.framework.procedures;

import org.tribot.api.DynamicClicking;
import org.tribot.api.General;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.safeMiner.data.Finals;
import scripts.safeMiner.data.Vars;
import scripts.safeMiner.framework.MainFramework;
import scripts.safeMiner.util.Antiban;
import scripts.safeMiner.util.Calculations;

import static scripts.safeMiner.data.Vars.*;

public class Mine extends MainFramework {
    private Finals finals = new Finals();
    private Calculations calculations = new Calculations();
    private RSObject target;

    private long lastMiningWaitTime, averageMiningWaitTime, totalMiningWaitTime, totalMiningInstances;

    private void updateAntibanStatistics(long startedMining) {
        lastMiningWaitTime = System.currentTimeMillis() - startedMining;
        totalMiningInstances++;
        totalMiningWaitTime+=lastMiningWaitTime;
        averageMiningWaitTime = totalMiningWaitTime / totalMiningInstances;
    }

    @Override
    public String status() {
        return "Mining";
    }

    @Override
    public boolean shouldProceed() {
        return !Inventory.isFull() && calculations.findMine(calculations.oreToTile(), calculations.oreToArea()).contains(Player.getPosition());
    }

    @Override
    public void proceed() {
        //if we're mining
        if (Player.getAnimation() != -1) {

            long startedMining = System.currentTimeMillis();

            while (Player.getAnimation() != -1) {
                RSObject[] rocks = Objects.find(miningRadius, calculations.oreStringToIDs(oreToMine));
                if (rocks != null && rocks.length > 0) {
                    if (rocks[0] != target) {
                        Antiban.get().hoverAndMenu(rocks[0]);
                        Vars.rocks = rocks;
                    }
                    else {
                        Antiban.get().hoverAndMenu(rocks[1]);
                        rocks[0] = rocks[1];
                        Vars.rocks = rocks;
                    }
                    Antiban.get().idleTimedActions();
                }
            }
            //Once we've stopped mining, update our ABC statistics and figure out our reaction time
            updateAntibanStatistics(startedMining);
            Antiban.get().generateAndSleep((int)averageMiningWaitTime);
        }

        if (findAndClickRock()) { //if the rock was found, and was clicked successfully
            Antiban.get().setBools();
            Antiban.get().generateSupportingTrackerInfo((int)averageMiningWaitTime);
            General.sleep(General.randomSD(1, 15000, Player.getPosition().distanceTo(target) * 962, 3));
            calculations.waitUntil(!Player.isMoving() && Player.getAnimation() == -1, 100, 1500);
        }
    }
    private boolean findAndClickRock() {

        if (rocks != null && rocks.length > 0) {
            target = Antiban.get().getNextTarget(rocks);

            //in the unlikely scenario that the rock is not on screen, rotate camera/move to the rock
            if (!target.isOnScreen()) {
                DaxWalker.walkTo(target.getPosition());
                Camera.turnToTile(target.getPosition());
            }
            return DynamicClicking.clickRSObject(target, "Mine"); //return whether or not the rock was clicked successfully
        }
        else {
            RSObject[] tempRocks = Objects.find(miningRadius, calculations.oreStringToIDs(oreToMine));
            target = Antiban.get().getNextTarget(tempRocks);

            //in the unlikely scenario that the rock is not on screen, rotate camera/move to the rock
            if (!target.isOnScreen()) {
                DaxWalker.walkTo(target.getPosition());
                Camera.turnToTile(target.getPosition());
            }
            return DynamicClicking.clickRSObject(target, "Mine"); //return whether or not the rock was clicked successfully
        }
    }
}
