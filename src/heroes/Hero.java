package heroes;

import moves.Move;
import utils.Position;

/**
 * TO BE DONE: IMPLEMENT DOUBLE DISPATCH FOR AMPLIFIERS AND MOVEMENT.
 */
public abstract class Hero {
  private int xp = 0;  // Initialize xp with 0
  private int level = 0;  // Initialize level with 0
  private int currentHp = 0;  // Initialize hp with 0, set as needed for each type of hero
  private int maxHp = 0;  // Initialize hp with 0, set as needed for each type of hero
  private float amplifier = 1;  // Initialize with no damage amplifier
  private int damage = 0;  // Initialize damage with 0, set when attacked
  private int overtimeDamage = 0;  // Initialize overtime damage with 0, set when attacked
  private int roundsLeft = 0;  // Initialize rounds left for overtime damage, set when attacked
  private Position position;  // Store the current position on the map
  private Move[] moves;  // Store the moves for each hero

  public final int getXp() {
    return xp;
  }

  public final void setXp(final int xp) {
    this.xp = xp;
  }

  public final int getLevel() {
    return level;
  }

  public final void setLevel(final int level) {
    this.level = level;
  }

  public final int getCurrentHp() {
    return currentHp;
  }

  public final void setCurrentHp(final int currentHp) {
    this.currentHp = currentHp;
  }

  public final int getMaxHp() {
    return maxHp;
  }

  public final void setMaxHp(final int maxHp) {
    this.maxHp = maxHp;
  }

  public final float getAmplifier() {
    return amplifier;
  }

  public final void setAmplifier(final float amplifier) {
    this.amplifier = amplifier;
  }

  public final int getDamage() {
    return damage;
  }

  public final void setDamage(final int damage) {
    this.damage = damage;
  }

  public final int getOvertimeDamage() {
    return overtimeDamage;
  }

  public final void setOvertimeDamage(final int overtimeDamage) {
    this.overtimeDamage = overtimeDamage;
  }

  public final int getRoundsLeft() {
    return roundsLeft;
  }

  public final void setRoundsLeft(final int roundsLeft) {
    this.roundsLeft = roundsLeft;
  }

  public final Position getPosition() {
    return position;
  }

  public final void setPosition(final Position position) {
    this.position = position;
  }

  public final Move[] getMoves() {
    return moves;
  }

  public final void setMoves(final Move[] moves) {
    this.moves = moves;
  }
}
