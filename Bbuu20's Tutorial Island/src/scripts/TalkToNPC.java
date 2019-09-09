package scripts;

import org.tribot.api.General;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.NPCChat;
import org.tribot.api2007.types.RSNPC;

import java.util.Random;

public class TalkToNPC {

    private NullChecker nullChecker = new NullChecker();
    private Random rand = new Random();

    public void talkToNpc(String npcName) {
        RSNPC rsnpc = nullChecker.npcCheck(npcName);
        System.out.print(rsnpc);
        if (NPCChat.getMessage() == null && (Interfaces.get(231, 3) == null || Interfaces.get(231, 3).isHidden()) && (Interfaces.get(219, 1) == null || Interfaces.get(219, 1).isHidden()) && (Interfaces.get(193, 0, 2) == null || Interfaces.get(193, 0, 2).isHidden()) && rsnpc != null) {
            rsnpc.click();
            General.sleep(rand.nextInt(500) + 1500);
        }
        if (NPCChat.getMessage() != null) {
            NPCChat.clickContinue(true);
        }
        else if (Interfaces.get(219, 1) != null && !Interfaces.get(219, 1).isHidden()) {
            if (!Interfaces.get(219, 1, 1).getText().contains("What's an Iron")) {
                Interfaces.get(219, 1, 1).click();
            }
            else {
                Interfaces.get(219, 1, 3).click();
            }
        }
        else if (Interfaces.get(231, 3) != null && !Interfaces.get(231, 3).isHidden())
            Interfaces.get(231, 3).click();
    }
}