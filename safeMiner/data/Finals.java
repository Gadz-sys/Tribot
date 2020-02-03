package scripts.safeMiner.data;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

public class Finals {
    public final int[] PICK_IDS =
    {
        1265,   //bronze pick
        1267,   //iron pick
        1269,   //steel pick
        12297,  //black pick
        1273,   //mithril pick
        1271,   //adamant pick
        1275,   //rune pick
        11920   //dragon pick
    };
    public final int[][] ROCK_IDS =
    {
        {11360, 11361},     //tin rock
        {10943, 11161},     //copper rock
        {11362, 11363},     //clay rock
        {11364, 11365},     //iron rock
        {11366, 11367},     //coal rock
        {11368, 11369},     //silver rock
        {11370, 11371},     //gold rock
        {11372, 11373},     //mithril rock
        {11374, 11375},     //adamantite rock
        {11376, 11377}      //runite rock
    };
    public final RSArea[] MINE_WALK_TOS =
    {
        new RSArea(new RSTile(3283, 3369, 0), new RSTile(3288, 3365, 0)), //varrock east
        new RSArea(new RSTile(3185, 3376, 0), new RSTile(3181, 3368, 0)), //varrock west
        new RSArea(new RSTile(3225, 3148, 0), new RSTile(3229, 3145, 0)), //lumby se
        new RSArea(new RSTile(3149, 3151, 0), new RSTile(3147, 3148, 0)), //lumby sw
        new RSArea(new RSTile(2974, 3243, 0), new RSTile(2982, 3236, 0)), //remington
        new RSArea(new RSTile(3078, 3417, 0), new RSTile(3083, 3421, 0)), //barb village
        new RSArea(new RSTile(3298, 3309, 0), new RSTile(3301, 3288, 0))  //al kharid
    };
    public final RSArea[] MINE_AREAS = {
        new RSArea(new RSTile(3279, 3371, 0), new RSTile(3291, 3360, 0)), //varrock east area
        new RSArea(new RSTile(3170, 3362, 0), new RSTile(3185, 3380, 0)), //varrock west area
        new RSArea(new RSTile(3221, 3141, 0), new RSTile(3232, 3149, 0)), //lumby se area
        new RSArea(new RSTile(3142, 3154, 0), new RSTile(3150, 3142, 0)), //lumby sw area
        new RSArea(new RSTile(2967, 3251, 0), new RSTile(2989, 3231, 0)), //remington area
        new RSArea(new RSTile(3077, 3424, 0), new RSTile(3085, 3415, 0)), //barb village area
        new RSArea(new RSTile(3307, 3319, 0), new RSTile(3292, 3279, 0))  //al kharid area
    };
    public final RSTile[] MINE_TILES = //tiles are used to calculate distance from different mines
    {
        new RSTile(3285, 3367, 0), //varrock east tile
        new RSTile(3183, 3373, 0), //varrock west tile
        new RSTile(3227, 3146, 0), //lumby se tile
        new RSTile(3148, 3149, 0), //lumby sw tile
        new RSTile(2979, 3239, 0), //remington tile
        new RSTile(3080, 3419, 0), //barb village tile
        new RSTile(3299, 3295, 0)  //al kharid tile
    };
    public final RSArea[] COPPER_MINES =
    {
        MINE_AREAS[0],   //varrock east
        //MINE_AREAS[1], //varrock west
        MINE_AREAS[2],   //lumby se
        //MINE_AREAS[3], //lumby sw
        MINE_AREAS[4],   //remington
        //MINE_AREAS[5], //barb village
        MINE_AREAS[6]    //al kharid
    };
    public final RSTile[] COPPER_TILES =
    {
        MINE_TILES[0],   //varrock east
        //MINE_TILES[1], //varrock west
        MINE_TILES[2],   //lumby se
        //MINE_TILES[3], //lumby sw
        MINE_TILES[4],   //remington
        //MINE_TILES[5], //barb village
        MINE_TILES[6]    //al kharid
    };
    public final RSArea[] TIN_MINES =
    {
        MINE_AREAS[0],   //varrock east
        MINE_AREAS[1],   //varrock west
        MINE_AREAS[2],   //lumby se
        //MINE_AREAS[3], //lumby sw
        MINE_AREAS[4],   //remington
        //MINE_AREAS[5], //barb village
        MINE_AREAS[6]    //al kharid
    };
    public final RSTile[] TIN_TILES =
    {
        MINE_TILES[0],   //varrock east
        MINE_TILES[1], //varrock west
        MINE_TILES[2],   //lumby se
        //MINE_TILES[3], //lumby sw
        MINE_TILES[4],   //remington
        //MINE_TILES[5], //barb village
        MINE_TILES[6]    //al kharid
    };
    public final RSArea[] CLAY_MINES =
    {
        //MINE_AREAS[0],   //varrock east
        MINE_AREAS[1], //varrock west
        //MINE_AREAS[2],   //lumby se
        //MINE_AREAS[3], //lumby sw
        MINE_AREAS[4],   //remington
        //MINE_AREAS[5], //barb village
        //MINE_AREAS[6]    //al kharid
    };
    public final RSTile[] CLAY_TILES =
    {
        //MINE_TILES[0],   //varrock east
        MINE_TILES[1], //varrock west
        //MINE_TILES[2],   //lumby se
        //MINE_TILES[3], //lumby sw
        MINE_TILES[4],   //remington
        //MINE_TILES[5], //barb village
        //MINE_TILES[6]    //al kharid
    };
    public final RSArea[] IRON_MINES =
    {
        MINE_AREAS[0],   //varrock east
        MINE_AREAS[1], //varrock west
        //MINE_AREAS[2],   //lumby se
        //MINE_AREAS[3], //lumby sw
        MINE_AREAS[4],   //remington
        //MINE_AREAS[5], //barb village
        MINE_AREAS[6]    //al kharid
    };
    public final RSTile[] IRON_TILES =
    {
        MINE_TILES[0],   //varrock east
        MINE_TILES[1], //varrock west
        //MINE_TILES[2],   //lumby se
        //MINE_TILES[3], //lumby sw
        MINE_TILES[4],   //remington
        //MINE_TILES[5], //barb village
        MINE_TILES[6]    //al kharid
    };
    public final RSArea[] COAL_MINES =
    {
        //MINE_AREAS[0],   //varrock east
        //MINE_AREAS[1], //varrock west
        //MINE_AREAS[2],   //lumby se
        MINE_AREAS[3], //lumby sw
        //MINE_AREAS[4],   //remington
        MINE_AREAS[5], //barb village
        MINE_AREAS[6]    //al kharid
    };
    public final RSTile[] COAL_TILES =
    {
        //MINE_TILES[0],   //varrock east
        //MINE_TILES[1], //varrock west
        //MINE_TILES[2],   //lumby se
        MINE_TILES[3], //lumby sw
        //MINE_TILES[4],   //remington
        MINE_TILES[5], //barb village
        MINE_TILES[6]    //al kharid
    };
    public final RSArea[] SILVER_MINES =
    {
        //MINE_AREAS[0],   //varrock east
        //MINE_AREAS[1], //varrock west
        //MINE_AREAS[2],   //lumby se
        //MINE_AREAS[3], //lumby sw
        //MINE_AREAS[4],   //remington
        //MINE_AREAS[5], //barb village
        MINE_AREAS[6]    //al kharid
    };
    public final RSTile[] SILVER_TILES =
    {
        //MINE_TILES[0],   //varrock east
        //MINE_TILES[1], //varrock west
        //MINE_TILES[2],   //lumby se
        //MINE_TILES[3], //lumby sw
        //MINE_TILES[4],   //remington
        //MINE_TILES[5], //barb village
        MINE_TILES[6]    //al kharid
    };
    public final RSArea[] GOLD_MINES =
    {
        //MINE_AREAS[0],   //varrock east
        //MINE_AREAS[1], //varrock west
        //MINE_AREAS[2],   //lumby se
        //MINE_AREAS[3], //lumby sw
        MINE_AREAS[4],   //remington
        //MINE_AREAS[5], //barb village
        MINE_AREAS[6]    //al kharid
    };
    public final RSTile[] GOLD_TILES =
    {
        //MINE_TILES[0],   //varrock east
        //MINE_TILES[1], //varrock west
        //MINE_TILES[2],   //lumby se
        //MINE_TILES[3], //lumby sw
        MINE_TILES[4],   //remington
        //MINE_TILES[5], //barb village
        MINE_TILES[6]    //al kharid
    };
    public final RSArea[] MITHRIL_MINES =
    {
        //MINE_AREAS[0],   //varrock east
        //MINE_AREAS[1], //varrock west
        //MINE_AREAS[2],   //lumby se
        MINE_AREAS[3], //lumby sw
        //MINE_AREAS[4],   //remington
        //MINE_AREAS[5], //barb village
        MINE_AREAS[6]    //al kharid
    };
    public final RSTile[] MITHRIL_TILES =
    {
        //MINE_TILES[0],   //varrock east
        //MINE_TILES[1], //varrock west
        //MINE_TILES[2],   //lumby se
        MINE_TILES[3], //lumby sw
        //MINE_TILES[4],   //remington
        //MINE_TILES[5], //barb village
        MINE_TILES[6]    //al kharid
    };
    public final RSArea[] ADAMANTITE_MINES =
    {
        //MINE_AREAS[0],   //varrock east
        //MINE_AREAS[1], //varrock west
        //MINE_AREAS[2],   //lumby se
        MINE_AREAS[3], //lumby sw
        //MINE_AREAS[4],   //remington
        //MINE_AREAS[5], //barb village
        MINE_AREAS[6]    //al kharid
    };
    public final RSTile[] ADAMANTITE_TILES =
    {
        //MINE_TILES[0],   //varrock east
        //MINE_TILES[1], //varrock west
        //MINE_TILES[2],   //lumby se
        MINE_TILES[3], //lumby sw
        //MINE_TILES[4],   //remington
        //MINE_TILES[5], //barb village
        MINE_TILES[6]    //al kharid
    };
    public final RSArea[] RUNITE_MINES =
    {
        //MINE_AREAS[0],   //varrock east
        //MINE_AREAS[1], //varrock west
        //MINE_AREAS[2],   //lumby se
        //MINE_AREAS[3], //lumby sw
        //MINE_AREAS[4],   //remington
        //MINE_AREAS[5], //barb village
        //MINE_AREAS[6]    //al kharid
    };
    public final RSTile[] RUNITE_TILES =
    {
        //MINE_TILES[0],   //varrock east
        //MINE_TILES[1], //varrock west
        //MINE_TILES[2],   //lumby se
        //MINE_TILES[3], //lumby sw
        //MINE_TILES[4],   //remington
        //MINE_TILES[5], //barb village
        //MINE_TILES[6]    //al kharid
    };
}