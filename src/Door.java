import processing.core.PImage;

import java.io.File;

public class Door extends Object implements Drawable {

  public int x;

  public int y;

  public PImage doorImage; //Door Image

  public String imagesPath = "images" + File.separator; //Path to images

  public static GameSetup main;

  public Door(int x, int y) {
    this.x = x;
    this.y = y;
    doorImage = main.loadImage(imagesPath + "door.png");
    doorImage.resize(78, 148);
  }

  @Override
  public void draw() {
    main.image(doorImage, this.x, this.y);
    setX();
    setY();
  }

  public static void setProcessing(GameSetup main) {
    Door.main = main;
  }

  public void setX() {
    if(main.level == 2){
        this.x = 850;
    }
    if(main.level == 3){
        this.x = 1000;
    }
  }

  public void setY() {
    if(main.level == 2){
      this.y = 205;
    }
    if(main.level == 3){
      this.y = 457;
    }
  }

  public int doorX() {
    return this.x;
  }

  public int doorY() {
    return this.y;
  }

  public int doorWidth() {
    return doorImage.width;
  }

  public int doorHeight() {
    return doorImage.height;
  }
}
