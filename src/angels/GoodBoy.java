package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class GoodBoy extends Angel {
  public GoodBoy(Position position, Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() > 0) {
      knight.setRaceAmplifier(knight.getRaceAmplifier() + 0.4f);
      knight.setCurrentHp(knight.getCurrentHp() + 20);
      this.getMagician().update(this, Constants.GOOD_BOY_HELPED + knight.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() > 0) {
      pyromancer.setRaceAmplifier(pyromancer.getRaceAmplifier() + 0.5f);
      pyromancer.setCurrentHp(pyromancer.getCurrentHp() + 30);
      this.getMagician().update(this, Constants.GOOD_BOY_HELPED + pyromancer.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() > 0) {
      rogue.setRaceAmplifier(rogue.getRaceAmplifier() + 0.4f);
      rogue.setCurrentHp(rogue.getCurrentHp() + 40);
      this.getMagician().update(this, Constants.GOOD_BOY_HELPED + rogue.heroTypeAndIndex());
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() > 0) {
      wizard.setRaceAmplifier(wizard.getRaceAmplifier() + 0.3f);
      wizard.setCurrentHp(wizard.getCurrentHp() + 50);
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
