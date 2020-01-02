package strategies;

import heroes.Hero;

public class RogueStrategy implements Strategy {
  @Override
  public void apply(Hero hero) {
    if (hero.getMaxHp() / 7 < hero.getCurrentHp()) {
      if (hero.getCurrentHp() < hero.getMaxHp() / 5) {
        hero.setDamageAmplifier(hero.getDamageAmplifier() * 1.4f);
        hero.setCurrentHp(hero.getCurrentHp() * 6 / 7);
      }
    } else if (hero.getCurrentHp() < hero.getMaxHp() / 7) {
      hero.setDamageAmplifier(hero.getDamageAmplifier() * 0.9f);
      hero.setCurrentHp(hero.getCurrentHp() * 3 / 2);
    }
  }
}
