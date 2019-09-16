package scripts;

import org.tribot.api.General;
import org.tribot.api2007.util.ThreadSettings;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import scripts.framework.Task;
import scripts.tasks.*;

import java.util.ArrayList;

@ScriptManifest(
        name = "Bbuu20's Dynamic Miner",
        description = "The ultimate dynamic mining script! Detects which pickaxe to use (will buy from ge if not in" +
                " inventory or bank), and which rocks to mine (based on level). Currently only mines in varrock east mine.",
        category = "Mining",
        authors = "bbuu20"
)

public class DynamicMiner extends Script {

    private ArrayList<Task> tasks = new ArrayList<>();


    @Override
    public void run() {

        General.useAntiBanCompliance(true);
        ThreadSettings.get().setClickingAPIUseDynamic(true);
        newTasks();

        while (true) {
            doTasks();
            System.out.print("Loop");
            General.sleep(20, 100);
        }
    }

    private void newTasks() {
        tasks.add(new Mine());
        tasks.add(new Bank());
    }

    private void doTasks() {
        for (Task task : tasks) {
            System.out.print("Checking which task should be done...");
            if (task.shouldDo()) {
                System.out.print("Doing task");
                task.doTask();
                General.sleep(50, 150);
                break;
            }
        }
    }
}
