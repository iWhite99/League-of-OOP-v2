package abilities;

import heroes.Hero;
import utils.Constants;

public class DrainAbility extends Ability {
  private float startingPercent = Constants.DRAIN_PERCENT;
  private float currentPercent = Constants.DRAIN_PERCENT;
  private float increasePercent = Constants.DRAIN_PERCENT_INCREASE;

  public DrainAbility(final Hero hero) {
    float base = Float.min(Constants.DRAIN_AMPLIFIER * hero.getMaxHp(), hero.getCurrentHp());
    this.setInitialDamage(Math.round(currentPercent * base));
    this.setCurrentDamage(this.getInitialDamage());
  }

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }
}
