import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class GameSetup extends PApplet {

  public int level; //Current Level

  Player player; //Player Object

  public String imagesPath = "images" + File.separator; //Path to images

  public PImage backgroundImage; //Background Image

  public String levelOne = imagesPath + "one.png"; //Level One Image

  public Door door; //Door Object

  public Platform platform; //Platform Object
  public Platform platform2;

  public ArrayList<Platform> platformsDisplayed = new ArrayList<Platform>();

  private HashMap<Character, Boolean> keyMap = new HashMap<>(); //To Element Key Presses

  public GameSetup() {
    // Initialize your key states to false
    keyMap.put('w', false);
    keyMap.put('a', false);
    keyMap.put('d', false);
  }

  public static void main(String[] args) {
    PApplet.main("GameSetup");
  }

  public void settings() {
    size(1280, 720); //720p Resolution
  }

  @Override
  public void setup() {
    //Background
    background(255);

    //Level One
    this.level = 1;
    this.backgroundImage = loadImage(levelOne);

    //SetProcessing for Player, Door, and Platform
    Player.setProcessing(this);
    Door.setProcessing(this);
    Platform.setProcessing(this);

    //Player, Door, and Platform for Level 1
    player = new Player(70, 400);
    door = new Door(1000, 457);

  }

  public void backgroundSetter() {
    this.backgroundImage = loadImage(levelOne);
  }

  public void draw() {
    //Draw Background, Player, Door, and Platform
    image(backgroundImage, 0, 0);
    levelSetter();

    //Changing the Level
    changeLevel();

    //Move Player
    if (keyMap.get('a')) {
      player.move(-7);
    }
    if (keyMap.get('d')) {
      player.move(7);
    }

    // Draw game elements
    player.draw();
    door.draw();

    for (Platform drawnPlatform : platformsDisplayed) {
      drawnPlatform.draw();
    }
  }

  public void keyPressed() {
    // Update keyMap based on which key is pressed
    if (key == 'a' || key == 'd') {
      keyMap.put(key, true);
    }
    if (key == 'w') {
      player.jump();
    }
  }

  public void keyReleased() {
    // Update keyMap when keys are released
    if (key == 'a' || key == 'd') {
      keyMap.put(key, false);
    }
  }

  public void changeLevel() {
    //Player Right and Left Positions
    int playerRight = player.x + player.playerImage.width / 2;
    int playerLeft = player.x - player.playerImage.width / 2;

    //Door Right and Left Positions
    int doorRight = door.doorX() + door.doorWidth() / 2;
    int doorLeft = door.doorX() - door.doorWidth() / 2;

    //If Player is in the Door
    if (playerRight > doorLeft && playerLeft < doorRight) {
      if (keyPressed && key == 'n') {
        level++;
        player.set(70, 400);
      }
    }

    if (keyPressed && key == 'l') { //FOR DEVS TO CHANGE LEVEL
      this.level = 2;
    }

    if (playerRight < 0 || playerLeft > width) { //Easteregg
      backgroundImage = loadImage(imagesPath + "oneEaster.png");
    } else {
      backgroundSetter();
    }
  }

  public void levelSetter() {
    if (level == 2) {
      levelTwo();
    }
    if (level == 3) {
      levelThree();
    }
  }

  public void levelTwo() {
    if (level == 2) {
      platform = new Platform(500, 500);
      platform2 = new Platform(800, 350);
      platformsDisplayed.add(platform);
      platformsDisplayed.add(platform2);
    }
  }

  public void levelThree() {
    platformsDisplayed.clear();
  }
}
