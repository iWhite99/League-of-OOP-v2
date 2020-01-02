package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class Dracula extends Angel {
  public Dracula(Position position, Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setDamageAmplifier(knight.getDamageAmplifier() - 0.2f);
      knight.setCurrentHp(knight.getCurrentHp() - 60);
      this.getMagician().update(this, Constants.DRACULA_HIT + knight.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setDamageAmplifier(pyromancer.getDamageAmplifier() - 0.3f);
      pyromancer.setCurrentHp(pyromancer.getCurrentHp() - 40);
      this.getMagician().update(this, Constants.DRACULA_HIT + pyromancer.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setDamageAmplifier(rogue.getDamageAmplifier() - 0.1f);
      rogue.setCurrentHp(rogue.getCurrentHp() - 35);
      this.getMagician().update(this, Constants.DRACULA_HIT + rogue.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setDamageAmplifier(wizard.getDamageAmplifier() - 0.4f);
      wizard.setCurrentHp(wizard.getCurrentHp() - 20);
      this.getMagician().update(this, Constants.DRACULA_HIT + wizard.heroTypeAndIndex());
    }
  }

  @Override
  public void spawn() {
    int row = this.getPosition().getCurrentRow();
    int column = this.getPosition().getCurrentColumn();
    this.getMagician().update(this, Constants.DRACULA_SPAWNED + row + " " + column);
  }
}
