package utils;

public final class Constants {
  private Constants() {

  }

  public static final String KNIGHT_STRING = "K";
  public static final String PYROMANCER_STRING = "P";
  public static final String ROGUE_STRING = "R";
  public static final String WIZARD_STRING = "W";

  public static final char LAND_CHAR = 'L';
  public static final char VOLCANIC_CHAR = 'V';
  public static final char DESERT_CHAR = 'D';
  public static final char WOODS_CHAR = 'W';

  public static final char MOVE_UP_CHAR = 'U';
  public static final char MOVE_DOWN_CHAR = 'D';
  public static final char MOVE_LEFT_CHAR = 'L';
  public static final char MOVE_RIGHT_CHAR = 'R';
  public static final char NO_MOVE_CHAR = '_';

  public static final float FIREBLAST_ROGUE_AMPLIFIER = 0.8f;
  public static final float FIREBLAST_KNIGHT_AMPLIFIER = 1.2f;
  public static final float FIREBLAST_PYROMANCER_AMPLIFIER = 0.9f;
  public static final float FIREBLAST_WIZARD_AMPLIFIER = 1.05f;

  public static final float IGNITE_ROGUE_AMPLIFIER = 0.8f;
  public static final float IGNITE_KNIGHT_AMPLIFIER = 1.2f;
  public static final float IGNITE_PYROMANCER_AMPLIFIER = 0.9f;
  public static final float IGNITE_WIZARD_AMPLIFIER = 1.05f;

  public static final float EXECUTE_ROGUE_AMPLIFIER = 1.15f;
  public static final float EXECUTE_KNIGHT_AMPLIFIER = 1f;
  public static final float EXECUTE_PYROMANCER_AMPLIFIER = 1.1f;
  public static final float EXECUTE_WIZARD_AMPLIFIER = 0.8f;

  public static final float SLAM_ROGUE_AMPLIFIER = 0.8f;
  public static final float SLAM_KNIGHT_AMPLIFIER = 1.2f;
  public static final float SLAM_PYROMANCER_AMPLIFIER = 0.9f;
  public static final float SLAM_WIZARD_AMPLIFIER = 1.05f;

  public static final float DRAIN_ROGUE_AMPLIFIER = 0.8f;
  public static final float DRAIN_KNIGHT_AMPLIFIER = 1.2f;
  public static final float DRAIN_PYROMANCER_AMPLIFIER = 0.9f;
  public static final float DRAIN_WIZARD_AMPLIFIER = 1.05f;

  public static final float DEFLECT_ROGUE_AMPLIFIER = 1.2f;
  public static final float DEFLECT_KNIGHT_AMPLIFIER = 1.4f;
  public static final float DEFLECT_PYROMANCER_AMPLIFIER = 1.3f;
  public static final float DEFLECT_WIZARD_AMPLIFIER = 0f;

  public static final float BACKSTAB_ROGUE_AMPLIFIER = 1.2f;
  public static final float BACKSTAB_KNIGHT_AMPLIFIER = 0.9f;
  public static final float BACKSTAB_PYROMANCER_AMPLIFIER = 1.25f;
  public static final float BACKSTAB_WIZARD_AMPLIFIER = 1.25f;

  public static final float PARALYSIS_ROGUE_AMPLIFIER = 0.9f;
  public static final float PARALYSIS_KNIGHT_AMPLIFIER = 0.8f;
  public static final float PARALYSIS_PYROMANCER_AMPLIFIER = 1.2f;
  public static final float PARALYSIS_WIZARD_AMPLIFIER = 1.25f;

