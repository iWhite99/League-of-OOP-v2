package strategies;

import heroes.Hero;

public class PyromancerStrategy implements Strategy {
  @Override
  public void apply(Hero hero) {
    if (hero.getMaxHp() / 4 < hero.getCurrentHp()) {
      if (hero.getCurrentHp() < hero.getMaxHp() / 3) {
        hero.setDamageAmplifier(hero.getDamageAmplifier() * 1.7f);
        hero.setCurrentHp(hero.getCurrentHp() * 3 / 4);
      }
    } else if (hero.getCurrentHp() < hero.getMaxHp() / 4) {
      hero.setDamageAmplifier(hero.getDamageAmplifier() * 0.7f);
      hero.setCurrentHp(hero.getCurrentHp() * 4 / 3);
    }
  }
}
