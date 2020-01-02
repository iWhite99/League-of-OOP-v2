package strategies;

import heroes.Hero;

public class WizardStrategy implements Strategy {
  @Override
  public void apply(Hero hero) {
    if (hero.getMaxHp() / 4 < hero.getCurrentHp()) {
      if (hero.getCurrentHp() < hero.getMaxHp() / 2) {
        hero.setDamageAmplifier(hero.getDamageAmplifier() * 1.6f);
        hero.setCurrentHp(hero.getCurrentHp() * 9 / 10);
      }
    } else if (hero.getCurrentHp() < hero.getMaxHp() / 4) {
      hero.setDamageAmplifier(hero.getDamageAmplifier() * 0.8f);
      hero.setCurrentHp(hero.getCurrentHp() * 6 / 5);
    }
  }
}