  public static final int FIREBLAST_DAMAGE = 350;
  public static final int FIREBLAST_DAMAGE_INCREASE = 50;
  public static final int IGNITE_DAMAGE = 150;
  public static final int IGNITE_DAMAGE_INCREASE = 20;
  public static final int IGNITE_DAMAGE_OVERTIME = 50;
  public static final int IGNITE_DAMAGE_OVERTIME_INCREASE = 30;
  public static final int IGNITE_ROUNDS = 2;
  public static final int EXECUTE_DAMAGE = 200;
  public static final int EXECUTE_DAMAGE_INCREASE = 30;
  public static final int SLAM_DAMAGE = 100;
  public static final int SLAM_DAMAGE_INCREASE = 40;
  public static final float DRAIN_PERCENT = 0.2f;
  public static final float DRAIN_PERCENT_INCREASE = 0.05f;
  public static final float DRAIN_AMPLIFIER = 0.3f;
  public static final float DEFLECT_PERCENT = 0.35f;
  public static final float DEFLECT_PERCENT_INCREASE = 0.02f;
  public static final float DEFLECT_MAX_PERCENT = 0.7f;
  public static final int BACKSTAB_DAMAGE = 200;
  public static final int BACKSTAB_DAMAGE_INCREASE = 20;
  public static final int PARALYSIS_DAMAGE = 40;
  public static final int PARALYSIS_DAMAGE_INCREASE = 10;
  public static final int PARALYSIS_ROUNDS = 3;
  public static final int PARALYSIS_ROUNDS_WOODS = 6;

  public static final float NO_AMPLIFIER = 1;
  public static final float VOLCANIC_SITE_PYROMANCER_AMPLIFIER = 1.25f;
  public static final float LAND_SITE_KNIGHT_AMPLIFIER = 1.15f;
  public static final float DESERT_SITE_WIZARD_AMPLIFIER = 1.1f;
  public static final float WOODS_SITE_ROGUE_AMPLIFIER = 1.15f;

  public static final int BASE_XP = 250;
  public static final int LEVEL_UP_XP_AMPLIFIER = 50;

  public static final int PYROMANCER_BASE_HP = 500;
  public static final int PYROMANCER_HP_INCREASE = 50;
  public static final int KNIGHT_BASE_HP = 900;
  public static final int KNIGHT_HP_INCREASE = 80;
  public static final int WIZARD_BASE_HP = 400;
  public static final int WIZARD_HP_INCREASE = 30;
  public static final int ROGUE_BASE_HP = 600;
  public static final int ROGUE_HP_INCREASE = 40;

  public static final float EXECUTE_LIMIT = 0.2f;
  public static final float EXECUTE_LIMIT_INCREASE = 0.01f;
  public static final float MAX_EXECUTE_LIMIT = 0.4f;

  public static final int CONSECUTIVE_ROUNDS = 3;
  public static final float CRITICAL_HIT = 1.5f;

  public static final int MAX_XP = 200;
  public static final int XP_AMPLIFIER = 40;

  public static final String DEAD = "dead";
  public static final String NEWLINE = "\n";

  public static final String DAMAGE_ANGEL_HELPED = "DamageAngel helped ";
  public static final String DARK_ANGEL_HIT = "DarkAngel hit ";
  public static final String DRACULA_HIT = "Dracula hit ";
  public static final String GOOD_BOY_HELPED = "GoodBoy helped ";
  public static final String LEVEL_UP_ANGEL_HELPED = "LevelUpAngel helped ";
  public static final String LIFE_GIVER_HELPED = "LifeGiver helped ";
  public static final String SMALL_ANGEL_HELPED = "SmallAngel helped ";
  public static final String SPAWNER_HELPED = "Spawner helped ";
  public static final String THE_DOOMER_HIT = "TheDoomer hit ";
  public static final String XP_ANGEL_HELPED = "XPAngel helped ";

  public static final String DAMAGE_ANGEL_SPAWNED = "Angel DamageAngel was spawned at ";
  public static final String DARK_ANGEL_SPAWNED = "Angel DarkAngel was spawned at ";
  public static final String DRACULA_SPAWNED = "Angel Dracula was spawned at ";
  public static final String GOOD_BOY_SPAWNED = "Angel GoodBoy was spawned at ";
  public static final String LEVEL_UP_ANGEL_SPAWNED = "Angel LevelUpAngel was spawned at ";
  public static final String LIFE_GIVER_SPAWNED = "Angel LifeGiver was spawned at ";
  public static final String SMALL_ANGEL_SPAWNED = "Angel SmallAngel was spawned at ";
  public static final String SPAWNER_SPAWNED = "Angel Spawner was spawned at ";
  public static final String THE_DOOMER_SPAWNED = "Angel TheDoomer was spawned at ";
  public static final String XP_ANGEL_SPAWNED = "Angel XPAngel was spawned at ";

  public static final String PLAYER = "Player ";
  public static final String RESPAWNED = " was brought to life by an angel";
  public static final String WAS_KILLED = " was killed by ";
  public static final String REACHED = " reached level ";
}
