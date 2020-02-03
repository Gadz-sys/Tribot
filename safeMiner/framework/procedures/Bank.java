package scripts.safeMiner.framework.procedures;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.safeMiner.data.Finals;
import scripts.safeMiner.framework.MainFramework;

import static scripts.safeMiner.data.Vars.shouldBank;

public class Bank extends MainFramework {
    private Finals finals = new Finals();

    @Override
    public String status() {
        return "Banking";
    }

    @Override
    public boolean shouldProceed() {
        return shouldBank && Inventory.isFull();
    }

    @Override
    public void proceed() {
        switch (generateSubtasks()) {
            case WalkingToBank:
                DaxWalker.walkToBank();
                break;
            case OpeningBank:
                Banking.openBank();
                Timing.waitCondition(Banking::isBankScreenOpen, General.random(1000, 10000));
                break;
            case DepositingItems:
                Banking.depositAllExcept(finals.PICK_IDS);
                break;
        }
    }

    private enum subtasks {
        WalkingToBank,
        OpeningBank,
        DepositingItems
    }

    private subtasks generateSubtasks() {
        if (!Banking.isInBank())
            return subtasks.WalkingToBank;
        if (!Banking.isBankScreenOpen())
            return subtasks.OpeningBank;
        return subtasks.DepositingItems;
    }
}
