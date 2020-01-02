package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Position;

public final class Spawner extends Angel {
  public Spawner(final Position position) {
    super(position);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() == 0) {
      knight.setCurrentHp(200);
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() == 0) {
      pyromancer.setCurrentHp(150);
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() == 0) {
      rogue.setCurrentHp(180);
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() == 0) {
      wizard.setCurrentHp(120);
    }
  }
}
