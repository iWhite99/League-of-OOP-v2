package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class Dracula extends Angel {
  public Dracula(final Position position, final Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setDamageAmplifier(knight.getDamageAmplifier() - Constants.DRACULA_KNIGHT);
      knight.setCurrentHp(knight.getCurrentHp() - Constants.DRACULA_KNIGHT_HP);
      this.getMagician().update(this, Constants.DRACULA_HIT + knight.heroTypeAndIndex());
      if (knight.getCurrentHp() <= 0) {
        knight.setCurrentHp(0);
        this.getMagician().update(this, Constants.PLAYER + knight.heroTypeAndIndex()
                + Constants.WAS_KILLED + Constants.ANGEL);
      }
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setDamageAmplifier(pyromancer.getDamageAmplifier() - Constants.DRACULA_PYROMANCER);
      pyromancer.setCurrentHp(pyromancer.getCurrentHp() - Constants.DRACULA_PYROMANCER_HP);
      this.getMagician().update(this, Constants.DRACULA_HIT + pyromancer.heroTypeAndIndex());
      if (pyromancer.getCurrentHp() <= 0) {
        pyromancer.setCurrentHp(0);
        this.getMagician().update(this, Constants.PLAYER + pyromancer.heroTypeAndIndex()
                + Constants.WAS_KILLED + Constants.ANGEL);
      }
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setDamageAmplifier(rogue.getDamageAmplifier() - Constants.DRACULA_ROGUE);
      rogue.setCurrentHp(rogue.getCurrentHp() - Constants.DRACULA_ROGUE_HP);
      this.getMagician().update(this, Constants.DRACULA_HIT + rogue.heroTypeAndIndex());
      if (rogue.getCurrentHp() <= 0) {
        rogue.setCurrentHp(0);
        this.getMagician().update(this, Constants.PLAYER + rogue.heroTypeAndIndex()
                + Constants.WAS_KILLED + Constants.ANGEL);
      }
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setDamageAmplifier(wizard.getDamageAmplifier() - Constants.DRACULA_WIZARD);
      wizard.setCurrentHp(wizard.getCurrentHp() - Constants.DRACULA_WIZARD_HP);
      this.getMagician().update(this, Constants.DRACULA_HIT + wizard.heroTypeAndIndex());
      if (wizard.getCurrentHp() <= 0) {
        wizard.setCurrentHp(0);
        this.getMagician().update(this, Constants.PLAYER + wizard.heroTypeAndIndex()
                + Constants.WAS_KILLED + Constants.ANGEL);
      }
    }
  }

  @Override
  public void spawn() {
    int row = this.getPosition().getCurrentRow();
    int column = this.getPosition().getCurrentColumn();
    this.getMagician().update(this, Constants.DRACULA_SPAWNED + row + " " + column);
  }
}
