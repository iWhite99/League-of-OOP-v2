package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class XPAngel extends Angel {
  public XPAngel(Position position, Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setXp(knight.getXp() + 45);
      this.getMagician().update(this, Constants.XP_ANGEL_HELPED + knight.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setXp(pyromancer.getXp() + 50);
      this.getMagician().update(this, Constants.XP_ANGEL_HELPED + pyromancer.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setXp(rogue.getXp() + 40);
      this.getMagician().update(this, Constants.XP_ANGEL_HELPED + rogue.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setXp(wizard.getXp() + 60);
      this.getMagician().update(this, Constants.XP_ANGEL_HELPED + wizard.heroTypeAndIndex());
    }
  }

  @Override
  public void spawn() {
    int row = this.getPosition().getCurrentRow();
    int column = this.getPosition().getCurrentColumn();
    this.getMagician().update(this, Constants.XP_ANGEL_SPAWNED + row + " " + column);
  }
}
