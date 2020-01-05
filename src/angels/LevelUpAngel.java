package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class LevelUpAngel extends Angel {
  public LevelUpAngel(final Position position, final Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setXp(knight.getLevelUpXp());
      knight.setDamageAmplifier(knight.getDamageAmplifier() + Constants.LEVEL_UP_ANGEL_KNIGHT);
      this.getMagician().update(this, Constants.LEVEL_UP_ANGEL_HELPED + knight.heroTypeAndIndex());
      knight.levelUp(this.getMagician());
      knight.setCurrentHp(knight.getMaxHp());
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setXp(pyromancer.getLevelUpXp());
      pyromancer.setDamageAmplifier(pyromancer.getDamageAmplifier()
              + Constants.LEVEL_UP_ANGEL_PYROMANCER);
      this.getMagician().update(this, Constants.LEVEL_UP_ANGEL_HELPED
              + pyromancer.heroTypeAndIndex());
      pyromancer.levelUp(this.getMagician());
      pyromancer.setCurrentHp(pyromancer.getMaxHp());
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setXp(rogue.getLevelUpXp());
      rogue.setDamageAmplifier(rogue.getDamageAmplifier() + Constants.LEVEL_UP_ANGEL_ROGUE);
      this.getMagician().update(this, Constants.LEVEL_UP_ANGEL_HELPED + rogue.heroTypeAndIndex());
      rogue.levelUp(this.getMagician());
      rogue.setCurrentHp(rogue.getMaxHp());
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setXp(wizard.getLevelUpXp());
      wizard.setDamageAmplifier(wizard.getDamageAmplifier() + Constants.LEVEL_UP_ANGEL_WIZARD);
      this.getMagician().update(this, Constants.LEVEL_UP_ANGEL_HELPED + wizard.heroTypeAndIndex());
      wizard.levelUp(this.getMagician());
      wizard.setCurrentHp(wizard.getMaxHp());
    }
  }

  @Override
  public void spawn() {
    int row = this.getPosition().getCurrentRow();
    int column = this.getPosition().getCurrentColumn();
    this.getMagician().update(this, Constants.LEVEL_UP_ANGEL_SPAWNED + row + " " + column);
  }
}
