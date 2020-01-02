package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Position;

public final class LevelUpAngel extends Angel {
  public LevelUpAngel(final Position position) {
    super(position);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setXp(knight.getLevelUpXp());
      knight.setDamageAmplifier(knight.getDamageAmplifier() * 1.1f);
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setXp(pyromancer.getLevelUpXp());
      pyromancer.setDamageAmplifier(pyromancer.getDamageAmplifier() * 1.2f);
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setXp(rogue.getLevelUpXp());
      rogue.setDamageAmplifier(rogue.getDamageAmplifier() * 1.15f);
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setXp(wizard.getLevelUpXp());
      wizard.setDamageAmplifier(wizard.getDamageAmplifier() * 1.25f);
    }
  }
}
