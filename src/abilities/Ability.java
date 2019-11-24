package abilities;

import heroes.Hero;

public abstract class Ability {
  private int initialDamage = 0;
  private int increaseDamage = 0;
  private int currentDamage = 0;
  private int initialOvertimeDamage = 0;
  private int increaseOvertimeDamage = 0;
  private int currentOvertimeDamage = 0;
  private int rounds = 0;

  public final int getInitialDamage() {
    return initialDamage;
  }

  public final void setInitialDamage(final int initialDamage) {
    this.initialDamage = initialDamage;
  }

  public final int getIncreaseDamage() {
    return increaseDamage;
  }

  public final void setIncreaseDamage(final int increaseDamage) {
    this.increaseDamage = increaseDamage;
  }

  public final int getCurrentDamage() {
    return currentDamage;
  }

  public final void setCurrentDamage(final int currentDamage) {
    this.currentDamage = currentDamage;
  }

  public final int getInitialOvertimeDamage() {
    return initialOvertimeDamage;
  }

  public final void setInitialOvertimeDamage(final int initialOvertimeDamage) {
    this.initialOvertimeDamage = initialOvertimeDamage;
  }

  public final int getIncreaseOvertimeDamage() {
    return increaseOvertimeDamage;
  }

  public final void setIncreaseOvertimeDamage(final int increaseOvertimeDamage) {
    this.increaseOvertimeDamage = increaseOvertimeDamage;
  }

  public final int getCurrentOvertimeDamage() {
    return currentOvertimeDamage;
  }

  public final void setCurrentOvertimeDamage(final int currentOvertimeDamage) {
    this.currentOvertimeDamage = currentOvertimeDamage;
  }

  public final int getRounds() {
    return rounds;
  }

  public final void setRounds(final int rounds) {
    this.rounds = rounds;
  }

  public final void updateAbility(final Hero hero) {
    this.currentDamage = this.initialDamage + hero.getLevel() * this.increaseDamage;
  }

  public final void updateOvertimeAbility(final Hero hero) {
    this.currentOvertimeDamage = this.initialOvertimeDamage
            + hero.getLevel() * this.increaseOvertimeDamage;
  }

  public abstract void acceptRaceAmplifier(Hero hero);
}
