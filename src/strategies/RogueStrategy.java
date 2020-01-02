package strategies;

import heroes.Hero;

public class RogueStrategy implements Strategy {
  @Override
  public void apply(Hero hero) {
    if (hero.getMaxHp() / 7 < hero.getCurrentHp()) {
      if (hero.getCurrentHp() < hero.getMaxHp() / 5) {
        hero.setRaceAmplifier(hero.getRaceAmplifier() + 0.4f);
        hero.setCurrentHp(hero.getCurrentHp() * 6 / 7);
      }
    } else if (hero.getCurrentHp() < hero.getMaxHp() / 7) {
      hero.setRaceAmplifier(hero.getRaceAmplifier() - 0.1f);
      hero.setCurrentHp(hero.getCurrentHp() * 3 / 2);
    }
  }
}
