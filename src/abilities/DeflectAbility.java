package abilities;

import heroes.Hero;
import utils.Constants;

public class DeflectAbility extends Ability {
  private float startingPercent = Constants.DEFLECT_PERCENT;
  private float currentPercent = Constants.DEFLECT_PERCENT;
  private float increasePercent = Constants.DEFLECT_PERCENT_INCREASE;

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }

  @Override
  public final void applyDamage(final Hero hero, final float amplifier) {

  }

}
