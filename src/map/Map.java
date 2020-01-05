package map;

import sites.Site;
import sites.SiteFactory;

/**
 * Implemented Singleton class to get the map of the game.
 */
public final class Map {
  private Site[][] siteMap;

  private static Map instance = null;

  private Map(final char[][] map) {
    int siteHeight = map.length;
    int siteWidth = map[0].length;
    this.siteMap = new Site[siteHeight][siteWidth];  // Allocate the map
    SiteFactory siteFactory = new SiteFactory();  // Used to generate different sites
    for (int i = 0; i < siteHeight; i++) {
      // Keep the row as a char array in order to access directly every site
      for (int j = 0; j < siteWidth; j++) {
        this.siteMap[i][j] = siteFactory.getSite(map[i][j]);
        // Get the wanted type of site in the actual position
      }
    }
  }

  public static Map getInstance(final char[][] map) {
    if (instance == null) {
      instance = new Map(map);
    }
    return instance;
  }

  public Site[][] getSiteMap() {
    return siteMap;
  }
}
