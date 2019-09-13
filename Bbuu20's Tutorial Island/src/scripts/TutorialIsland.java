package scripts;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Game;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

@ScriptManifest(name = "Bbuu20's Tutorial Island", authors = "bbuu20", category = "Quests", description = "Completes tutorial island. If you enjoy this free script, please leave a Like on the tribot post at: https://tribot.org/forums/topic/80589-bbuu20s-tutorial-island-free-open-source/", version = 1.2)

public class TutorialIsland extends Script implements Painting {

    private Random rand = new Random(); //New object for the Random class
    private Tasks tasks = new Tasks(); //New object for the Tasks class

    @Override
    public void run() {
        while (Game.getSetting(281) != 1000) {//while tutorial island !complete
            tasks.getTask();//call the getTask method from the tasks object
            General.sleep(rand.nextInt(500));//Sleep between 0 and 500 ms after each call
        }
    }

    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }
    private final Image img = getImage("https://imgur.com/Z4mdt23.png");

    private static final long startTime = System.currentTimeMillis();

    Font font = new Font("Verdana", Font.BOLD, 24);
    public void onPaint(Graphics g) {

        Graphics2D gg = (Graphics2D)g;
        gg.drawImage(img, 1, 338, null);

        long timeRan = System.currentTimeMillis() - startTime;

        g.setFont(font);

        g.setColor(new Color(0, 0, 0));
        g.drawString(Timing.msToString(timeRan), 145, 412);
        g.drawString(tasks.currentTask, 200, 453);
    }
}
