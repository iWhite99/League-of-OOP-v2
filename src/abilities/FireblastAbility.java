package abilities;

import heroes.Hero;
import sites.Site;
import utils.Constants;

public class FireblastAbility extends Ability {
  public FireblastAbility() {
    this.setInitialDamage(Constants.FIREBLAST_DAMAGE);
    this.setCurrentDamage(this.getInitialDamage());
    this.setIncreaseDamage(Constants.FIREBLAST_DAMAGE_INCREASE);
  }

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }

  @Override
  public final void applyDamage(final Hero hero, final float amplifier, final int round,
                                final int damageTaken, final Site site) {
    hero.setDamageWithoutAmplifier(this.getCurrentDamage());
    hero.setDamage(Math.round(this.getCurrentDamage() * amplifier));
  }
}
