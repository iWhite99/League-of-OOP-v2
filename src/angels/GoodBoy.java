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
      knight.setRaceAmplifier(knight.getRaceAmplifier() + Constants.GOOD_BOY_KNIGHT);
      knight.setCurrentHp(Math.min(knight.getCurrentHp() + Constants.GOOD_BOY_KNIGHT_HP,
              knight.getMaxHp()));
      this.getMagician().update(this, Constants.GOOD_BOY_HELPED + knight.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setRaceAmplifier(pyromancer.getRaceAmplifier() + Constants.GOOD_BOY_PYROMANCER);
      pyromancer.setCurrentHp(Math.min(pyromancer.getCurrentHp() + Constants.GOOD_BOY_PYROMANCER_HP,
              pyromancer.getMaxHp()));
      this.getMagician().update(this, Constants.GOOD_BOY_HELPED + pyromancer.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setRaceAmplifier(rogue.getRaceAmplifier() + Constants.GOOD_BOY_ROGUE);
      rogue.setCurrentHp(Math.min(rogue.getCurrentHp() + Constants.GOOD_BOY_ROGUE_HP,
              rogue.getMaxHp()));
      this.getMagician().update(this, Constants.GOOD_BOY_HELPED + rogue.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setRaceAmplifier(wizard.getRaceAmplifier() + Constants.GOOD_BOY_WIZARD);
      wizard.setCurrentHp(Math.min(wizard.getCurrentHp() + Constants.GOOD_BOY_WIZARD_HP,
              wizard.getMaxHp()));
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
