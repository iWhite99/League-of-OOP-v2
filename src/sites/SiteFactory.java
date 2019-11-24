package sites;

import utils.Constants;

public class SiteFactory {
  /**
   * @param siteType represents the type of the Site that will be returned
   * @return a Site of the wanted type or null if the type is not implemented.
   */
  public final Site getSite(final char siteType) {
    switch (siteType) {
      case Constants.LAND_CHAR:
        return new LandSite();
      case Constants.VOLCANIC_CHAR:
        return new VolcanicSite();
      case Constants.DESERT_CHAR:
        return new DesertSite();
      case Constants.WOODS_CHAR:
        return new WoodsSite();
      default:
        return null;
    }
  }
}
