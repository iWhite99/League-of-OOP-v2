package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Position;

public final class DamageAngel extends Angel {
  public DamageAngel(final Position position) {
    super(position);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setDamageAmplifier(knight.getDamageAmplifier() * 1.15f);
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setDamageAmplifier(pyromancer.getDamageAmplifier() * 1.2f);
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setDamageAmplifier(rogue.getDamageAmplifier() * 1.3f);
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setDamageAmplifier(wizard.getDamageAmplifier() * 1.4f);
    }
  }
}
