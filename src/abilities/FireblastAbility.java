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
  public final void applyDamage(final Hero hero, final float raceAmplifier,
                                final float siteAmplifier, final int round,
                                final int damageTaken, final Site site) {
    hero.setDamageWithoutAmplifier(hero.getDamageWithoutAmplifier()
            + Math.round(this.getCurrentDamage() * siteAmplifier));
    int damage = Math.round(this.getCurrentDamage() * siteAmplifier);
    hero.setDamage(hero.getDamage() + Math.round(damage * raceAmplifier));
  }
}
