import processing.core.PImage;

import java.io.File;

public class Platform extends Object implements Drawable {

  public int x;

  public int y;

  public PImage platformImage; //Door Image

  public String imagesPath = "images" + File.separator; //Path to images

  public static GameSetup main;

  public Platform(int x, int y) {
    this.x = x;
    this.y = y;
    platformImage = main.loadImage(imagesPath + "platform.png");


  }

  @Override
  public void draw() {
    main.image(platformImage, this.x, this.y);
  }

  public static void setProcessing(GameSetup main) {
    Platform.main = main;
  }

  public int platformWidth() {
    return platformImage.width;
  }

  public int platformHeight() {
    return platformImage.height;
  }

  public int platformGetX() {
    return this.x;
  }

  public int platformGetY() {
    return this.y;
  }

  public void set(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
