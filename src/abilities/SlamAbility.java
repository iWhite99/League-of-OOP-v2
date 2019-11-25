package abilities;

import heroes.Hero;
import utils.Constants;

public class SlamAbility extends Ability {
  public SlamAbility() {
    this.setInitialDamage(Constants.SLAM_DAMAGE);
    this.setCurrentDamage(this.getInitialDamage());
    this.setIncreaseDamage(Constants.SLAM_DAMAGE_INCREASE);
  }

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }

  @Override
  public final void applyDamage(final Hero hero, final float amplifier) {

  }

}
