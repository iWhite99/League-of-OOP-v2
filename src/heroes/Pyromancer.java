package heroes;

import abilities.BackstabAbility;
import abilities.DeflectAbility;
import abilities.DrainAbility;
import abilities.ExecuteAbility;
import abilities.FireblastAbility;
import abilities.IgniteAbility;
import abilities.ParalysisAbility;
import abilities.SlamAbility;
import sites.DesertSite;
import sites.LandSite;
import sites.Site;
import sites.VolcanicSite;
import sites.WoodsSite;
import utils.Constants;

public class Pyromancer extends Hero {
  private FireblastAbility fireblast = new FireblastAbility();
  private IgniteAbility ignite = new IgniteAbility();

  public Pyromancer(final int id) {
    super(id);
    this.setMaxHp(Constants.PYROMANCER_BASE_HP);
    this.setCurrentHp(this.getMaxHp());
    this.setHpIncrease(Constants.PYROMANCER_HP_INCREASE);
  }

  @Override
  public final void fight(final Hero hero, final Site site) {

  }

  @Override
  public final void visitRaceAmplifier(final ExecuteAbility executeAbility) {
    this.setAmplifier(Constants.EXECUTE_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final SlamAbility slamAbility) {
    this.setAmplifier(Constants.SLAM_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final FireblastAbility fireblastAbility) {
    this.setAmplifier(Constants.FIREBLAST_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final IgniteAbility igniteAbility) {
    this.setAmplifier(Constants.IGNITE_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final BackstabAbility backstabAbility) {
    this.setAmplifier(Constants.BACKSTAB_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final ParalysisAbility paralysisAbility) {
    this.setAmplifier(Constants.PARALYSIS_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DrainAbility drainAbility) {
    this.setAmplifier(Constants.DRAIN_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DeflectAbility deflectAbility) {
    this.setAmplifier(Constants.DEFLECT_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final DesertSite desertSite) {
    this.setAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final LandSite landSite) {
    this.setAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final VolcanicSite volcanicSite) {
    this.setAmplifier(Constants.VOLCANIC_SITE_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final WoodsSite woodsSite) {
    this.setAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void updateAbilities() {

  }
}
