package abilities;

import heroes.Hero;
import utils.Constants;

public class ParalysisAbility extends Ability {
  public ParalysisAbility() {
    this.setInitialDamage(Constants.PARALYSIS_DAMAGE);
    this.setCurrentDamage(this.getInitialDamage());
    this.setIncreaseDamage(Constants.PARALYSIS_DAMAGE_INCREASE);
    this.setInitialOvertimeDamage(Constants.PARALYSIS_DAMAGE);
    this.setCurrentOvertimeDamage(this.getInitialOvertimeDamage());
    this.setIncreaseOvertimeDamage(Constants.PARALYSIS_DAMAGE_INCREASE);
  }

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }

  @Override
  public final void applyDamage(final Hero hero, final float amplifier) {

  }

}
