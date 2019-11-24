package heroes;

import utils.Constants;

public class HeroFactory {
  /**
   * @param heroType represents the type of the Hero that will be returned
   * @return a Hero of the wanted type or null if the type is not implemented
   */
  public Hero getHero(final String heroType) {
    switch (heroType) {
      case Constants.KNIGHT_STRING:
        return new Knight();
      case Constants.PYROMANCER_STRING:
        return new Pyromancer();
      case Constants.ROGUE_STRING:
        return new Rogue();
      case Constants.WIZARD_STRING:
        return new Wizard();
      default:
        return null;
    }
  }
}
