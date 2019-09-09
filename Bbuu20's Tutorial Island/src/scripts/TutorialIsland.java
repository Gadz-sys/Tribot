package scripts;

import org.tribot.api.General;
import org.tribot.api2007.Game;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;

import java.util.Random;

@ScriptManifest(name = "Bbuu20's Tutorial Island", authors = "bbuu20", category = "Quests", description = "Completes tutorial island. If you enjoy this free script, please leave a Like on the tribot post at:")

public class TutorialIsland extends Script {

    private Random rand = new Random(); //New object for the Random class
    private Tasks tasks = new Tasks(); //New object for the Tasks class

    @Override
    public void run() {
        while (Game.getSetting(281) != 1000) {//while tutorial island !complete
            tasks.getTask();//call the getTask method from the tasks object
            General.sleep(rand.nextInt(500));//Sleep between 0 and 500 ms after each call
        }
    }
}
