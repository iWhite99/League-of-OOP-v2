package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class XPAngel extends Angel {
  public XPAngel(final Position position, final Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setXp(knight.getXp() + Constants.XP_ANGEL_KNIGHT);
      this.getMagician().update(this, Constants.XP_ANGEL_HELPED + knight.heroTypeAndIndex());
      while (knight.levelUp(this.getMagician())) {
        knight.setCurrentHp(knight.getMaxHp());
      }
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setXp(pyromancer.getXp() + Constants.XP_ANGEL_PYROMANCER);
      this.getMagician().update(this, Constants.XP_ANGEL_HELPED + pyromancer.heroTypeAndIndex());
      while (pyromancer.levelUp(this.getMagician())) {
        pyromancer.setCurrentHp(pyromancer.getMaxHp());
      }
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setXp(rogue.getXp() + Constants.XP_ANGEL_ROGUE);
      this.getMagician().update(this, Constants.XP_ANGEL_HELPED + rogue.heroTypeAndIndex());
      while (rogue.levelUp(this.getMagician())) {
        rogue.setCurrentHp(rogue.getMaxHp());
      }
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setXp(wizard.getXp() + Constants.XP_ANGEL_WIZARD);
      this.getMagician().update(this, Constants.XP_ANGEL_HELPED + wizard.heroTypeAndIndex());
      while (wizard.levelUp(this.getMagician())) {
        wizard.setCurrentHp(wizard.getMaxHp());
      }
    }
  }

  @Override
  public void spawn() {
    int row = this.getPosition().getCurrentRow();
    int column = this.getPosition().getCurrentColumn();
    this.getMagician().update(this, Constants.XP_ANGEL_SPAWNED + row + " " + column);
  }
}
