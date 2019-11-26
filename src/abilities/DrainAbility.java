package abilities;

import heroes.Hero;
import sites.Site;
import utils.Constants;

public class DrainAbility extends Ability {
  private float initialPercent = Constants.DRAIN_PERCENT;
  private float currentPercent = initialPercent;

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }

  @Override
  public final void applyDamage(final Hero hero, final float amplifier, final int round,
                                final int damageTaken, final Site site) {
    float amplifiedPercent = this.currentPercent * amplifier;
    int baseDamage = Math.round(Math.min(Constants.DRAIN_AMPLIFIER
            * hero.getMaxHp(), hero.getCurrentHp()));
    hero.setDamageWithoutAmplifier(baseDamage);
    hero.setDamage(Math.round(amplifiedPercent * baseDamage));
  }

  @Override
  public final void updateAbility(final Hero hero) {
    super.updateAbility(hero);
    float increasePercent = Constants.DRAIN_PERCENT_INCREASE;
    this.currentPercent = this.initialPercent + hero.getLevel() * increasePercent;
  }
}
