package scripts.safeMiner;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Login;
import org.tribot.api2007.Skills;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.dax_api.api_lib.models.DaxCredentials;
import scripts.dax_api.api_lib.models.DaxCredentialsProvider;
import scripts.safeMiner.framework.MainFramework;
import scripts.safeMiner.framework.procedures.Bank;
import scripts.safeMiner.framework.procedures.DropInventory;
import scripts.safeMiner.framework.procedures.Mine;
import scripts.safeMiner.framework.procedures.Traverse;
import scripts.safeMiner.graphics.gui.SwingUI;

import java.awt.*;
import java.util.ArrayList;

@ScriptManifest(
        name = "Bbuu20's Smart Miner",
        authors = "bbuu20",
        gameMode = 1,
        version = 1.0,
        description = "Full ABC2 Level 10 implementation! " +
                "Mines all f2p ores besides runite. More ores will be added soon. " +
                "Decides which mine is the most efficient for the selected ore, and walks to it. " +
                "More mining locations will be added in the future. " +
                "Supports banking and powermining!",
        category = "Mining"
)

public class SafeMiner extends Script implements Painting {
    private ArrayList<MainFramework> procedures = new ArrayList<>();

    private static final long startTime = System.currentTimeMillis();
    private int startLvl = Skills.getActualLevel(Skills.SKILLS.MINING);
    private int startXP = Skills.getXP(Skills.SKILLS.MINING);

    private Font font = new Font("Verdana", Font.BOLD, 14);

    @Override
    public void run() {
        DaxWalker.setCredentials(new DaxCredentialsProvider() {
            @Override
            public DaxCredentials getDaxCredentials() {
                return new DaxCredentials("sub_DPjXXzL5DeSiPf", "PUBLIC-KEY");
            }
        });
        General.useAntiBanCompliance(true);

        newProcedures();

        new SwingUI().drawUI();

        while (Login.getLoginState().equals(Login.STATE.INGAME)) {
            carryOutProcedures();
            General.sleep(20, 100);
        }
    }
    
    private void newProcedures() {
        procedures.add(new Mine());
        procedures.add(new Traverse());
        procedures.add(new DropInventory());
        procedures.add(new Bank());
    }
    
    private void carryOutProcedures() {
        for (MainFramework procedure : procedures) {
            if (procedure.shouldProceed()) {
                System.out.println(procedure.status());
                procedure.proceed();
                break;
            }
        }
    }

    @Override
    public void onPaint(Graphics g) {
        long timeRan = System.currentTimeMillis() - startTime;
        int currentLvl = Skills.getActualLevel(Skills.SKILLS.MINING);
        int gainedLvl = currentLvl - startLvl;
        int gainedXP = Skills.getXP(Skills.SKILLS.MINING) - startXP;
        int xpToLevel = Skills.getXPToNextLevel(Skills.SKILLS.MINING);
        long xpPerHour = (gainedXP * 3600000 / timeRan);

        g.setFont(font);
        g.setColor(Color.WHITE);

        g.drawString("Runtime: " + Timing.msToString(timeRan), 550, 370);
        g.drawString("Current lvl: " + currentLvl + " (+" + gainedLvl + ")", 550, 390);
        g.drawString("XP Gained: " + gainedXP, 550, 410);
        g.drawString("XP TNL: " + xpToLevel, 550, 430);
        g.drawString("XP/H: " + xpPerHour, 550, 450);
    }
}
