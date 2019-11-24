package abilities;

import heroes.Hero;
import utils.Constants;

public class BackstabAbility extends Ability {
  public BackstabAbility() {
    this.setInitialDamage(Constants.BACKSTAB_DAMAGE);
    this.setCurrentDamage(this.getInitialDamage());
    this.setIncreaseDamage(Constants.BACKSTAB_DAMAGE_INCREASE);
  }

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }
}
