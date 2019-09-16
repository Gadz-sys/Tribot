package scripts.tasks;

import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.WebWalking;
import scripts.framework.Task;
import static scripts.data.Constants.*;

public class Bank extends Task {
    @Override
    public String taskInfo() {
        return "Banking";
    }

    @Override
    public boolean shouldDo() {
        return Inventory.isFull();
    }

    @Override
    public void doTask() {
        switch (getSubTask()) {
            case WalkingToBank:
                WebWalking.walkToBank();
                break;
            case OpeningBank:
                Banking.openBank();
                break;
            case Depositing:
                Banking.depositAllExcept(pickIds);
                break;
        }
    }

    private enum SubTask {
        WalkingToBank,
        OpeningBank,
        Depositing
    }

    private SubTask getSubTask() {
        if (!Banking.isInBank())
            return SubTask.WalkingToBank;
        if (!Banking.isBankScreenOpen())
            return SubTask.OpeningBank;
        return SubTask.Depositing;
    }
}
