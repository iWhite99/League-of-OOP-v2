package abilities;

import heroes.Hero;
import utils.Constants;

public class DrainAbility extends Ability {
  private float startingPercent = Constants.DRAIN_PERCENT;
  private float currentPercent = Constants.DRAIN_PERCENT;
  private float increasePercent = Constants.DRAIN_PERCENT_INCREASE;

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }

  @Override
  public final void applyDamage(final Hero hero, final float amplifier) {

  }

}
