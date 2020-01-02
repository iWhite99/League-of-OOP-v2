package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class SmallAngel extends Angel {
  public SmallAngel(Position position, Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setDamageAmplifier(knight.getDamageAmplifier() + 0.1f);
      knight.setCurrentHp(knight.getCurrentHp() + 10);
      this.getMagician().update(this, Constants.SMALL_ANGEL_HELPED + knight.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setDamageAmplifier(pyromancer.getDamageAmplifier() + 0.15f);
      pyromancer.setCurrentHp(pyromancer.getCurrentHp() + 15);
      this.getMagician().update(this, Constants.SMALL_ANGEL_HELPED + pyromancer.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setDamageAmplifier(rogue.getDamageAmplifier() + 0.05f);
      rogue.setCurrentHp(rogue.getCurrentHp() + 20);
      this.getMagician().update(this, Constants.SMALL_ANGEL_HELPED + rogue.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setDamageAmplifier(wizard.getDamageAmplifier() + 0.1f);
      wizard.setCurrentHp(wizard.getCurrentHp() + 25);
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
