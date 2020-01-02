package input;

import heroes.Hero;
import moves.Move;
import sites.Site;

public final class GameInput {
  private int siteHeight;
  private int siteWidth;
  private Site[][] siteMap;
  private int heroesNumber;
  private Hero[] heroes;
  private int roundsNumber;

  GameInput(final int siteHeight, final int siteWidth, final Site[][] siteMap,
            final int heroesNumber, final Hero[] heroes, final int roundsNumber) {
    this.siteHeight = siteHeight;
    this.siteWidth = siteWidth;
    this.siteMap = siteMap;
    this.heroesNumber = heroesNumber;
    this.heroes = heroes;
    this.roundsNumber = roundsNumber;
  }

  public Hero[] getHeroes() {
    return heroes;
  }

  public void setHeroes(final Hero[] heroes) {
    this.heroes = heroes;
  }

  public void run() {
    for (int i = 0; i < this.roundsNumber; i++) {
      for (Hero currentHero : this.heroes) {
        Move currentMove = currentHero.getMoves()[i];
        currentMove.acceptMove(currentHero);  // Move the player
        // Reset the damage from the previous rounds
        currentHero.setDamage(0);
        currentHero.setDamageWithoutAmplifier(0);
        if (currentHero.getRoundsLeft() > 0) {
          if (currentHero.getCurrentHp() > 0) {
            // Apply overtime damage
            currentHero.setCurrentHp(currentHero.getCurrentHp() - currentHero.getOvertimeDamage());
            currentHero.setRoundsLeft(currentHero.getRoundsLeft() - 1);
          }
          if (currentHero.getCurrentHp() < 0) {
            // Set player as dead
            currentHero.setCurrentHp(0);
          }
        } else if (currentHero.getRoundsLeft() == 0) {
          // The player has the ability to move and to apply strategies
          currentHero.setIncapacity(0);
        }
        if (currentHero.getIncapacity() == 0) {  // && currentHero.getCurrentHp > 0
          // Apply the strategy if possible
          currentHero.applyStrategy();
        }
      }
      for (int j = 0; j < this.heroesNumber - 1; j++) {
        Hero firstHero = this.heroes[j];
        if (firstHero.getCurrentHp() == 0) {
          continue;
        }
        for (int k = j + 1; k < this.heroesNumber; k++) {
          Hero secondHero = this.heroes[k];
          if (secondHero.getCurrentHp() == 0) {
            continue;
          }
          if (firstHero.getPosition().equals(secondHero.getPosition())) {
            int currentRow = firstHero.getPosition().getCurrentRow();
            if (currentRow >= this.siteHeight) {
              continue;
            }
            int currentColumn = firstHero.getPosition().getCurrentColumn();
            if (currentColumn >= this.siteWidth) {
              continue;
            }
            Site currentSite = this.siteMap[currentRow][currentColumn];
            // Calculate and apply the damage for the heroes
            firstHero.fight(secondHero, currentSite, i);
            secondHero.fight(firstHero, currentSite, i);
            firstHero.setCurrentHp(firstHero.getCurrentHp() - firstHero.getDamage());
            secondHero.setCurrentHp(secondHero.getCurrentHp() - secondHero.getDamage());
            if (firstHero.getCurrentHp() < 0 && secondHero.getCurrentHp() < 0) {
              // The heroes killed each other
              firstHero.setCurrentHp(0);
              secondHero.setCurrentHp(0);
            } else {
              if (firstHero.getCurrentHp() < 0) {
                secondHero.updateHero(firstHero);  // Second hero killed the first hero
              }
              if (secondHero.getCurrentHp() < 0) {
                firstHero.updateHero(secondHero);  // First hero killed the second hero
              }
            }
          }
        }
      }
    }
  }
}
