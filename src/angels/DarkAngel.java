package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Position;

public final class DarkAngel extends Angel {
  public DarkAngel(final Position position) {
    super(position);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setCurrentHp(knight.getCurrentHp() - 40);
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setCurrentHp(pyromancer.getCurrentHp() - 30);
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setCurrentHp(rogue.getCurrentHp() - 10);
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setCurrentHp(wizard.getCurrentHp() - 20);
    }
  }
}
