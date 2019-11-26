package abilities;

import heroes.Hero;
import moves.NoMove;
import sites.Site;
import sites.WoodsSite;
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
  public final void applyDamage(final Hero hero, final float amplifier, final int round,
                                final int damageTaken, final Site site) {
    hero.setDamageWithoutAmplifier(hero.getDamageWithoutAmplifier() + this.getCurrentDamage());
    hero.setDamage(hero.getDamage() + Math.round(this.getCurrentDamage() * amplifier));
    hero.setOvertimeDamage(Math.round(this.getCurrentOvertimeDamage() * amplifier));
    if (site instanceof WoodsSite) {  // Needs to be modified
      hero.setRoundsLeft(Constants.PARALYSIS_ROUNDS_WOODS);
    } else {
      hero.setRoundsLeft(Constants.PARALYSIS_ROUNDS);
    }
    for (int i = round + 1; i < hero.getMoves().length
            && i - round - 1 < hero.getRoundsLeft(); i++) {
      hero.getMoves()[i] = new NoMove();
    }
  }
}
