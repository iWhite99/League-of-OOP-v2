package input;

import heroes.Hero;
import sites.Site;

public final class GameInput {
  private int siteHeight;
  private int siteWidth;
  private Site[][] siteMap;
  private int heroesNumber;
  private Hero[] heroes;
  private int roundsNumber;

  public GameInput(final int siteHeight, final int siteWidth, final Site[][] siteMap,
                   final int heroesNumber, final Hero[] heroes, final int roundsNumber) {
    this.siteHeight = siteHeight;
    this.siteWidth = siteWidth;
    this.siteMap = siteMap;
    this.heroesNumber = heroesNumber;
    this.heroes = heroes;
    this.roundsNumber = roundsNumber;
  }

  public int getSiteHeight() {
    return siteHeight;
  }

  public void setSiteHeight(final int siteHeight) {
    this.siteHeight = siteHeight;
  }

  public int getSiteWidth() {
    return siteWidth;
  }

  public void setSiteWidth(final int siteWidth) {
    this.siteWidth = siteWidth;
  }

  public Site[][] getSiteMap() {
    return siteMap;
  }

  public void setSiteMap(final Site[][] siteMap) {
    this.siteMap = siteMap;
  }

  public int getHeroesNumber() {
    return heroesNumber;
  }

  public void setHeroesNumber(final int heroesNumber) {
    this.heroesNumber = heroesNumber;
  }

  public Hero[] getHeroes() {
    return heroes;
  }

  public void setHeroes(final Hero[] heroes) {
    this.heroes = heroes;
  }

  public int getRoundsNumber() {
    return roundsNumber;
  }

  public void setRoundsNumber(final int roundsNumber) {
    this.roundsNumber = roundsNumber;
  }
}
