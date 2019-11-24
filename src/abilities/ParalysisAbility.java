package abilities;

import heroes.Hero;
import sites.Site;
import sites.WoodsSite;
import utils.Constants;

public class ParalysisAbility extends Ability {
  public ParalysisAbility(final Site site) {
    this.setInitialDamage(Constants.PARALYSIS_DAMAGE);
    this.setCurrentDamage(this.getInitialDamage());
    this.setIncreaseDamage(Constants.PARALYSIS_DAMAGE_INCREASE);
    this.setInitialOvertimeDamage(Constants.PARALYSIS_DAMAGE);
    this.setCurrentOvertimeDamage(this.getInitialOvertimeDamage());
    this.setIncreaseOvertimeDamage(Constants.PARALYSIS_DAMAGE_INCREASE);
    if (site instanceof WoodsSite) {  // Need to change this
      this.setRounds(Constants.PARALYSIS_ROUNDS_WOODS);
    } else {
      this.setRounds(Constants.PARALYSIS_ROUNDS);
    }
  }

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }
}
