package scripts.safeMiner.util;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;
import scripts.safeMiner.data.Finals;

import static scripts.safeMiner.data.Vars.oreToMine;

public class Calculations {
    private Finals finals = new Finals();

    public void waitUntil(boolean condition, int low, int high) {
        Timing.waitCondition(() -> condition, General.random(low, high));
    }
    public RSArea findMine(RSTile[] tiles, RSArea[] areas) {
        RSTile closestEligibleMine = null;
        for (RSTile mineTile : tiles) {
            if (closestEligibleMine == null) {
                closestEligibleMine = mineTile;
            }
            if (Player.getPosition().distanceTo(mineTile) < Player.getPosition().distanceTo(closestEligibleMine)) {
                closestEligibleMine = mineTile;
            }
        }
        return tileToArea(closestEligibleMine, areas);
    }
    private RSArea tileToArea(RSTile tile, RSArea[] rsArea) {
        for (RSArea mineArea : rsArea) {
            if (mineArea.contains(tile))
                return mineArea;
        }
        throw new RuntimeException("Error: No tile was passed into the conversion method (Calculations class)");
    }
    public RSArea[] oreToArea() {
        switch (oreToMine) {
            case "Tin ore":
                return finals.TIN_MINES;
            case "Copper ore":
                return finals.COPPER_MINES;
            case "Clay":
                return finals.CLAY_MINES;
            case "Iron ore":
                return finals.IRON_MINES;
            case "Coal":
                return finals.COAL_MINES;
            case "Silver ore":
                return finals.SILVER_MINES;
            case "Gold ore":
                return finals.GOLD_MINES;
            case "Mithril ore":
                return finals.MITHRIL_MINES;
            case "Adamantite ore":
                return finals.ADAMANTITE_MINES;
            case "Runite ore":
                return finals.RUNITE_MINES;
        }
        return null;
    }
    public RSTile[] oreToTile() {
        switch (oreToMine) {
            case "Tin ore":
                return finals.TIN_TILES;
            case "Copper ore":
                return finals.COPPER_TILES;
            case "Clay":
                return finals.CLAY_TILES;
            case "Iron ore":
                return finals.IRON_TILES;
            case "Coal":
                return finals.COAL_TILES;
            case "Silver ore":
                return finals.SILVER_TILES;
            case "Gold ore":
                return finals.GOLD_TILES;
            case "Mithril ore":
                return finals.MITHRIL_TILES;
            case "Adamantite ore":
                return finals.ADAMANTITE_TILES;
            case "Runite ore":
                return finals.RUNITE_TILES;
        }
        return null;
    }
    public int[] oreStringToIDs(String ore) {
        switch (ore) {
            case "Tin ore":
                return finals.ROCK_IDS[0];
            case "Copper ore":
                return finals.ROCK_IDS[1];
            case "Clay":
                return finals.ROCK_IDS[2];
            case "Iron ore":
                return finals.ROCK_IDS[3];
            case "Coal":
                return finals.ROCK_IDS[4];
            case "Silver ore":
                return finals.ROCK_IDS[5];
            case "Gold ore":
                return finals.ROCK_IDS[6];
            case "Mithril ore":
                return finals.ROCK_IDS[7];
            case "Adamantite ore":
                return finals.ROCK_IDS[8];
            case "Runite ore":
                return finals.ROCK_IDS[9];
        }
        return new int[0];
    }
}
