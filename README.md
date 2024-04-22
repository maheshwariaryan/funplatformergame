# Java Platformer Game Overview

Welcome to the Java Platformer Game, an interactive and engaging game developed entirely in Java, utilizing the PApplet library for its graphical user interface. This game offers a fun and immersive experience for players of all ages.

The game offers Collision Physics and Gravity Physics. 

## Key Features

- **Programming Language**: Java.
- **Graphics Library**: PApplet.
- **Game Genre**: Platformer - challenging levels that test your timing and precision.

## Gravity Physics

A vertical velocity component is added to the y value of the player.
When the user presses 'w' to jump, the vertical velocity is set to 50. Gravity constantly decriments the value of vertical velocity by 5 each frame causing the player to retard. When the vertical velocity is 0, the user has now reached the vertex of the parabolic jumping trajectory. Gravity now further decreases vertical velocity causing the player to accelerate towards the ground.

In the code, since y is 0 at the top of the screen, all numbers have switched signs (negative to go up, positive to go down). The screen is the fourth quadrant.

## Disclaimer

The character and door sprites used in this game are artistic interpretations inspired by Among Us and Minecraft, respectively, and are not official assets from these games. The use of these inspired sprites is intended for a non-commercial, educational project designed to showcase programming skills and creativity.

Thank you for your interest in my Java Platformer Game. Dive in and enjoy a world of challenges and adventures!

![Platformer Game Screenshot](https://drive.google.com/uc?export=view&id=12Utwzvv1qh76HZmcB6cJkozFvi8okKzn)
![Platformer Game Screenshot](https://drive.google.com/uc?export=view&id=1UUP2_3U4QhN4j2Ddzn0_B-XuRxb8z-Hs)
