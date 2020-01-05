package abilities;

import heroes.Hero;
import sites.Site;
import utils.Constants;

public class IgniteAbility extends Ability {
  public IgniteAbility() {
    this.setInitialDamage(Constants.IGNITE_DAMAGE);
    this.setCurrentDamage(this.getInitialDamage());
    this.setIncreaseDamage(Constants.IGNITE_DAMAGE_INCREASE);
    this.setInitialOvertimeDamage(Constants.IGNITE_DAMAGE_OVERTIME);
    this.setCurrentOvertimeDamage(this.getInitialOvertimeDamage());
    this.setIncreaseOvertimeDamage(Constants.IGNITE_DAMAGE_OVERTIME_INCREASE);
    this.setRounds(Constants.IGNITE_ROUNDS);
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
    int overtimeDamage = Math.round(this.getCurrentOvertimeDamage() * siteAmplifier);
    hero.setOvertimeDamage(Math.round(overtimeDamage * raceAmplifier));
    hero.setRoundsLeft(this.getRounds());
  }
}
