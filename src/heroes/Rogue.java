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

public class Rogue extends Hero {
  private int consecutiveRounds = 0;

  public Rogue(final int id) {
    super(id);
    this.setMaxHp(Constants.ROGUE_BASE_HP);
    this.setCurrentHp(this.getMaxHp());
    this.setHpIncrease(Constants.ROGUE_HP_INCREASE);
  }

  @Override
  public final void fight(final Hero hero, final Site site) {

  }

  @Override
  public final void visitRaceAmplifier(final ExecuteAbility executeAbility) {
    this.setAmplifier(Constants.EXECUTE_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final SlamAbility slamAbility) {
    this.setAmplifier(Constants.SLAM_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final FireblastAbility fireblastAbility) {
    this.setAmplifier(Constants.FIREBLAST_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final IgniteAbility igniteAbility) {
    this.setAmplifier(Constants.IGNITE_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final BackstabAbility backstabAbility) {
    this.setAmplifier(Constants.BACKSTAB_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final ParalysisAbility paralysisAbility) {
    this.setAmplifier(Constants.PARALYSIS_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DrainAbility drainAbility) {
    this.setAmplifier(Constants.DRAIN_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DeflectAbility deflectAbility) {
    this.setAmplifier(Constants.DEFLECT_ROGUE_AMPLIFIER);
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
    this.setAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final WoodsSite woodsSite) {
    this.setAmplifier(Constants.WOODS_SITE_ROGUE_AMPLIFIER);
  }
}

