package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Position;

public final class Dracula extends Angel {
  public Dracula(final Position position) {
    super(position);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setDamageAmplifier(knight.getDamageAmplifier() * 0.8f);
      knight.setCurrentHp(knight.getCurrentHp() - 60);
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setDamageAmplifier(pyromancer.getDamageAmplifier() * 0.7f);
      pyromancer.setCurrentHp(pyromancer.getCurrentHp() - 40);
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setDamageAmplifier(rogue.getDamageAmplifier() * 0.9f);
      rogue.setCurrentHp(rogue.getCurrentHp() - 35);
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setDamageAmplifier(wizard.getDamageAmplifier() * 0.6f);
      wizard.setCurrentHp(wizard.getCurrentHp() - 20);
    }
  }
}
