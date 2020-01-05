package input;

import angels.Angel;
import fileio.FileSystem;
import heroes.Hero;
import heroes.HeroComparator;
import heroes.HeroIdComparator;
import magician.Magician;
import moves.Move;
import sites.Site;
import utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class GameInput {
  private int siteHeight;
  private int siteWidth;
  private Site[][] siteMap;
  private int heroesNumber;
  private Hero[] heroes;
  private int roundsNumber;
  private ArrayList<ArrayList<Angel>> angels;
  private Magician magician;
  private FileSystem fileSystem;

  GameInput(final Site[][] siteMap, final int heroesNumber, final Hero[] heroes,
            final int roundsNumber, final ArrayList<ArrayList<Angel>> angels,
            final Magician magician, final FileSystem fileSystem) {
    this.siteMap = siteMap;
    this.siteHeight = siteMap.length;
    this.siteWidth = siteMap[0].length;
    this.heroesNumber = heroesNumber;
    this.heroes = heroes;
    this.roundsNumber = roundsNumber;
    this.angels = angels;
    this.magician = magician;
    this.fileSystem = fileSystem;
  }

  public Hero[] getHeroes() {
    return heroes;
  }

  public void setHeroes(final Hero[] heroes) {
    this.heroes = heroes;
  }

  public void run() {
    for (int i = 0; i < this.roundsNumber; i++) {
      Arrays.sort(heroes, new HeroComparator());
//      System.out.println("~~ Round " + (i + 1) + " ~~");
      try {
        fileSystem.writeWord("~~ Round " + (i + 1) + " ~~\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
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
//          System.out.println(currentHero.heroTypeAndIndex() + currentHero.getIncapacity());
          // Apply the strategy if possible
          currentHero.applyStrategy();
//          System.out.println(currentHero.getDamageAmplifier());
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
              secondHero.wasKilled(firstHero, this.magician);
              firstHero.wasKilled(secondHero, this.magician);
              secondHero.setCurrentHp(0);
              firstHero.setCurrentHp(0);
            } else {
              if (firstHero.getCurrentHp() < 0) {
                firstHero.wasKilled(secondHero, this.magician);  // First hero was killed
                secondHero.updateHero(firstHero, this.magician);
              }
              if (secondHero.getCurrentHp() < 0) {
                secondHero.wasKilled(firstHero, this.magician);  // Second hero was killed
                firstHero.updateHero(secondHero, this.magician);
              }
            }
          }
        }
      }
      Arrays.sort(heroes, new HeroIdComparator());
      System.out.println("dupa lupte");
      for (Hero currentHero : this.heroes) {
        System.out.println(currentHero.toString());
      }
      System.out.println();
      for (Angel currentAngel : this.angels.get(i)) {
        currentAngel.spawn();
        for (Hero currentHero : this.heroes) {
          if (currentHero.getPosition().equals(currentAngel.getPosition())) {
            currentHero.acceptDamageAmplifier(currentAngel);
            currentHero.setCurrentHp(Math.min(currentHero.getMaxHp(), currentHero.getCurrentHp()));
          }
        }
      }
//      System.out.println("ROUND " + i);
//      for (Hero currentHero : this.heroes) {
////        currentHero.applyStrategy();
//        System.out.println(currentHero.toString());
//      }
//      System.out.println();
      System.out.println("dupa ingeri");
      for (Hero currentHero : this.heroes) {
        System.out.println(currentHero.toString());
      }
      System.out.println();
      try {
        fileSystem.writeWord(Constants.NEWLINE);
      } catch (IOException e) {
        e.printStackTrace();
      }
//      System.out.println();
    }
  }
}
