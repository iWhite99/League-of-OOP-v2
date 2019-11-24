package abilities;

import heroes.Hero;
import utils.Constants;

public class DeflectAbility extends Ability {
  private float startingPercent = Constants.DEFLECT_PERCENT;
  private float currentPercent = Constants.DEFLECT_PERCENT;
  private float increasePercent = Constants.DEFLECT_PERCENT_INCREASE;

  public DeflectAbility(final Hero hero) {
    this.setInitialDamage(Math.round(hero.getDamage() * currentPercent));
    this.setCurrentDamage(this.getInitialDamage());
  }

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }
}
