package heroes;

import utils.Constants;

public class HeroFactory {
  /**
   * @param heroType represents the type of the Hero that will be returned
   * @return a Hero of the wanted type or null if the type is not implemented
   */
  public Hero getHero(final String heroType, final int id) {
    switch (heroType) {
      case Constants.KNIGHT_STRING:
        return new Knight(id);
      case Constants.PYROMANCER_STRING:
        return new Pyromancer(id);
      case Constants.ROGUE_STRING:
        return new Rogue(id);
      case Constants.WIZARD_STRING:
        return new Wizard(id);
      default:
        return null;
    }
  }
}
