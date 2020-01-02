package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Position;

public final class SmallAngel extends Angel {
  public SmallAngel(final Position position) {
    super(position);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setDamageAmplifier(knight.getDamageAmplifier() * 1.1f);
      knight.setCurrentHp(knight.getCurrentHp() + 10);
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setDamageAmplifier(pyromancer.getDamageAmplifier() * 1.15f);
      pyromancer.setCurrentHp(pyromancer.getCurrentHp() + 15);
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setDamageAmplifier(rogue.getDamageAmplifier() * 1.05f);
      rogue.setCurrentHp(rogue.getCurrentHp() + 20);
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setDamageAmplifier(wizard.getDamageAmplifier() * 1.1f);
      wizard.setCurrentHp(wizard.getCurrentHp() + 25);
    }
  }
}
