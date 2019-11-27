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
  public final void applyDamage(final Hero hero, final float raceAmplifier,
                                final float siteAmplifier, final int round,
                                final int damageTaken, final Site site) {
    float amplifier = raceAmplifier * siteAmplifier;
    float amplifiedPercent = this.currentPercent * amplifier;
    int baseDamage = Math.min(Math.round(Constants.DRAIN_AMPLIFIER
            * hero.getMaxHp()), hero.getCurrentHp());
    hero.setDamageWithoutAmplifier(hero.getDamageWithoutAmplifier()
            + Math.round(this.currentPercent * baseDamage * siteAmplifier));
    hero.setDamage(hero.getDamage() + Math.round(amplifiedPercent * baseDamage));
  }

  @Override
  public final void updateAbility(final Hero hero) {
    super.updateAbility(hero);
    float increasePercent = Constants.DRAIN_PERCENT_INCREASE;
    this.currentPercent = this.initialPercent + hero.getLevel() * increasePercent;
  }
}
