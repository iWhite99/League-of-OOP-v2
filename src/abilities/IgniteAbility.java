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
  public final void applyDamage(final Hero hero, final float amplifier, final int round,
                                final int damageTaken, final Site site) {
    hero.setDamageWithoutAmplifier(hero.getDamageWithoutAmplifier() + this.getCurrentDamage());
    hero.setDamage(hero.getDamage() + Math.round(this.getCurrentDamage() * amplifier));
    hero.setOvertimeDamage(Math.round(this.getCurrentOvertimeDamage() * amplifier));
    hero.setRoundsLeft(this.getRounds());
  }
}
