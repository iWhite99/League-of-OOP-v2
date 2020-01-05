package abilities;

import heroes.Hero;
import sites.Site;
import utils.Constants;

public class BackstabAbility extends Ability {
  public BackstabAbility() {
    this.setInitialDamage(Constants.BACKSTAB_DAMAGE);
    this.setCurrentDamage(this.getInitialDamage());
    this.setIncreaseDamage(Constants.BACKSTAB_DAMAGE_INCREASE);
  }

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }

  @Override
  public final void applyDamage(final Hero hero, final float raceAmplifier,
                                final float siteAmplifier, final int round,
                                final int damageTaken, final Site site) {
//    System.out.println("BACKSTAB");
    float amplifier = raceAmplifier * siteAmplifier;
//    System.out.println(raceAmplifier + " " + siteAmplifier);
//    System.out.println(this.getCurrentDamage());

    hero.setDamageWithoutAmplifier(hero.getDamageWithoutAmplifier()
            + Math.round(this.getCurrentDamage() * siteAmplifier));
    int damage = Math.round(this.getCurrentDamage() * siteAmplifier);
    hero.setDamage(hero.getDamage() + Math.round(damage * raceAmplifier));
//    hero.setDamage(Math.round(hero.getDamage() + this.getCurrentDamage() * amplifier));
  }
}
