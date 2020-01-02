package strategies;

import heroes.Hero;

public class PyromancerStrategy implements Strategy {
  @Override
  public void apply(Hero hero) {
    if (hero.getMaxHp() / 4 < hero.getCurrentHp()) {
      if (hero.getCurrentHp() < hero.getMaxHp() / 3) {
        hero.setRaceAmplifier(hero.getRaceAmplifier() + 0.7f);
        hero.setCurrentHp(hero.getCurrentHp() * 3 / 4);
      }
    } else if (hero.getCurrentHp() < hero.getMaxHp() / 4) {
      hero.setRaceAmplifier(hero.getRaceAmplifier() - 0.3f);
      hero.setCurrentHp(hero.getCurrentHp() * 4 / 3);
    }
  }
}
