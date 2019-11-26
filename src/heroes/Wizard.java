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
  private DrainAbility drain = new DrainAbility();
  private DeflectAbility deflect = new DeflectAbility();

  public Wizard(final int id) {
    super(id);
    this.setMaxHp(Constants.WIZARD_BASE_HP);
    this.setCurrentHp(this.getMaxHp());
    this.setHpIncrease(Constants.WIZARD_HP_INCREASE);
  }

  @Override
  public final void fight(final Hero hero, final Site site, final int round) {
    drain.acceptRaceAmplifier(hero);
    site.acceptSiteAmplifier(this);
    float raceAmplifier = hero.getRaceAmplifier();
    float siteAmplifier = this.getSiteAmplifier();
    float totalAmplifier = raceAmplifier * siteAmplifier;
    drain.applyDamage(hero, totalAmplifier, round,
            Math.round(this.getDamageWithoutAmplifier() * siteAmplifier), site);
    deflect.acceptRaceAmplifier(hero);
    raceAmplifier = hero.getRaceAmplifier();
    totalAmplifier = raceAmplifier * siteAmplifier;
    deflect.applyDamage(hero, totalAmplifier, round,
            Math.round(this.getDamageWithoutAmplifier() * siteAmplifier), site);
  }

  @Override
  public final void visitRaceAmplifier(final ExecuteAbility executeAbility) {
    this.setRaceAmplifier(Constants.EXECUTE_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final SlamAbility slamAbility) {
    this.setRaceAmplifier(Constants.SLAM_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final FireblastAbility fireblastAbility) {
    this.setRaceAmplifier(Constants.FIREBLAST_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final IgniteAbility igniteAbility) {
    this.setRaceAmplifier(Constants.IGNITE_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final BackstabAbility backstabAbility) {
    this.setRaceAmplifier(Constants.BACKSTAB_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final ParalysisAbility paralysisAbility) {
    this.setRaceAmplifier(Constants.PARALYSIS_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DrainAbility drainAbility) {
    this.setRaceAmplifier(Constants.DRAIN_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DeflectAbility deflectAbility) {
    this.setRaceAmplifier(Constants.DEFLECT_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final DesertSite desertSite) {
    this.setRaceAmplifier(Constants.DESERT_SITE_WIZARD_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final LandSite landSite) {
    this.setSiteAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final VolcanicSite volcanicSite) {
    this.setSiteAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final WoodsSite woodsSite) {
    this.setSiteAmplifier(Constants.NO_AMPLIFIER);
  }

  /**
   * Wizards need to be attacked first in order to deflect the damage received.
   * @return 1 for Comparator
   */
  @Override
  public final int compareCoefficient() {
    return 1;
  }

  @Override
  public final void updateAbilities() {
    drain.updateAbility(this);
    deflect.updateAbility(this);
  }
}
