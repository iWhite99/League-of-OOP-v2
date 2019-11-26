package abilities;

import heroes.Hero;
import sites.Site;
import utils.Constants;

public class DeflectAbility extends Ability {
  private float initialPercent = Constants.DEFLECT_PERCENT;
  private float currentPercent = initialPercent;

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }

  @Override
  public final void applyDamage(final Hero hero, final float amplifier, final int round,
                                final int damageTaken, final Site site) {
    int damage = Math.round(this.currentPercent * damageTaken);
    hero.setDamageWithoutAmplifier(damage);
    hero.setDamage(Math.round(damage * amplifier));
  }

  @Override
  public final void updateAbility(final Hero hero) {
    super.updateAbility(hero);
    float increasePercent = Constants.DEFLECT_PERCENT_INCREASE;
    this.currentPercent = Math.min(this.initialPercent + hero.getLevel()
            * increasePercent, Constants.DEFLECT_MAX_PERCENT);
  }
}
