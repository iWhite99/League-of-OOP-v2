package strategies;

import heroes.Hero;
import utils.Constants;

public final class RogueStrategy implements Strategy {
  @Override
  public void apply(final Hero hero) {
    if (hero.getCurrentHp() < hero.getMaxHp() / Constants.SEVEN) {
      hero.setDamageAmplifier(hero.getDamageAmplifier() - Constants.ROGUE_STRATEGY_LOW);
      hero.setCurrentHp(hero.getCurrentHp() * Constants.THREE / Constants.TWO);
    } else if (hero.getMaxHp() / Constants.SEVEN < hero.getCurrentHp()) {
      if (hero.getCurrentHp() < hero.getMaxHp() / Constants.FIVE) {
        hero.setDamageAmplifier(hero.getDamageAmplifier() + Constants.ROGUE_STRATEGY_MEDIUM);
        hero.setCurrentHp(hero.getCurrentHp() * Constants.SIX / Constants.SEVEN);
      }
    }
  }
}
