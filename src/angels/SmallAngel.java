package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class SmallAngel extends Angel {
  public SmallAngel(final Position position, final Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setDamageAmplifier(knight.getDamageAmplifier() + Constants.SMALL_ANGEL_KNIGHT);
      knight.setCurrentHp(knight.getCurrentHp() + Constants.SMALL_ANGEL_KNIGHT_HP);
      this.getMagician().update(this, Constants.SMALL_ANGEL_HELPED + knight.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setDamageAmplifier(pyromancer.getDamageAmplifier()
              + Constants.SMALL_ANGEL_PYROMANCER);
      pyromancer.setCurrentHp(pyromancer.getCurrentHp() + Constants.SMALL_ANGEL_PYROMANCER_HP);
      this.getMagician().update(this, Constants.SMALL_ANGEL_HELPED + pyromancer.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setDamageAmplifier(rogue.getDamageAmplifier() + Constants.SMALL_ANGEL_ROGUE);
      rogue.setCurrentHp(rogue.getCurrentHp() + Constants.SMALL_ANGEL_ROGUE_HP);
      this.getMagician().update(this, Constants.SMALL_ANGEL_HELPED + rogue.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setDamageAmplifier(wizard.getDamageAmplifier() + Constants.SMALL_ANGEL_WIZARD);
      wizard.setCurrentHp(wizard.getCurrentHp() + Constants.SMALL_ANGEL_WIZARD_HP);
      this.getMagician().update(this, Constants.SMALL_ANGEL_HELPED + wizard.heroTypeAndIndex());
    }
  }

  @Override
  public void spawn() {
    int row = this.getPosition().getCurrentRow();
    int column = this.getPosition().getCurrentColumn();
    this.getMagician().update(this, Constants.SMALL_ANGEL_SPAWNED + row + " " + column);
  }
}
