package abilities;

import heroes.Hero;
import moves.NoMove;
import sites.Site;
import utils.Constants;

public class SlamAbility extends Ability {
  public SlamAbility() {
    this.setInitialDamage(Constants.SLAM_DAMAGE);
    this.setCurrentDamage(this.getInitialDamage());
    this.setIncreaseDamage(Constants.SLAM_DAMAGE_INCREASE);
  }

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }

  @Override
  public final void applyDamage(final Hero hero, final float raceAmplifier,
                                final float siteAmplifier, final int round,
                                final int damageTaken, final Site site) {
    int damage = this.getCurrentDamage();
    float amplifier = raceAmplifier * siteAmplifier;
    hero.setDamageWithoutAmplifier(hero.getDamageWithoutAmplifier()
            + Math.round(this.getCurrentDamage() * siteAmplifier));
    hero.setDamage(hero.getDamage() + Math.round(damage * amplifier));
    int roundsNumber = hero.getMoves().length;
    if (round < roundsNumber - 1) {
      hero.getMoves()[round + 1] = new NoMove();
    }
    hero.setIncapacity(1);
  }
}
