package scripts;

import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

public class AreaChecks {

    TalkToNPC talkToNPC = new TalkToNPC();
    ClickObject clickObject = new ClickObject();

    public void kitchenArea() {
        if ((new RSArea(new RSTile(3073, 3091, 0), new RSTile(3078, 3083, 0))).contains(Player.getPosition()))
            talkToNPC.talkToNpc("Master Chef");
        else {
            Walking.blindWalkTo(new RSTile(3079, 3084));
            if (Player.getPosition().equals(new RSTile(3079, 3084)))
                clickObject.clickObject("Door");
        }
    }

    public void questArea() {
        if ((new RSArea(new RSTile(3089, 3119), new RSTile(3080, 3125))).contains(Player.getPosition()))
            talkToNPC.talkToNpc("Quest Guide");
        else {
            Walking.blindWalkTo(new RSTile(3086, 3126));
            if (Player.getPosition().equals(new RSTile(3086, 3126)))
                clickObject.clickObject("Door");
        }
    }

    public void advisorArea() {
        if ((new RSArea(new RSTile(3125, 3125, 0), new RSTile(3129, 3123, 0))).contains(Player.getPosition()))
            talkToNPC.talkToNpc("Account Guide");
        else {
            Walking.blindWalkTo(new RSTile(3124, 3124));
            if (Player.getPosition().equals(new RSTile(3124, 3124)))
                clickObject.clickObject("Door");
        }
    }

}
