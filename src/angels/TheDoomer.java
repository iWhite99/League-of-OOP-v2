package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Position;

public final class TheDoomer extends Angel {
  public TheDoomer(final Position position) {
    super(position);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    knight.setCurrentHp(0);
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    pyromancer.setCurrentHp(0);
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    rogue.setCurrentHp(0);
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    wizard.setCurrentHp(0);
  }
}
