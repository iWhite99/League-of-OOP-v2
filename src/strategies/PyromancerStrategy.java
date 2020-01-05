package strategies;

import heroes.Hero;
import utils.Constants;

public final class PyromancerStrategy implements Strategy {
  @Override
  public void apply(final Hero hero) {
    if (hero.getCurrentHp() < hero.getMaxHp() / Constants.FOUR) {
      hero.setDamageAmplifier(hero.getDamageAmplifier() - Constants.PYROMANCER_STRATEGY_LOW);
      hero.setCurrentHp(hero.getCurrentHp() * Constants.FOUR / Constants.THREE);
    } else if (hero.getMaxHp() / Constants.FOUR < hero.getCurrentHp()) {
      if (hero.getCurrentHp() < hero.getMaxHp() / Constants.THREE) {
        hero.setDamageAmplifier(hero.getDamageAmplifier() + Constants.PYROMANCER_STRATEGY_MEDIUM);
        hero.setCurrentHp(hero.getCurrentHp() * Constants.THREE / Constants.FOUR);
      }
    }
  }
}
