package abilities;

import heroes.Hero;
import moves.NoMove;
import sites.Site;
import utils.Constants;

public class ParalysisAbility extends Ability {
  public ParalysisAbility() {
    this.setInitialDamage(Constants.PARALYSIS_DAMAGE);
    this.setCurrentDamage(this.getInitialDamage());
    this.setIncreaseDamage(Constants.PARALYSIS_DAMAGE_INCREASE);
    this.setInitialOvertimeDamage(Constants.PARALYSIS_DAMAGE);
    this.setCurrentOvertimeDamage(this.getInitialOvertimeDamage());
    this.setIncreaseOvertimeDamage(Constants.PARALYSIS_DAMAGE_INCREASE);
    this.setRounds(Constants.PARALYSIS_ROUNDS);
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
    if (site.rogueBonus()) {
      hero.setRoundsLeft(Constants.PARALYSIS_ROUNDS_WOODS);
    } else {
      hero.setRoundsLeft(Constants.PARALYSIS_ROUNDS);
    }
    for (int i = round + 1; i < hero.getMoves().length
            && i - round - 1 < hero.getRoundsLeft(); i++) {
      hero.getMoves()[i] = new NoMove();
      hero.getIncapacity()[i] = 1;
    }
  }
}
