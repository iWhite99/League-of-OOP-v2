package input;

import fileio.FileSystem;
import heroes.Hero;
import heroes.HeroFactory;
import moves.Move;
import moves.MoveFactory;
import sites.Site;
import sites.SiteFactory;
import utils.Constants;
import utils.Position;

import java.io.IOException;


public class GameLoader {
  private String inputFile;
  private String outputFile;

  public GameLoader(final String inputFile, final String outputFile) {
    this.inputFile = inputFile;
    this.outputFile = outputFile;
  }

  public final GameInput load() {
    int siteHeight = 0;
    int siteWidth = 0;
    Site[][] siteMap = null;
    int heroesNumber = 0;
    Hero[] heroes = null;
    int roundsNumber = 0;
    // Initialize the values with 0 and null if an exception is thrown
    try {
      FileSystem fileSystem = new FileSystem(this.inputFile, this.outputFile);
      siteHeight = fileSystem.nextInt();  // Get the height of the map
      siteWidth = fileSystem.nextInt();  // Get the width of the map
      siteMap = new Site[siteHeight][siteWidth];  // Allocate the map
      SiteFactory siteFactory = new SiteFactory();  // Used to generate different sites
      for (int i = 0; i < siteHeight; i++) {
        char[] currentRow = fileSystem.nextWord().toCharArray();
        // Keep the row as a char array in order to access directly every site
        for (int j = 0; j < siteWidth; j++) {
          siteMap[i][j] = siteFactory.getSite(currentRow[j]);
          // Get the wanted type of site in the actual position
        }
      }
      heroesNumber = fileSystem.nextInt();  // Get the number of the heroes
      heroes = new Hero[heroesNumber];  // Allocate the heroes
      HeroFactory heroFactory = new HeroFactory();  // Used to generate different types of heroes
      for (int i = 0; i < heroesNumber; i++) {
        heroes[i] = heroFactory.getHero(fileSystem.nextWord(), i);
        // Get the wanted type of hero in the actual position
        Position initialPosition = new Position(fileSystem.nextInt(),
                fileSystem.nextInt());
        // Get the initial position of a hero
        heroes[i].setPosition(initialPosition);
        // Set the initial position of a hero
      }
      roundsNumber = fileSystem.nextInt();  // Get the number of rounds
      for (int i = 0; i < heroesNumber; i++) {
        heroes[i].setMoves(new Move[roundsNumber]);  // Allocate the number of moves for each hero
      }
      MoveFactory moveFactory = new MoveFactory();  // Used to generate different types of moves
      for (int i = 0; i < roundsNumber; i++) {
        char[] currentRowMoves = fileSystem.nextWord().toCharArray();
        // Keep the row as a char array in order to access directly every move for each hero
        for (int j = 0; j < heroesNumber; j++) {
          heroes[j].getMoves()[i] = moveFactory.getMove(currentRowMoves[j]);
          // Set the current move
        }
      }
      fileSystem.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new GameInput(siteHeight, siteWidth, siteMap, heroesNumber, heroes, roundsNumber);
  }

  public final void end(final GameInput gameInput) {
    try {
      FileSystem fileSystem = new FileSystem(this.inputFile, this.outputFile);
      for (Hero currentHero : gameInput.getHeroes()) {
        fileSystem.writeWord(currentHero.toString());
        fileSystem.writeWord(Constants.NEWLINE);
      }
      fileSystem.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
