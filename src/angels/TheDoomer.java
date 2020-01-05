package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class TheDoomer extends Angel {
  public TheDoomer(final Position position, final Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setCurrentHp(0);
      this.getMagician().update(this, Constants.THE_DOOMER_HIT + knight.heroTypeAndIndex());
      this.getMagician().update(this, Constants.PLAYER + knight.heroTypeAndIndex()
              + Constants.WAS_KILLED + Constants.ANGEL);
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setCurrentHp(0);
      this.getMagician().update(this, Constants.THE_DOOMER_HIT + pyromancer.heroTypeAndIndex());
      this.getMagician().update(this, Constants.PLAYER + pyromancer.heroTypeAndIndex()
              + Constants.WAS_KILLED + Constants.ANGEL);
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setCurrentHp(0);
      this.getMagician().update(this, Constants.THE_DOOMER_HIT + rogue.heroTypeAndIndex());
      this.getMagician().update(this, Constants.PLAYER + rogue.heroTypeAndIndex()
              + Constants.WAS_KILLED + Constants.ANGEL);
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setCurrentHp(0);
      this.getMagician().update(this, Constants.THE_DOOMER_HIT + wizard.heroTypeAndIndex());
      this.getMagician().update(this, Constants.PLAYER + wizard.heroTypeAndIndex()
              + Constants.WAS_KILLED + Constants.ANGEL);
    }
  }

  @Override
  public void spawn() {
    int row = this.getPosition().getCurrentRow();
    int column = this.getPosition().getCurrentColumn();
    this.getMagician().update(this, Constants.THE_DOOMER_SPAWNED + row + " " + column);
  }
}
