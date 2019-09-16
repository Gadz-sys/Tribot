package scripts.tasks;

import org.tribot.api.General;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSObject;
import scripts.framework.Task;
import scripts.utility.Antiban;

import static scripts.data.Constants.*;

public class Mine extends Task {

    private RSObject target;

    @Override
    public String taskInfo() {
        return "Mining";
    }

    @Override
    public boolean shouldDo() {
        return (!Inventory.isFull() &&
                Inventory.getCount(pickIds) > 0);
    }

    @Override
    public void doTask() {
        switch (getSubTask()) {
            case WalkToMineArea:
                WebWalking.walkTo(varrockEastMine.getRandomTile());
                break;
            case MoveToDepleted:
                Antiban.get().executeMoveToAnticipated();
                waitForOre();
                break;
            case MineRock:
                if (Antiban.get().getNextTarget(Objects.findNearest(10, rockIds)) != null) {
                    if (Player.getAnimation() == -1 && !Player.isMoving()) {
                        General.sleep(800, 1000);
                        if (Player.getAnimation() == -1 && !Player.isMoving()) {
                            Antiban.get().getNextTarget(Objects.findNearest(10, rockIds)).click("Mine");
                            General.sleep(300, 1000);
                        }
                    }
                    Antiban.get().setHoverAndMenuOpenBooleans();
                }
                break;
            case IdleWhileMining:
                long start = System.currentTimeMillis();
                if (Player.getAnimation() != -1)
                    Antiban.get().executeHoverOrMenuOpen(target);
                while (Player.getAnimation() != -1) {
                    Antiban.get().idling();
                }
                long stop = System.currentTimeMillis();
                Antiban.get().generateAndSleep((int)(stop - start));
                break;
        }
    }

    private enum SubTask {
        WalkToMineArea,
        MoveToDepleted,
        MineRock,
        IdleWhileMining
    }

    private SubTask getSubTask() {

        if (!varrockEastMine.contains(Player.getPosition()))
            return SubTask.WalkToMineArea;

        RSObject[] rocks = Objects.find(10, rockIds);

        if (rocks.length == 0) {
            System.out.print("Moving to depleted");
            return SubTask.MoveToDepleted;
        }

        target = Antiban.get().getNextTarget(rocks);

        if (Player.getAnimation() == -1 && target != null) {
            if (target.isOnScreen()) {
                System.out.print("Clicking Rock");
                return SubTask.MineRock;
            }
            else {
                Walking.blindWalkTo(target.getPosition());
                Camera.turnToTile(target.getPosition());
            }
        }

        return SubTask.IdleWhileMining;
    }

    private void waitForOre() {
        long idleStart = System.currentTimeMillis();
        while (Antiban.get().getNextTarget(Objects.findNearest(10, rockIds)) == null || Objects.findNearest(10, rockIds).length == 0) {
            Antiban.get().idling();
            General.sleep(25, 50);
        }
        long idleStop = System.currentTimeMillis();
        Antiban.get().generateAndSleep((int)(idleStop - idleStart));
    }
}
