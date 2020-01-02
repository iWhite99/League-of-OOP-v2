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
import strategies.RogueStrategy;
import utils.Constants;

public class Rogue extends Hero {
  private BackstabAbility backstab = new BackstabAbility();
  private ParalysisAbility paralysis = new ParalysisAbility();
  private RogueStrategy rogueStrategy = new RogueStrategy();

  Rogue(final int id) {
    super(id);
    this.setMaxHp(Constants.ROGUE_BASE_HP);
    this.setCurrentHp(this.getMaxHp());
    this.setHpIncrease(Constants.ROGUE_HP_INCREASE);
  }

  @Override
  public final void fight(final Hero hero, final Site site, final int round) {
    backstab.acceptRaceAmplifier(hero);
    site.acceptSiteAmplifier(this);
    float raceAmplifier = hero.getRaceAmplifier();
    float siteAmplifier = this.getSiteAmplifier() * this.getDamageAmplifier();
    backstab.applyDamage(hero, raceAmplifier, siteAmplifier, round,
            this.getDamageWithoutAmplifier(), site);
    if (round % Constants.CONSECUTIVE_ROUNDS == 0 && site.rogueBonus()) {
      hero.setDamageWithoutAmplifier(Math.round(hero.getDamageWithoutAmplifier()
              * Constants.CRITICAL_HIT));
      hero.setDamage(Math.round(hero.getDamage() * Constants.CRITICAL_HIT));
    }
    paralysis.acceptRaceAmplifier(hero);
    raceAmplifier = hero.getRaceAmplifier();
    paralysis.applyDamage(hero, raceAmplifier, siteAmplifier, round,
            this.getDamageWithoutAmplifier(), site);
  }

  @Override
  public final void visitRaceAmplifier(final ExecuteAbility executeAbility) {
    this.setRaceAmplifier(Constants.EXECUTE_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final SlamAbility slamAbility) {
    this.setRaceAmplifier(Constants.SLAM_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final FireblastAbility fireblastAbility) {
    this.setRaceAmplifier(Constants.FIREBLAST_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final IgniteAbility igniteAbility) {
    this.setRaceAmplifier(Constants.IGNITE_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final BackstabAbility backstabAbility) {
    this.setRaceAmplifier(Constants.BACKSTAB_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final ParalysisAbility paralysisAbility) {
    this.setRaceAmplifier(Constants.PARALYSIS_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DrainAbility drainAbility) {
    this.setRaceAmplifier(Constants.DRAIN_ROGUE_AMPLIFIER);
  }

  @Override
  public final void visitRaceAmplifier(final DeflectAbility deflectAbility) {
    this.setRaceAmplifier(Constants.DEFLECT_ROGUE_AMPLIFIER);
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
    this.setSiteAmplifier(Constants.NO_AMPLIFIER);
  }

  @Override
  public final void visitSiteAmplifier(final WoodsSite woodsSite) {
    this.setSiteAmplifier(Constants.WOODS_SITE_ROGUE_AMPLIFIER);
  }

  @Override
  public final void updateAbilities() {
    backstab.updateAbility(this);
    paralysis.updateAbility(this);
  }

  @Override
  public final String getHeroType() {
    return Constants.ROGUE_STRING;
  }

  @Override
  public void acceptDamageAmplifier(Angel angel) {
    angel.visitDamageAmplifier(this);
  }

  @Override
  public void applyStrategy() {
    this.rogueStrategy.apply(this);
  }
}

