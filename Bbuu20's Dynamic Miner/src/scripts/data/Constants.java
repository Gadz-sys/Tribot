package scripts.data;

import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

public interface Constants {
    RSArea varrockEastMine = new RSArea(new RSTile(3281, 3371, 0), new RSTile(3290, 3360, 0));
    RSArea varrockEastBank = new RSArea(new RSTile(3257, 3419, 0), new RSTile(3250, 3421, 0));

    int[] COPPER_ROCK = {10943, 11161};
    int[] TIN_ROCK = {11360, 11361};

    int[] allRockIds = {COPPER_ROCK[0], COPPER_ROCK[1], TIN_ROCK[0], TIN_ROCK[1]};

    int[] pickIds = {1265/*bronze*/};
    int[] rockIds = allRockIds;
    int[] depletedRockIds = {11390, 11391};
}