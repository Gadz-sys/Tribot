package scripts;

import org.tribot.api.General;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

public class Tasks {

    CreateCharacter createCharacter = new CreateCharacter();
    TalkToNPC talkToNPC = new TalkToNPC();
    ClickObject clickObject = new ClickObject();
    ClickInventory clickInventory = new ClickInventory();
    NullChecker nullChecker = new NullChecker();

    public void getTask() {
        switch (Game.getSetting(281)) {
            case 1:
                System.out.print("1");
                createCharacter.makeCharacter();
                break;
            case 2:
                System.out.print("2");
                talkToNPC.talkToNpc("Gielinor Guide");
                break;
            case 3:
                System.out.print("3");
                talkToNPC.talkToNpc("Gielinor Guide");
                GameTab.TABS.OPTIONS.open();
                break;
            case 7:
                System.out.print("7");
                talkToNPC.talkToNpc("Gielinor Guide");
                break;
            case 10:
                System.out.print("10");
                Walking.walkTo(new RSTile(3097, 3107, 0));//walk to the door
                clickObject.clickObject("Door");
                break;
            case 20:
                System.out.print("20");
                Walking.walkTo(new RSTile(3102, 3095));//walk to the survival expert
                talkToNPC.talkToNpc("Survival Expert");
                break;
            case 30:
                System.out.print("30");
                if (Inventory.getCount("Small fishing net") == 0)
                    talkToNPC.talkToNpc("Survival Expert");
                else if (!GameTab.TABS.INVENTORY.isOpen())
                    GameTab.TABS.INVENTORY.open();
                break;
            case 40:
                System.out.print("40");
                if (Interfaces.get(263, 1, 0) != null && !Interfaces.get(263, 1, 0).isHidden())
                    if (!Interfaces.get(263, 1, 0).getText().contains("Your character is now attempting")) {
                        Walking.walkTo(new RSTile(3100, 3092));//walk to the fishing spots
                        talkToNPC.talkToNpc("Fishing spot");//it looks like this is wrong, but the fishing spot is indeed an npc
                    }
                break;
            case 50:
                System.out.print("50");
                if (!GameTab.TABS.STATS.isOpen())
                    GameTab.TABS.STATS.open();
                break;
            case 60:
                System.out.print("60");
                talkToNPC.talkToNpc("Survival Expert");
                break;
            case 70:
                System.out.print("70");
                Walking.walkTo(new RSTile(3104, 3094));//walk to tree
                clickObject.clickObject("Tree");
                break;
            case 80:
                System.out.print("80");
                if (Inventory.getCount("Logs") > 0) {
                    clickInventory.clickInventory("Logs");
                    clickInventory.clickInventory("Tinderbox");
                }
                else
                    clickObject.clickObject("Tree");
                break;
            case 90:
                System.out.print("90");
                if (Inventory.getCount("Raw shrimps") > 0) {
                    clickInventory.clickInventory("Raw shrimps");
                    clickObject.clickObject("Fire");
                }
                else {
                    talkToNPC.talkToNpc("Fishing spot");
                }
                break;
            case 120:
                System.out.print("120");
                Walking.walkTo(new RSTile(3090, 3092));
                clickObject.clickObject("Gate");
                break;
            case 130:
                System.out.print("130");
                Walking.walkTo(new RSTile(3079, 3084));
                clickObject.clickObject("Door");
                break;
            case 140:
                System.out.print("140");
                talkToNPC.talkToNpc("Master Chef");
                break;
            case 150:
                System.out.print("150");
                clickInventory.clickInventory("Pot of flour");
                clickInventory.clickInventory("Bucket of water");
                break;
            case 160:
                System.out.print("160");
                Walking.walkTo(new RSTile(3076, 3082));
                clickObject.clickObject("Range");
                break;
            case 170:
                System.out.print("170");
                Walking.walkTo(new RSTile(3073, 3090));
                clickObject.clickObject("Door");
                break;
            case 200:
                System.out.print("200");
                Walking.blindWalkTo(new RSTile(3086, 3126));
                clickObject.clickObject("Door");
                break;
            case 220:
                System.out.print("220");
                talkToNPC.talkToNpc("Quest Guide");
                break;
            case 230:
                System.out.print("230");
                if (Interfaces.get(263, 1, 0) != null && !Interfaces.get(263, 1, 0).isHidden())
                    if (Interfaces.get(263, 1, 0).getText().contains("Click on the flashing icon to the left")) {
                        if (!GameTab.TABS.QUESTS.isOpen())
                            GameTab.TABS.QUESTS.open();
                    }
                break;
            case 240:
                System.out.print("240");
                talkToNPC.talkToNpc("Quest Guide");
                break;
            case 250:
                System.out.print("250");
                Walking.walkTo(new RSTile(3088, 3120));
                clickObject.clickObject("Ladder");
                break;
            case 260:
                System.out.print("260");
                if (NPCChat.getMessage() == null)
                    Walking.blindWalkTo(new RSTile(3080, 9502));
                talkToNPC.talkToNpc("Mining Instructor");
                break;
            case 270:
                System.out.print("270");
                Walking.walkTo(new RSTile(3078, 9503));
                break;
            case 300:
                System.out.print("300");
                Walking.walkTo(new RSTile(3078, 9503));
                clickObject.clickObject("Rocks");
                break;
            case 310:
                System.out.print("310");
                Walking.walkTo(new RSTile(3082, 9501));
                General.sleep(General.random(1200, 2000));
                clickObject.clickObject("Rocks");
                break;
            case 320:
                System.out.print("320");
                Walking.walkTo(new RSTile(3079, 9497));
                clickObject.clickObject("Furnace");
                break;
            case 330:
                System.out.print("330");
                if (NPCChat.getMessage() == null)
                    Walking.walkTo(new RSTile(3080, 9502));
                talkToNPC.talkToNpc("Mining Instructor");
                break;
            case 340:
                System.out.print("340");
                Walking.walkTo(new RSTile(3082, 9499));
                clickObject.clickObject("Anvil");
                break;
            case 350:
                System.out.print("350");
                if (Interfaces.get(312, 9) != null && !Interfaces.get(312, 9).isHidden()) {
                    Interfaces.get(312, 9).click();
                    General.sleep(General.random(1200, 2000));
                }
                else if (Interfaces.get(312, 9) == null || Interfaces.get(312, 9).isHidden()) {
                    Walking.walkTo(new RSTile(3082, 9499));
                    clickObject.clickObject("Anvil");
                }
                break;
            case 360:
                System.out.print("360");
                Walking.walkTo(new RSTile(3094, 9503));
                clickObject.clickObject("Gate");
                break;
            case 370:
                System.out.print("370");

                if (NPCChat.getMessage() == null)
                    Walking.walkTo(new RSTile(3105, 9506));
                talkToNPC.talkToNpc("Combat Instructor");
                break;
            case 390:
                System.out.print("390");
                if (NPCChat.getMessage() != null)
                    talkToNPC.talkToNpc("Combat Instructor");
                else {
                    if (!GameTab.TABS.EQUIPMENT.isOpen()) {
                        GameTab.TABS.EQUIPMENT.open();
                    }
                }
                break;
            case 400:
                System.out.print("400");
                Interfaces.get(387, 17).click();
                break;
            case 405:
                System.out.print("405");
                clickInventory.clickInventory("Bronze dagger");
                break;
            case 410:
                System.out.print("410");
                if (Interfaces.get(84, 4) != null && !Interfaces.get(84, 4).isHidden())
                    Interfaces.get(84, 4).click();
                else {
                    talkToNPC.talkToNpc("Combat Instructor");
                }
                break;
            case 420:
                System.out.print("420");
                if (!GameTab.TABS.INVENTORY.isOpen())
                    GameTab.TABS.INVENTORY.open();
                else {
                    clickInventory.clickInventory("Bronze sword");
                    clickInventory.clickInventory("Wooden shield");
                }
                break;
            case 430:
                System.out.print("430");
                if (!GameTab.TABS.COMBAT.isOpen())
                    GameTab.TABS.COMBAT.open();
                break;
            case 440:
                System.out.print("440");
                Walking.walkTo(new RSTile(3111, 9518));
                clickObject.clickObject("Gate");
                break;
            case 450:
                System.out.print("450");
                talkToNPC.talkToNpc("Giant rat");
                break;
            case 470:
                System.out.print("470");
                if ((new RSArea(new RSTile(3110, 9525, 0), new RSTile(3095, 9513, 0))).contains(Player.getPosition()) && NPCChat.getMessage() == null) {
                    Walking.walkTo(new RSTile(3110, 9518));
                    clickObject.clickObject("Gate");
                }
                else {
                    if (NPCChat.getMessage() == null)
                        Walking.walkTo(new RSTile(3104, 9504));
                    talkToNPC.talkToNpc("Combat Instructor");
                }
                break;
            case 480:
                System.out.print("480");
                if (!GameTab.TABS.INVENTORY.isOpen())
                    GameTab.TABS.INVENTORY.open();
                else {
                    clickInventory.clickInventory("Shortbow");
                    clickInventory.clickInventory("Bronze arrow");
                    Walking.walkTo(new RSTile(3111, 9516));
                    General.sleep(General.random(1200, 1500));
                    talkToNPC.talkToNpc("Giant rat");
                }
                break;
            case 490:
                System.out.print("490");
                break;
            case 500:
                System.out.print("500");
                Walking.blindWalkTo(new RSTile(3111, 9525));
                clickObject.clickObject("Ladder");
                break;
            case 510:
                System.out.print("510");
                Walking.blindWalkTo(new RSTile(3120, 3123));
                clickObject.clickObject("Bank booth");
                break;
            case 520:
                System.out.print("520");
                if (Interfaces.get(12, 3, 11) != null && !Interfaces.get(12, 3, 11).isHidden())
                    Interfaces.get(12, 3, 11).click();
                else if (Interfaces.get(263, 1, 0) != null && !Interfaces.get(263, 1, 0).isHidden()){
                    Walking.blindWalkTo(new RSTile(3120, 3121));
                    clickObject.clickObject("Poll booth");
                }
                else {
                    NPCChat.clickContinue(true);
                }
                break;
            case 525:
                System.out.print("525");
                Walking.walkTo(new RSTile(3124, 3124));
                General.sleep(General.random(2000, 2200));
                clickObject.clickObject("Door");
                break;
            case 530:
                System.out.print("530");
                talkToNPC.talkToNpc("Account Guide");
                break;
            case 531:
                System.out.print("531");
                if (NPCChat.getMessage() != null)
                    talkToNPC.talkToNpc("Account Guide");
                GameTab.TABS.ACCOUNT.open();
                break;
            case 532:
                System.out.print("532");
                talkToNPC.talkToNpc("Account Guide");
                break;
            case 540:
                System.out.print("540");
                Walking.walkTo(new RSTile(3129, 3124));
                General.sleep(General.random(1500, 1800));
                clickObject.clickObject("Door");
                break;
            case 550:
                System.out.print("550");
                if (nullChecker.npcCheck("Brother Brace") == null)
                    Walking.blindWalkTo(new RSTile(3123, 3104));
                if (nullChecker.npcCheck("Brother Brace") != null)
                    talkToNPC.talkToNpc("Brother Brace");
                General.sleep(General.random(500, 800));
                break;
            case 560:
                System.out.print("560");
                if (NPCChat.getMessage() != null)
                    talkToNPC.talkToNpc("Brother Brace");
                else if (!GameTab.TABS.PRAYERS.isOpen())
                    GameTab.TABS.PRAYERS.open();
            case 570:
                System.out.print("570");
                talkToNPC.talkToNpc("Brother Brace");
                break;
            case 580:
                System.out.print("580");
                if (NPCChat.getMessage() != null)
                    talkToNPC.talkToNpc("Brother Brace");
                else if (!GameTab.TABS.FRIENDS.isOpen())
                    GameTab.TABS.FRIENDS.open();
                break;
            case 600:
                System.out.print("600");
                talkToNPC.talkToNpc("Brother Brace");
                break;
            case 610:
                System.out.print("610");
                Walking.walkTo(new RSTile(3122, 3103));
                clickObject.clickObject("Door");
                break;
            case 620:
                System.out.print("620");
                if (NPCChat.getMessage() == null)
                    Walking.blindWalkTo(new RSTile(3142, 3088));
                talkToNPC.talkToNpc("Magic Instructor");
                break;
            case 630:
                System.out.print("630");
                GameTab.TABS.MAGIC.open();
                break;
            case 640:
                System.out.print("640");
                talkToNPC.talkToNpc("Magic Instructor");
                break;
            case 650:
                System.out.print("650");
                Walking.walkTo(new RSTile(3140, 3091));
                Magic.selectSpell("Wind strike");
                talkToNPC.talkToNpc("Chicken");
                break;
            case 670:
                System.out.print("670");
                if (NPCChat.getMessage() == null && (Interfaces.get(219, 1) == null || Interfaces.get(219, 1).isHidden()))
                    Walking.walkTo(new RSTile(3142, 3088));
                talkToNPC.talkToNpc("Magic Instructor");
                break;
        }
        if (Interfaces.get(193, 0, 2) != null && !Interfaces.get(193, 0, 2).isHidden())
            Interfaces.get(193, 0, 2).click();
        if (Interfaces.get(217, 3) != null && !Interfaces.get(217, 3).isHidden())
            Interfaces.get(217, 3).click();
    }
}