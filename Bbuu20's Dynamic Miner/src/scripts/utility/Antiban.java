package scripts.utility;

import org.tribot.api.Clicking;
import org.tribot.api.DynamicClicking;
import org.tribot.api.input.Mouse;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api.util.abc.ABCUtil;
import org.tribot.api2007.ChooseOption;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSObject;

import static scripts.data.Constants.*;

public class Antiban {
    private ABCUtil abcUtil = new ABCUtil();

    // Instance manipulation (Thanks Einstein)
    private Antiban () {}
    private static Antiban antiban = new Antiban();
    public static Antiban get() {return antiban; }

    // Used in action conditions (Thanks again Einstein)
    boolean shouldHover = false;
    boolean shouldOpenMenu = false;
    boolean shouldMoveToAnticipated = false;

    // Timed Actions
    public void idling() {
        if (this.abcUtil.shouldCheckTabs())
            this.abcUtil.checkTabs();

        if (this.abcUtil.shouldCheckXP())
            this.abcUtil.checkXP();

        if (this.abcUtil.shouldExamineEntity())
            this.abcUtil.examineEntity();

        if (this.abcUtil.shouldMoveMouse())
            this.abcUtil.moveMouse();

        if (this.abcUtil.shouldPickupMouse())
            this.abcUtil.pickupMouse();

        if (this.abcUtil.shouldRightClick())
            this.abcUtil.rightClick();

        if (this.abcUtil.shouldRotateCamera())
            this.abcUtil.rotateCamera();

        if (this.abcUtil.shouldLeaveGame())
            this.abcUtil.leaveGame();
    }

    // Preferences
    public RSObject getNextTarget(Positionable[] targets) {
        return (RSObject) abcUtil.selectNextTarget(targets);
    }

    // Action
    public void setHoverAndMenuOpenBooleans() {
        this.shouldHover = abcUtil.shouldHover();
        this.shouldOpenMenu= abcUtil.shouldOpenMenu();
    }
    public void executeHoverOrMenuOpen(RSObject target) {
        if (Mouse.isInBounds() && this.shouldHover) {
            Clicking.hover(target);
            if (this.shouldOpenMenu)
                if (!ChooseOption.isOpen())
                    DynamicClicking.clickRSObject(target, 3);
        }
    }
    public void executeMoveToAnticipated() {
        if(this.shouldMoveToAnticipated) {
            RSObject[] depletedRock = Objects.findNearest(10, depletedRockIds);
            if(depletedRock.length <= 1) {
                return;
            }
            Walking.blindWalkTo(depletedRock[1].getPosition());
        }
    }
    private int generateReactionTime(int waitingTime) {
        boolean menuOpen = abcUtil.shouldOpenMenu() && abcUtil.shouldHover();
        boolean hovering = abcUtil.shouldHover();
        long menuOpenOption = menuOpen ? ABCUtil.OPTION_MENU_OPEN : 0;
        long hoverOption = hovering ? ABCUtil.OPTION_HOVERING : 0;

        return abcUtil.generateReactionTime(abcUtil.generateBitFlags(waitingTime, menuOpenOption, hoverOption));
    }
    public void generateAndSleep(int waitingTime) {
        try {
            int time = generateReactionTime(waitingTime);
            abcUtil.sleep(time / 8);
        } catch (InterruptedException e) {
        }
    }
}