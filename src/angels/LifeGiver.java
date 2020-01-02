package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Position;

public final class LifeGiver extends Angel {
  public LifeGiver(final Position position) {
    super(position);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setCurrentHp(knight.getCurrentHp() + 100);
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setCurrentHp(pyromancer.getCurrentHp() + 80);
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setCurrentHp(rogue.getCurrentHp() + 90);
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setCurrentHp(wizard.getCurrentHp() + 120);
    }
  }
}
