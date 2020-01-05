package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class GoodBoy extends Angel {
  public GoodBoy(final Position position, final Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setDamageAmplifier(knight.getDamageAmplifier() + Constants.GOOD_BOY_KNIGHT);
      knight.setCurrentHp(knight.getCurrentHp() + Constants.GOOD_BOY_KNIGHT_HP);
      this.getMagician().update(this, Constants.GOOD_BOY_HELPED + knight.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setDamageAmplifier(pyromancer.getDamageAmplifier()
              + Constants.GOOD_BOY_PYROMANCER);
      pyromancer.setCurrentHp(pyromancer.getCurrentHp() + Constants.GOOD_BOY_PYROMANCER_HP);
      this.getMagician().update(this, Constants.GOOD_BOY_HELPED + pyromancer.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setDamageAmplifier(rogue.getDamageAmplifier() + Constants.GOOD_BOY_ROGUE);
      rogue.setCurrentHp(rogue.getCurrentHp() + Constants.GOOD_BOY_ROGUE_HP);
      this.getMagician().update(this, Constants.GOOD_BOY_HELPED + rogue.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setDamageAmplifier(wizard.getDamageAmplifier() + Constants.GOOD_BOY_WIZARD);
      wizard.setCurrentHp(wizard.getCurrentHp() + Constants.GOOD_BOY_WIZARD_HP);
      this.getMagician().update(this, Constants.GOOD_BOY_HELPED + wizard.heroTypeAndIndex());
    }
  }

  @Override
  public void spawn() {
    int row = this.getPosition().getCurrentRow();
    int column = this.getPosition().getCurrentColumn();
    this.getMagician().update(this, Constants.GOOD_BOY_SPAWNED + row + " " + column);
  }
}
