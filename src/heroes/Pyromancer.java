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
  public final void fight(final Hero hero, final Site site, final int round) {
    fireblast.acceptRaceAmplifier(hero);
    site.acceptSiteAmplifier(this);
    float raceAmplifier = hero.getRaceAmplifier();
    float siteAmplifier = this.getSiteAmplifier();
    float totalAmplifier = raceAmplifier * siteAmplifier;
    fireblast.applyDamage(hero, totalAmplifier, round,
            Math.round(this.getDamageWithoutAmplifier() * siteAmplifier), site);
    ignite.acceptRaceAmplifier(hero);
    raceAmplifier = hero.getRaceAmplifier();
    totalAmplifier = raceAmplifier * siteAmplifier;
    ignite.applyDamage(hero, totalAmplifier, round,
            Math.round(this.getDamageWithoutAmplifier() * siteAmplifier), site);
  }

  @Override
  public final void visitRaceAmplifier(final ExecuteAbility executeAbility) {
    this.setRaceAmplifier(Constants.EXECUTE_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final SlamAbility slamAbility) {
    this.setRaceAmplifier(Constants.SLAM_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final FireblastAbility fireblastAbility) {
    this.setRaceAmplifier(Constants.FIREBLAST_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final IgniteAbility igniteAbility) {
    this.setRaceAmplifier(Constants.IGNITE_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final BackstabAbility backstabAbility) {
    this.setRaceAmplifier(Constants.BACKSTAB_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final ParalysisAbility paralysisAbility) {
    this.setRaceAmplifier(Constants.PARALYSIS_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DrainAbility drainAbility) {
    this.setRaceAmplifier(Constants.DRAIN_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DeflectAbility deflectAbility) {
    this.setRaceAmplifier(Constants.DEFLECT_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final DesertSite desertSite) {
    this.setSiteAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final LandSite landSite) {
    this.setSiteAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final VolcanicSite volcanicSite) {
    this.setSiteAmplifier(Constants.VOLCANIC_SITE_PYROMANCER_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final WoodsSite woodsSite) {
    this.setSiteAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void updateAbilities() {
    fireblast.updateAbility(this);
    ignite.updateAbility(this);
  }
}
