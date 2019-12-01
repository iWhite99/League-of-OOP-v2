package abilities;

import heroes.Hero;
import sites.Site;

public abstract class Ability {
  private int initialDamage = 0;
  private int increaseDamage = 0;
  private int currentDamage = 0;
  private int initialOvertimeDamage = 0;
  private int increaseOvertimeDamage = 0;
  private int currentOvertimeDamage = 0;
  private int rounds = 0;
  // Initialize all with 0, set each as needed for each type of ability

  final int getInitialDamage() {
    return initialDamage;
  }

  final void setInitialDamage(final int initialDamage) {
    this.initialDamage = initialDamage;
  }

  final void setIncreaseDamage(final int increaseDamage) {
    this.increaseDamage = increaseDamage;
  }

  final int getCurrentDamage() {
    return currentDamage;
  }

  final void setCurrentDamage(final int currentDamage) {
    this.currentDamage = currentDamage;
  }

  final int getInitialOvertimeDamage() {
    return initialOvertimeDamage;
  }

  final void setInitialOvertimeDamage(final int initialOvertimeDamage) {
    this.initialOvertimeDamage = initialOvertimeDamage;
  }

  final void setIncreaseOvertimeDamage(final int increaseOvertimeDamage) {
    this.increaseOvertimeDamage = increaseOvertimeDamage;
  }

  final int getCurrentOvertimeDamage() {
    return currentOvertimeDamage;
  }

  final void setCurrentOvertimeDamage(final int currentOvertimeDamage) {
    this.currentOvertimeDamage = currentOvertimeDamage;
  }

  final int getRounds() {
    return rounds;
  }

  final void setRounds(final int rounds) {
    this.rounds = rounds;
  }

  /**
   * Updates the stats for the ability.
   * Modified by any ability that has different types of damage
   * @param hero represents the hero whose abilities will be improved - based by level
   */
  public void updateAbility(final Hero hero) {
    this.currentDamage = this.initialDamage + hero.getLevel() * this.increaseDamage;
    this.currentOvertimeDamage = this.initialOvertimeDamage
            + hero.getLevel() * this.increaseOvertimeDamage;
    this.updateOvertimeAbility(hero);
  }

  private void updateOvertimeAbility(final Hero hero) {
    this.currentOvertimeDamage = this.initialOvertimeDamage
            + hero.getLevel() * this.increaseOvertimeDamage;
  }

  // Visitable Race Amplifiers
  public abstract void acceptRaceAmplifier(Hero hero);

  // Applied damage for each type of ability
  public abstract void applyDamage(Hero hero, float raceAmplifier, float siteAmplifier,
                                   int round, int damageTaken, Site site);
}
