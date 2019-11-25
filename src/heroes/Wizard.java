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

public class Wizard extends Hero {

  public Wizard(final int id) {
    super(id);
    this.setMaxHp(Constants.WIZARD_BASE_HP);
    this.setCurrentHp(this.getMaxHp());
    this.setHpIncrease(Constants.WIZARD_HP_INCREASE);
  }

  @Override
  public final void fight(final Hero hero, final Site site) {

  }

  @Override
  public final void visitRaceAmplifier(final ExecuteAbility executeAbility) {
    this.setAmplifier(Constants.EXECUTE_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final SlamAbility slamAbility) {
    this.setAmplifier(Constants.SLAM_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final FireblastAbility fireblastAbility) {
    this.setAmplifier(Constants.FIREBLAST_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final IgniteAbility igniteAbility) {
    this.setAmplifier(Constants.IGNITE_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final BackstabAbility backstabAbility) {
    this.setAmplifier(Constants.BACKSTAB_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final ParalysisAbility paralysisAbility) {
    this.setAmplifier(Constants.PARALYSIS_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DrainAbility drainAbility) {
    this.setAmplifier(Constants.DRAIN_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DeflectAbility deflectAbility) {
    this.setAmplifier(Constants.DEFLECT_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final DesertSite desertSite) {
    this.setAmplifier(Constants.DESERT_SITE_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final LandSite landSite) {
    this.setAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final VolcanicSite volcanicSite) {
    this.setAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final WoodsSite woodsSite) {
    this.setAmplifier(Constants.NO_AMPLIFIER);
  }

  /**
   * Wizards need to be attacked first in order to deflect the damage received.
   * @return 1 for Comparator
   */
  @Override
  public final int compareCoefficient() {
    return 1;
  }
}
