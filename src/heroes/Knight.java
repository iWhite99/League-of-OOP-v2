package heroes;

import abilities.BackstabAbility;
import abilities.DeflectAbility;
import abilities.DrainAbility;
import abilities.ExecuteAbility;
import abilities.FireblastAbility;
import abilities.IgniteAbility;
import abilities.ParalysisAbility;
import abilities.SlamAbility;
import angels.Angel;
import sites.DesertSite;
import sites.LandSite;
import sites.Site;
import sites.VolcanicSite;
import sites.WoodsSite;
import strategies.KnightStrategy;
import utils.Constants;

public class Knight extends Hero {
  private ExecuteAbility execute = new ExecuteAbility();
  private SlamAbility slam = new SlamAbility();
  private KnightStrategy knightStrategy = new KnightStrategy();

  Knight(final int id) {
    super(id);
    this.setMaxHp(Constants.KNIGHT_BASE_HP);
    this.setCurrentHp(this.getMaxHp());
    this.setHpIncrease(Constants.KNIGHT_HP_INCREASE);
  }

  @Override
  public final void fight(final Hero hero, final Site site, final int round) {
    execute.acceptRaceAmplifier(hero);
    site.acceptSiteAmplifier(this);
    float raceAmplifier = hero.getRaceAmplifier();
    if (raceAmplifier != 1) {
      raceAmplifier += this.getDamageAmplifier();
    }
    float siteAmplifier = this.getSiteAmplifier();
    execute.applyDamage(hero, raceAmplifier, siteAmplifier, round,
            this.getDamageWithoutAmplifier(), site);
    slam.acceptRaceAmplifier(hero);
    raceAmplifier = hero.getRaceAmplifier();
    raceAmplifier += this.getDamageAmplifier();
    slam.applyDamage(hero, raceAmplifier, siteAmplifier, round,
            this.getDamageWithoutAmplifier(), site);
  }

  @Override
  public final void visitRaceAmplifier(final ExecuteAbility executeAbility) {
    this.setRaceAmplifier(Constants.EXECUTE_KNIGHT_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final SlamAbility slamAbility) {
    this.setRaceAmplifier(Constants.SLAM_KNIGHT_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final FireblastAbility fireblastAbility) {
    this.setRaceAmplifier(Constants.FIREBLAST_KNIGHT_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final IgniteAbility igniteAbility) {
    this.setRaceAmplifier(Constants.IGNITE_KNIGHT_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final BackstabAbility backstabAbility) {
    this.setRaceAmplifier(Constants.BACKSTAB_KNIGHT_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final ParalysisAbility paralysisAbility) {
    this.setRaceAmplifier(Constants.PARALYSIS_KNIGHT_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DrainAbility drainAbility) {
    this.setRaceAmplifier(Constants.DRAIN_KNIGHT_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DeflectAbility deflectAbility) {
    this.setRaceAmplifier(Constants.DEFLECT_KNIGHT_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final DesertSite desertSite) {
    this.setSiteAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final LandSite landSite) {
    this.setSiteAmplifier(Constants.LAND_SITE_KNIGHT_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final VolcanicSite volcanicSite) {
    this.setSiteAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final WoodsSite woodsSite) {
    this.setSiteAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void updateAbilities() {
    this.execute.updateAbility(this);
    this.slam.updateAbility(this);
  }

  @Override
  public final String getHeroType() {
    return Constants.KNIGHT_STRING;
  }

  @Override
  public final void acceptDamageAmplifier(final Angel angel) {
    angel.visitDamageAmplifier(this);
  }

  @Override
  public final void applyStrategy() {
    this.knightStrategy.apply(this);
  }

  @Override
  public final String heroTypeAndIndex() {
    return "Knight " + this.getId();
  }
}
