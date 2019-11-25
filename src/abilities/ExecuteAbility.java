package abilities;

import heroes.Hero;
import utils.Constants;

public class ExecuteAbility extends Ability {
  private float limit = Constants.EXECUTE_LIMIT;
  private float limitIncrease = Constants.EXECUTE_LIMIT_INCREASE;
  private float maxLimit = Constants.MAX_EXECUTE_LIMIT;

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
  public final void applyDamage(final Hero hero, final float amplifier) {

  }

}
