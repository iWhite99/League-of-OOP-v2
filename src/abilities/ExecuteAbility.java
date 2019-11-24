package abilities;

import heroes.Hero;
import utils.Constants;

public class ExecuteAbility extends Ability {
  public ExecuteAbility() {
    this.setInitialDamage(Constants.EXECUTE_DAMAGE);
    this.setCurrentDamage(Constants.EXECUTE_DAMAGE);
    this.setIncreaseDamage(Constants.EXECUTE_DAMAGE_INCREASE);
  }

  @Override
  public final void acceptRaceAmplifier(final Hero hero) {
    hero.visitRaceAmplifier(this);
  }
}
