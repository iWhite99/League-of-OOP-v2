package abilities;

import heroes.Hero;
import sites.Site;
import utils.Constants;

public class ExecuteAbility extends Ability {
  private float initialLimit = Constants.EXECUTE_LIMIT;
  private float currentLimit = initialLimit;

  public ExecuteAbility() {
    this.setInitialDamage(Constants.EXECUTE_DAMAGE);
    this.setCurrentDamage(Constants.EXECUTE_DAMAGE);
    this.setIncreaseDamage(Constants.EXECUTE_DAMAGE_INCREASE);
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
    int damageWithSiteAmplifier = Math.round(damage * siteAmplifier);
    hero.setDamage(hero.getDamage() + Math.round(damageWithSiteAmplifier * raceAmplifier));
    hero.setDamageWithoutAmplifier(hero.getDamageWithoutAmplifier()
            + damageWithSiteAmplifier);
    if (hero.getMaxHp() * currentLimit > hero.getCurrentHp()) {
      hero.setDamage(hero.getCurrentHp());
    }
  }

  @Override
  public final void updateAbility(final Hero hero) {
    super.updateAbility(hero);
    float limitIncrease = Constants.EXECUTE_LIMIT_INCREASE;
    float maxLimit = Constants.MAX_EXECUTE_LIMIT;
    this.currentLimit = Math.min(initialLimit + hero.getLevel() * limitIncrease, maxLimit);
  }
}
