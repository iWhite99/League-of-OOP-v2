package strategies;

import heroes.Hero;

public class KnightStrategy implements Strategy {
  @Override
  public final void apply(final Hero hero) {
    if (hero.getMaxHp() / 3 < hero.getCurrentHp()) {
      if (hero.getCurrentHp() < hero.getMaxHp() / 2) {
        hero.setDamageAmplifier(hero.getDamageAmplifier() * 1.5f);
        hero.setCurrentHp(hero.getCurrentHp() * 4 / 5);
      }
    } else if (hero.getCurrentHp() < hero.getMaxHp() / 3) {
      hero.setDamageAmplifier(hero.getDamageAmplifier() * 0.8f);
      hero.setCurrentHp(hero.getCurrentHp() * 5 / 4);
    }
  }
}
