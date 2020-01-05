package strategies;

import heroes.Hero;
import utils.Constants;

public final class KnightStrategy implements Strategy {
  @Override
  public void apply(final Hero hero) {
    if (hero.getCurrentHp() < hero.getMaxHp() / Constants.THREE) {
      hero.setDamageAmplifier(hero.getDamageAmplifier() - Constants.KNIGHT_STRATEGY_LOW);
      hero.setCurrentHp(hero.getCurrentHp() * Constants.FIVE / Constants.FOUR);
    } else if (hero.getMaxHp() / Constants.THREE < hero.getCurrentHp()) {
      if (hero.getCurrentHp() < hero.getMaxHp() / Constants.TWO) {
        hero.setDamageAmplifier(hero.getDamageAmplifier() + Constants.KNIGHT_STRATEGY_MEDIUM);
        hero.setCurrentHp(hero.getCurrentHp() * Constants.FOUR / Constants.FIVE);
      }
    }
  }
}
