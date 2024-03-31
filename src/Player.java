import processing.core.PImage;

import java.io.File;

public class Player extends Object implements Drawable {

  public int x;

  public float y;

  public float verticalVelocity = 0;

  public PImage playerImage; //Player Image

  public String imagesPath = "images" + File.separator; //Path to images

  public static GameSetup main;

  public boolean isOnPlatform;


  public Player(int x, int y) {
    this.x = x;
    this.y = y;
    playerImage = main.loadImage(imagesPath + "player.png");
    playerImage.resize(50, 65);
    this.isOnPlatform = false;
  }

  public void set(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void draw() {
    main.image(playerImage, this.x, this.y);
    collitionDetection();
    gravity();
    borderStop();
  }

  public void jump() {
    if (this.isOnPlatform || this.y == 542) {
      verticalVelocity = -50;
    }
  }

  public static void setProcessing(GameSetup main) {
    Player.main = main;
  }

  public void gravity() {
    this.verticalVelocity += 5;
    this.y += verticalVelocity;
  }

  public void collitionDetection() {
    this.isOnPlatform = false;
    if (this.verticalVelocity > 0) {
      for (Platform platform : main.platformsDisplayed) {
        if (this.x + this.playerImage.width > platform.platformGetX() && this.x < platform.platformGetX() + platform.platformWidth() && this.y + this.playerImage.height > platform.platformGetY() && this.y < platform.platformGetY() + platform.platformHeight()) {
          this.y = platform.platformGetY() - this.playerImage.height;
          this.verticalVelocity = 0;
          isOnPlatform = true;
          break;
        }
      }
    }
    if (this.y >= 542) {
      isOnPlatform = true;
    }
  }

  public void borderStop() {
    if (this.y > 542) {
      this.y = 542;
      verticalVelocity = 0;
    }
  }

  public void move(int dx) {
    this.x = this.x + dx;
  }
}
