package strategies;

import heroes.Hero;
import utils.Constants;

public final class WizardStrategy implements Strategy {
  @Override
  public void apply(final Hero hero) {
    if (hero.getCurrentHp() < hero.getMaxHp() / Constants.FOUR) {
      hero.setDamageAmplifier(hero.getDamageAmplifier() - Constants.WIZARD_STRATEGY_LOW);
      hero.setCurrentHp(hero.getCurrentHp() * Constants.SIX / Constants.FIVE);
    } else if (hero.getMaxHp() / Constants.FOUR < hero.getCurrentHp()) {
      if (hero.getCurrentHp() < hero.getMaxHp() / Constants.TWO) {
        hero.setDamageAmplifier(hero.getDamageAmplifier() + Constants.WIZARD_STRATEGY_MEDIUM);
        hero.setCurrentHp(hero.getCurrentHp() * Constants.NINE / Constants.TEN);
      }
    }
  }
}
