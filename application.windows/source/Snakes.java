import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class Snakes extends PApplet {

PImage head;
PImage gamebackground;
PImage snakes;
PImage single;
PImage single2;
PImage multi;
PImage multi2;
PImage credits;
PImage credits2;
PImage timelimit;
PImage time1;
PImage time2;
PImage time3;
PImage time4;
PImage gameover;
PImage redwins;
PImage bluewins;
PImage redsnake;
PImage bluesnake;


int x = 300;
int y = 300;
int[] snakesX = new int[100000];
int[] snakesY = new int[100000];
int snakeSize = 50;
float foodx2 = 200;
float foody2 = 500;
int direction = 4;
int xspeed = 4;
int yspeed = 0;
int eat = 0;
float screen = 0;
  int singx = 50;
    int singy = 250;
  int multix = 50;
  int creditsx = 50;
int singtrue = 0;
    int multitrue = 0;
    int creditstrue = 0;
  int menuscreen = 0;
  int player = 0;
  int frame = 0;
  int myframerate = 0;
  int timelimitx = 810;
  int time1x = 850;
  int time2x = 1110;
  int time3x = 850;
  int time4x = 1110;
  float timelimits = 0;
  int sing2x = 5000;
  int multi2x = 5000;
  int credits2x = 5000;
    boolean pick = false;
        int selection = 0;
   float doublex2 = 10000;
   float doubley2 = 10000;
   int doubletrue2 = 1;
   int speedtrue2 = 1;
   float speedboostx2 = 100000;
   float speedboosty2 = 100000;
   int superspeed = 0;
   int superspeedspeed = 0;
   int thespeed = 4;
   int obstaclex = 100;
   int obstacley = 75;
   int obstaclexspeed = 4;
   int obstacleyspeed = 4;
   int obstaclesize = 15;
   int[] obstaclesnakex = new int[100000];
   int[] obstaclesnakey = new int[100000];
   
           int screen9 = 0;

   
   
   
 //===== Multiplayer
 int x1 = 300;
 int y1 = 300;
 int x2 = 300;
 int y2 = 500;
 int[] snake1x = new int[100000];
 int[] snake1y = new int[100000];
 int[] snake2x = new int[100000];
 int[] snake2y = new int[100000];
 int snakeSize1 = 50;
 int snakeSize2 = 50;
 int direction1 = 4;
 int direction2 = 4;
 int x1speed = 4;
 int y1speed = 0;
 int x2speed = 4;
 int y2speed = 0;
 
    float multidoublex2 = 10000;
   float multidoubley2 = 10000;
   int multidoubletrue2 = 1;
   int multispeedtrue2 = 1;
   float multispeedboostx2 = 100000;
   float multispeedboosty2 = 100000;
   int multisuperspeed1 = 0;
      int multisuperspeed2 = 0;

   int multisuperspeedspeed1 = 0;
      int multisuperspeedspeed2 = 0;

   int multithespeed1 = 4;
      int multithespeed2 = 4;







public void setup()
{
size(700,700);
head = loadImage("Slide1.png");
gamebackground = loadImage("gamebackground.jpg");
snakes = loadImage("snakes.png");
single = loadImage("single.png");
single2 = loadImage("single2.png");
multi = loadImage("multi.png");
multi2 = loadImage("multi2.png");
credits = loadImage("credits.png");
credits2 = loadImage("credits2.png");
timelimit = loadImage("timelimit.png");
time1 = loadImage("time1.png");
time2 = loadImage("time2.png");
time3 = loadImage("time3.png");
time4 = loadImage("time4.png");
gameover = loadImage("game_over.png");
redwins = loadImage("redwins.png");
bluewins = loadImage("bluewins2.png");
redsnake = loadImage("redsnake.png");
bluesnake = loadImage("bluesnake.png");


}
public void draw()
{
//  frameRate(30);
 // println(x+"         "+y);


    background(0);
      image(head, 0, 0);
   if((mousePressed==true)&&(screen == 0))
   {
     screen = 1;
   }
   
   if(screen ==1)
   {
     menuscreen();
     
   }

    
    
  
  
  if(screen == 2)
  {
    fill(20,120,170);
    timelimits = timelimits - (1/frameRate);
    image(gamebackground,0,0);
    rect(0,0,700,50);
    fill(190,100,40);
    rect(500,0,200,50);
    fill(0);
    textSize(32);
    text("Time Left:",30,30);
    text(timelimits, 200, 30); 
    textSize(24);
    text("Return to Menu",510,30);
    
    fill(184,14,14);
    rect(400,0,100,50);
    fill(0);
    text(snakeSize,420,30);

    fill(0);
    
    
    if((mouseX>500)&&(mouseX<700)&&(mouseY>0)&&(mouseY<50)&&(mousePressed==true))
    {
      screen = 1;
      snakeSize = 50;
      xspeed = 4;
      yspeed = 0;
//      selection = 0;
//      singtrue = 0;
//      singx = 50;
//      creditsx = 50;
//      multix = 50;
////      screen = 2;
//      timelimitx = 810;
//      time1x = 850;
//      time2x = 1110;
//      time3x = 850;
//      time4x = 1110;
speedboostx2 = 200000;
speedboosty2 = 200000;
doublex2 = 200000;
doubley2 = 200000;

//      
    }
    
    
//  background(255);
  drawSnake();
  snakeFood();
if(snakeSize<3)
{
  //game over
}

println(snakeSize);

      if(timelimits < 0)
      {
        screen = 3;
        println("GAME END!!!!!!");
        
      }
      
      if(snakeSize < 5)
      {
        screen = 8;
      }
      


  }
  
        if(screen == 3)
      {
       gameEnd(); 
        
      }
      
      if(screen == 4)
      {
        multiplayer();
      }
      
      if(screen ==5)
      {
        player1win();
      }
      
      if(screen == 6)
      {
        player2win();
      }
      
      if(screen == 7)
      {
        itsadraw();
      }
      
      if(screen == 8)
      {
        youlose();
      }
      
      if(screen == 9)
      {
        screen9 = screen9 + 1;
          background(20,60,150);
            image(snakes,-300,-100);

          fill(0);
          textSize(36);
          text("Created by: William Meng", 100,300);
          
          text("A Production of Bug Byte", 100,350);
          textSize(12);
          text("- The Loomis Chaffee Computer Club",100,370);
          fill(34,110,3);
    rect(500,700,200,50);
           textSize(66);
           
  fill(180,35,133);
  text("Return to Main Menu",20,600);
  if((mouseY>500)&&(mousePressed == true)&&(screen9 > 10))
  {
      screen = 1;
    screen9 = 0;
  }
          
        
        
      }

}

public void drawSnake()
{
   snakeMove();
  x = x + xspeed;
  y = y + yspeed;

  snakesX[0] = x;
  snakesY[0] = y;
  noStroke();
  
       for(int i = 1; i < snakeSize; i++){
       if(x == snakesX[i] && y== snakesY[i]){
          println("eat"); 
          snakeSize = i;
      }
   }
//  fill(255,0,0);
//  ellipse(x,y,20,20);


  for(int i = 0; i < snakeSize; i++) {
    int x = snakesX[i];
    int y = snakesY[i];
    fill(0,0,0);
    ellipse(x,y,20,20);
  }
  fill(150,0,0);
  ellipse(x,y,20,20);
  
  for(int i = snakeSize+6; i > 0; i--){
    snakesX[i] = snakesX[i-1];
    snakesY[i] = snakesY[i-1];
  }
  
  
  obstaclex = obstaclex + obstaclexspeed;
  obstacley = obstacley + obstacleyspeed;
  
  obstaclesnakex[0] = obstaclex;
  obstaclesnakey[0] = obstacley;
  
    for(int r = 0; r < obstaclesize; r++) {
    int x = obstaclesnakex[r];
    int y = obstaclesnakey[r];
    fill(0,0,0);
    ellipse(x,y,20,20);
  }
  
    for(int r = obstaclesize+6; r > 0; r--){
    obstaclesnakex[r] = obstaclesnakex[r-1];
    obstaclesnakey[r] = obstaclesnakey[r-1];
  }
  
  fill(200);
      ellipse(obstaclex,obstacley,20,20);
      
if(obstaclex > 700)
{
  obstaclexspeed = obstaclexspeed * -1;
}
  
  if(obstaclex < 0)
{
  obstaclexspeed = obstaclexspeed * -1;
}
if(obstacley > 700)
{
  obstacleyspeed = obstacleyspeed * -1;
}
if(obstacley < 50)
{
  obstacleyspeed = obstacleyspeed * -1;
}

       for(int i = 1; i < snakeSize; i++){
       if(abs(obstaclex - snakesX[i]) < 2 && abs(obstacley - snakesY[i]) < 2){
          println("eat"); 
          snakeSize = i;
      }
   }
   
          for(int r = 1; r < obstaclesize; r++){
       if(abs(x - obstaclesnakex[r]) < 2 && abs(y- obstaclesnakey[r])<2){
          println("eat"); 
          snakeSize = 0;
      }
   }
  
}

public void snakeMove()
{
  frame = frame + 1;
  
//  if (key == CODED) { 
//    if ((keyCode == UP)&&(direction != 2)&&(frame >myframerate)) {
//      yspeed = -4;
//      xspeed = 0;
//      direction = 1;
//      frame = 0;
//      println("UUUUUUUUUUUUUUUPPPPPPPPPPPPPP");
//    }
//
//
//
//    else if ((keyCode == DOWN)&&(direction != 1)&&(frame > myframerate)) {
// yspeed = 4;
// xspeed = 0;
// direction = 2;
// frame = 0;
// println("DDDDDDDDDOOOOOOOOOOWWWWWWWWWNNNNNNNNN");
//    }
//
//      
//
//    else if ((keyCode == LEFT)&&(direction !=4)&&(frame>myframerate)) {
//      xspeed = -4;
//      yspeed = 0;
//      direction = 3;
//      frame = 0;
//      println("LLLLLLLLLLLEEEEEEEEEFFFFFFFTTTTTTTT");
//    }
//
//      
//      
//
//    else if ((keyCode == RIGHT)&&(direction !=3)&&(frame >myframerate)) {
//      xspeed = 4;
//      yspeed = 0;
//      direction = 4;
//      frame = 0;
//      println("RRRRRRRIIIIIIIGGGGGHHHHHHTTTTTT");
//    }
    
    


if(x>700)
{
  x = 0;
  snakeSize = snakeSize/2;
}
if(y > 700)
{
  y= 50;
    snakeSize = snakeSize/2;

}
if(x<0)
{
  x = 700;
    snakeSize = snakeSize/2;

}
if(y<50)
{
  y = 700;
    snakeSize = snakeSize/2;

}

}

public void snakeFood()
{
    float foodx = foodx2;
  float foody = foody2;  
  
  //================Double Speed ====================
  
  int speedtrue = speedtrue2;
  
  float speedboostx = speedboostx2;
  float speedboosty = speedboosty2;
  
  if(speedtrue == 1)
  {
    float speednumber = random(0,2000);
    
    if(speednumber > 1998)
    {
      
      speedboostx2 = random(20,650);
      speedboosty2 = random(70,650);
      speedtrue2 = 2;
    }
    else
    {
      speedboostx2 = 100000;
      speedboosty2 = 100000;
    }
  }
  
      if(((sqrt((sq((x+10)-(speedboostx+10))+(sq((y+10)-(speedboosty+10))))))<20)&&(speedtrue == 2))
  {
        superspeedspeed = 0;
    superspeed = 1;
    speedtrue2 = 1;
  }
  
  if(superspeed == 1)
  {
    superspeedspeed = superspeedspeed + 1;
    if(superspeedspeed < 300)
    {
      thespeed = 8;
      
    }
    else
    {
      thespeed = 4;
    }
  }

  
    fill(255,0,0);
    ellipse(speedboostx,speedboosty,20,20);

  
  //================Double Food =========
  int doubletrue = doubletrue2;
  
  float doublex = doublex2;
  float doubley = doubley2;
  
//  println(doublenumber);
  
  if(doubletrue == 1)
  {
    float doublenumber = random(0,2000);
  
    println(doublenumber);

  if(doublenumber > 1998)
  {
    doublex2 = random(20,650);
    doubley2 = random(70,650);
    doubletrue2 = 2;
  }
  else
  {
    doublex2 = 10000;
    doubley2 = 10000;
  }
  
  
  
  
  }
  
    if(((sqrt((sq((x+10)-(doublex+10))+(sq((y+10)-(doubley+10))))))<20)&&(doubletrue == 2))
  {
    snakeSize=snakeSize * 2;
    doubletrue2 = 1;
  }

  
    fill(0,255,0);
    ellipse(doublex,doubley,20,20);

  //===============Normal Food =====================
  if(((sqrt((sq((x+10)-(foodx+10))+(sq((y+10)-(foody+10))))))<20)&&(eat == 0))
  {
    snakeSize=snakeSize + 7;
    eat = 1;
  }
  if(eat == 1)
  {
     foodx2 = random(20,650);
   foody2 = random(70,650);
  eat = 0;
  }
  
  fill(255,0,255);
    ellipse(foodx,foody,20,20);
}

public void menuscreen()
{

  menuscreen = menuscreen + 1;
  background(20,60,150);
  image(snakes,-300,-100);
//  rect(130,230,440,140);
//  rect(150,250,400,100);
  image(single,singx,singy);
  image(multi,multix,400);
  image(credits,creditsx,550);
//  println(mouseX);
//  println(mouseY);
image(timelimit,timelimitx,200);
image(time1,time1x,300);
image(time2,time2x,300);
image(time3,time3x,500);
image(time4,time4x,500);
    image(single2,sing2x,250);
        image(multi2,multi2x,400);
            image(credits2,credits2x,550);




//println(singx);
  
  if(selection == 0 )
  {
    
    
    
  if((mouseX>50)&&(mouseX<586)&&(mouseY>250)&&(mouseY<340)&&(singtrue == 0)&&(pick == false))
  {
    sing2x = 50;
  }
  else
  {
    sing2x = 5000;
  }
      if((mouseX>50)&&(mouseX<586)&&(mouseY>400)&&(mouseY<490)&&(multitrue == 0)&&(pick == false))
  {
    multi2x = 50;
  }
  else
  {
    multi2x = 5000;
  }
    if((mouseX>50)&&(mouseX<686)&&(mouseY>550)&&(mouseY<640)&&(creditstrue == 0)&&(pick == false))
  {
    credits2x = 50;
  }
  else
  {
    credits2x = 5000;
  }

    if((menuscreen>50)&&(mouseX>50)&&(mouseX<586)&&(mouseY>250)&&(mouseY<340)&&(mousePressed == true))
  {
    println("in");
  //  singx = singx + 1;
    singtrue = 1;
    pick = true;
  }
  
        if((menuscreen>50)&&(mouseX>50)&&(mouseX<586)&&(mouseY>400)&&(mouseY<490)&&(mousePressed == true))
  {
    pick = true;
    multitrue = 1;
  }
  if((menuscreen>50)&&(mouseX>50)&&(mouseX<586)&&(mouseY>550)&&(mouseY<640)&&(mousePressed == true))
  {
    screen = 9;
  }
  
  
  if((singtrue == 1)||(multitrue == 1))
  {
    singx = singx - 10;
    creditsx = creditsx - 10;
    multix = multix - 10;
    timelimitx = timelimitx - 10;
    time1x = time1x - 10;
    time2x = time2x - 10;
    time3x = time3x - 10;
    time4x = time4x - 10;
    
    
    if(singx < - 700)
    {
      singx = -700;
      creditsx = -700;
      multix = -700;
//      screen = 2;
      timelimitx = 60;
      time1x = 100;
      time2x = 370;
      time3x = 100;
      time4x = 370;
      selection = 1;

    }
  }
  else
  {

//      singx = 50;
//      creditsx = 50;
//      multix = 50;
//      timelimitx = 810;
//      time1x = 850;
//      time2x = 1110;
//      time3x = 850;
//      time4x = 1110;
  }
  
  
  }
    
    if((selection == 1)&&(singtrue == 1))
    {
            singx = -700;
      creditsx = -700;
      multix = -700;
      

      println(selection);
      if((mouseX > 100)&&(mouseX < 304)&&(mouseY > 300)&&(mouseY < 470)&&(mousePressed == true))
      {
        println("hghdfghfdh");
        timelimits = 30;
        screen = 2;
        x = 300;
        y = 300;
        snakeSize = 50;
        reset();
      
      }
      
            if((mouseX > 370)&&(mouseX < 570)&&(mouseY > 300)&&(mouseY < 470)&&(mousePressed == true))
      {
        println("hghdfghfdh");
        timelimits = 60;
        screen = 2;
        x = 300;
        y = 300;
        snakeSize = 50;
        reset();
      
      }
            if((mouseX > 100)&&(mouseX < 304)&&(mouseY > 500)&&(mouseY < 670)&&(mousePressed == true))
      {
        println("hghdfghfdh");
        timelimits = 120;
        screen = 2;
        x = 300;
        y = 300;
        snakeSize = 50;
        reset();
      
      }
            if((mouseX > 370)&&(mouseX < 570)&&(mouseY > 500)&&(mouseY < 670)&&(mousePressed == true))
      {
        println("hghdfghfdh");
        timelimits = 300;
        screen = 2;
        x = 300;
        y = 300;
        snakeSize = 50;
        reset();
      
      }
      
      
      
      
    }
    
    if((selection == 1)&&(multitrue == 1))
    {
       singx = -700;
      creditsx = -700;
      multix = -700;
      

      println(selection);
      if((mouseX > 100)&&(mouseX < 304)&&(mouseY > 300)&&(mouseY < 470)&&(mousePressed == true))
      {
        println("hghdfghfdh");
        timelimits = 30;
        screen = 4;
        x1 = 300;
        y1 = 300;
        x2 = 300;
        y2 = 500;
        snakeSize1 = 50;
        snakeSize2 = 50;
        x1speed = 4;
      y1speed = 0;
      x2speed = 4;
      y2speed = 0;
        reset();
      
      }
      
            if((mouseX > 370)&&(mouseX < 570)&&(mouseY > 300)&&(mouseY < 470)&&(mousePressed == true))
      {
        println("hghdfghfdh");
        timelimits = 60;
        screen = 4;
        x1 = 300;
        y1 = 300;
        x2 = 300;
        y2 = 500;
        snakeSize1 = 50;
        snakeSize2 = 50;
        x1speed = 4;
      y1speed = 0;
      x2speed = 4;
      y2speed = 0;
        reset();
      
      }
            if((mouseX > 100)&&(mouseX < 304)&&(mouseY > 500)&&(mouseY < 670)&&(mousePressed == true))
      {
        println("hghdfghfdh");
        timelimits = 120;
        screen = 4;
        x1 = 300;
        y1 = 300;
        x2 = 300;
        y2 = 500;
        snakeSize1 = 50;
        snakeSize2 = 50;
        x1speed = 4;
      y1speed = 0;
      x2speed = 4;
      y2speed = 0;
        reset();
      
      }
            if((mouseX > 370)&&(mouseX < 570)&&(mouseY > 500)&&(mouseY < 670)&&(mousePressed == true))
      {
        println("hghdfghfdh");
        timelimits = 300;
        screen = 4;
        x1 = 300;
        y1 = 300;
        x2 = 300;
        y2 = 500;
        snakeSize1 = 50;
        snakeSize2 = 50;
        x1speed = 4;
      y1speed = 0;
      x2speed = 4;
      y2speed = 0;
        reset();
      
      }
      
      
      
      
    }

  
  
}


public void keyPressed() {
    if (key == CODED) { 
    if ((keyCode == UP)&&(direction != 2)&&(frame >myframerate)) {
      yspeed = -thespeed;
      xspeed = 0;
      direction = 1;
      frame = 0;
      println("UUUUUUUUUUUUUUUPPPPPPPPPPPPPP");
    }



    else if ((keyCode == DOWN)&&(direction != 1)&&(frame > myframerate)) {
 yspeed = thespeed;
 xspeed = 0;
 direction = 2;
 frame = 0;
 println("DDDDDDDDDOOOOOOOOOOWWWWWWWWWNNNNNNNNN");
    }

      

    else if ((keyCode == LEFT)&&(direction !=4)&&(frame>myframerate)) {
      xspeed = -thespeed;
      yspeed = 0;
      direction = 3;
      frame = 0;
      println("LLLLLLLLLLLEEEEEEEEEFFFFFFFTTTTTTTT");
    }

      
      

    else if ((keyCode == RIGHT)&&(direction !=3)&&(frame >myframerate)) {
      xspeed = thespeed;
      yspeed = 0;
      direction = 4;
      frame = 0;
      println("RRRRRRRIIIIIIIGGGGGHHHHHHTTTTTT");
    }
    
    
    
    
}

println(direction1);

if(((key == 'w'||key == 'W'))&&(direction1 != 2))
{
      y1speed = -multithespeed1;
      x1speed = 0;
      direction1 = 1;

}
if(((key == 's')||(key == 'S'))&&(direction1 != 1))
{
 y1speed = multithespeed1;
 x1speed = 0;
 direction1 = 2;

}
if(((key == 'a')||(key == 'A'))&&(direction1 != 4))
{
      x1speed = -multithespeed1;
      y1speed = 0;
      direction1 = 3;
}

if(((key == 'd')||(key == 'D'))&&(direction1 != 3))
{
      x1speed = multithespeed1;
      y1speed = 0;
      direction1 = 4;

}

if(((key == 'i'||key == 'I'))&&(direction2 !=2))
{
      y2speed = -multithespeed2;
      x2speed = 0;
      direction2 = 1;

}
if(((key == 'k')||(key == 'K'))&&(direction2 != 1))
{
 y2speed = multithespeed2;
 x2speed = 0;
 direction2 = 2;

}
if(((key == 'j')||(key == 'J'))&&(direction2 != 4))
{
      x2speed = -multithespeed2;
      y2speed = 0;
      direction2 = 3;
}

if(((key == 'l')||(key == 'L'))&&(direction2 != 3))
{
      x2speed = multithespeed2;
      y2speed = 0;
      direction2 = 4;

}

}

public void gameEnd()
{

  background(56,123,198);
  image(gameover,-150,-100);
  textSize(40);
  text("Final Score:",220,350);
  text(snakeSize, 450,350);
  textSize(66);
  fill(180,30,110);
  text("Return to Main Menu",20,600);
  if((mouseY>500)&&(mousePressed == true))
  {
      screen = 1;
      snakeSize = 50;
      snakeSize1 = 50;
      snakeSize2 = 50;
      xspeed = 4;
      yspeed = 0;
    
  }
  obstaclex = 100;
  obstacley = 75;
  obstaclexspeed = 4;
  obstacleyspeed = 4;
  speedboostx2 = 200000;
  speedboosty2 = 200000;
  doublex2 = 200000;
  doubley2 = 200000;
  
  
}

public void reset()
{
  selection = 0;
  singtrue = 0;
  multitrue = 0;
      singx = 50;
      creditsx = 50;
      multix = 50;
      timelimitx = 810;
      time1x = 850;
      time2x = 1110;
      time3x = 850;
      time4x = 1110;  
      pick = false;
menuscreen = 0;
  
}

public void multiplayer()
{
      fill(20,120,170);
    timelimits = timelimits - (1/frameRate);
    image(gamebackground,0,0);
    rect(0,0,700,50);
    fill(190,100,40);
    rect(500,0,200,50);
    fill(0);
    textSize(32);
    text("Time Left:",30,30);
    text(timelimits, 200, 30); 
    textSize(24);
    text("Return to Menu",510,30);

    fill(0);
    
    if((mouseX>500)&&(mouseX<700)&&(mouseY>0)&&(mouseY<50)&&(mousePressed==true))
    {
      screen = 1;
      snakeSize = 50;  
      snakeSize1 = 50;
      snakeSize2 = 50;
      x1speed = 4;
      y1speed = 0;
      x2speed = 4;
      y2speed = 0;
      multispeedboostx2 = 200000;
multispeedboosty2 = 200000;
multidoublex2 = 200000;
multidoubley2 = 200000;
    }
  
if(x1>700)
{
  x1 = 0;
  snakeSize1 = snakeSize1/2;
}
if(y1 > 700)
{
  y1= 50;
    snakeSize1 = snakeSize1/2;

}
if(x1<0)
{
  x1 = 700;
    snakeSize1 = snakeSize1/2;

}
if(y1<50)
{
  y1 = 700;
    snakeSize1 = snakeSize1/2;

}

if(x2>700)
{
  x2 = 0;
  snakeSize2 = snakeSize2/2;
}
if(y2 > 700)
{
  y2= 50;
    snakeSize2 = snakeSize2/2;

}
if(x2<0)
{
  x2 = 700;
    snakeSize2 = snakeSize2/2;

}
if(y2<50)
{
  y2 = 700;
    snakeSize2 = snakeSize2/2;

}

println(snakeSize1);
  
  x1 = x1 + x1speed;
  y1 = y1 + y1speed;
  snake1x[0] = x1;
  snake1y[0] = y1;
  x2 = x2 + x2speed;
  y2 = y2 + y2speed;
  snake2x[0] = x2;
  snake2y[0] = y2;
  noStroke();
  
       for(int i = 1; i < snakeSize1; i++){
       if(x1 == snake1x[i] && y1== snake1y[i]){
        //  println("eat"); 
          snakeSize1 = i;
      }
      
   }
   

//  fill(255,0,0);
//  ellipse(x,y,20,20);


  for(int i = 0; i < snakeSize1; i++) {
    int x1 = snake1x[i];
    int y1 = snake1y[i];
    fill(0,0,0);
    ellipse(x1,y1,20,20);
  }
  fill(150,0,0);
  ellipse(x1,y1,20,20);
  
  for(int i = snakeSize1 + 6; i > 0; i--){
    snake1x[i] = snake1x[i-1];
    snake1y[i] = snake1y[i-1];
  }
    
    //======snake 2 =======
    
    
           for(int r = 1; r < snakeSize2; r++){
       if(x2 == snake2x[r] && y2== snake2y[r]){
          println("eat"); 
          snakeSize2 = r;
      }
   }
//  fill(255,0,0);
//  ellipse(x,y,20,20);


  for(int r = 0; r < snakeSize2; r++) {
    int x2 = snake2x[r];
    int y2 = snake2y[r];
    fill(255,255,255);
    ellipse(x2,y2,20,20);
  }
  fill(0,0,150);
  ellipse(x2,y2,20,20);
  
  for(int r = snakeSize2 + 6; r > 0; r--){
    snake2x[r] = snake2x[r-1];
    snake2y[r] = snake2y[r-1];
}
    
    
      for(int i = 1; i < snakeSize1; i++){
       if(x2 == snake1x[i] && y2== snake1y[i]){
        //  println("eat"); 
          snakeSize1 = i;
      } 
   }
    
          for(int r = 1; r < snakeSize2; r++){
       if(x1 == snake2x[r] && y1== snake2y[r]){
        //  println("eat"); 
          snakeSize2 = r;
      } 
   }
    
    
    //============ FOOD===============
    
    
      int multispeedtrue = multispeedtrue2;
  
  float multispeedboostx = multispeedboostx2;
  float multispeedboosty = multispeedboosty2;
  
  if(multispeedtrue == 1)
  {
    float multispeednumber = random(0,2000);
    
    if(multispeednumber > 1998)
    {
      
      multispeedboostx2 = random(20,650);
      multispeedboosty2 = random(70,650);
      multispeedtrue2 = 2;
    }
    else
    {
      multispeedboostx2 = 100000;
      multispeedboosty2 = 100000;
    }
  }
  
      if(((sqrt((sq((x1+10)-(multispeedboostx+10))+(sq((y1+10)-(multispeedboosty+10))))))<20)&&(multispeedtrue == 2))
  {
        multisuperspeedspeed1 = 0;
    multisuperspeed1 = 1;
    multispeedtrue2 = 1;
  }
  
  if(multisuperspeed1 == 1)
  {
    multisuperspeedspeed1 = multisuperspeedspeed1 + 1;
    if(multisuperspeedspeed1 < 300)
    {
      multithespeed1 = 8;
      
    }
    else
    {
      multithespeed1 = 4;
    }
  }
  
  if(((sqrt((sq((x2+10)-(multispeedboostx+10))+(sq((y2+10)-(multispeedboosty+10))))))<20)&&(multispeedtrue == 2))
  {
        multisuperspeedspeed2 = 0;
    multisuperspeed2 = 1;
    multispeedtrue2 = 1;
  }
  
  if(multisuperspeed2 == 1)
  {
    multisuperspeedspeed2 = multisuperspeedspeed2 + 1;
    if(multisuperspeedspeed2 < 300)
    {
      multithespeed2 = 8;
      
    }
    else
    {
      multithespeed2 = 4;
    }
  }


  
    fill(255,0,0);
    ellipse(multispeedboostx,multispeedboosty,20,20);

  
  //================Double Food =========
  int multidoubletrue = multidoubletrue2;
  
  float multidoublex = multidoublex2;
  float multidoubley = multidoubley2;
  
//  println(doublenumber);
  
  if(multidoubletrue == 1)
  {
    float multidoublenumber = random(0,2000);
  
    println(multidoublenumber);

  if(multidoublenumber > 1998)
  {
    multidoublex2 = random(20,650);
    multidoubley2 = random(70,650);
    multidoubletrue2 = 2;
  }
  else
  {
    multidoublex2 = 10000;
    multidoubley2 = 10000;
  }
  
  
  
  
  }
  
    if(((sqrt((sq((x1+10)-(multidoublex+10))+(sq((y1+10)-(multidoubley+10))))))<20)&&(multidoubletrue == 2))
  {
    snakeSize1=snakeSize1 * 2;
    multidoubletrue2 = 1;
  }
   if(((sqrt((sq((x2+10)-(multidoublex+10))+(sq((y2+10)-(multidoubley+10))))))<20)&&(multidoubletrue == 2))
  {
    snakeSize2=snakeSize2 * 2;
    multidoubletrue2 = 1;
  }

  
    fill(0,255,0);
    ellipse(multidoublex,multidoubley,20,20);

    
   float foodx = foodx2;
  float foody = foody2;  
  if(((sqrt((sq((x1+10)-(foodx+10))+(sq((y1+10)-(foody+10))))))<20)&&(eat == 0))
  {
    snakeSize1=snakeSize1 + 7;
    eat = 1;
  }
  
   if(((sqrt((sq((x2+10)-(foodx+10))+(sq((y2+10)-(foody+10))))))<20)&&(eat == 0))
  {
    snakeSize2=snakeSize2 + 7;
    eat = 1;
  }
  
  
  if(eat == 1)
  {
     foodx2 = random(20,650);
   foody2 = random(70,650);
  eat = 0;
  }
  
  fill(255,0,255);
    ellipse(foodx,foody,20,20);
    
 
    println(direction1);
    
    
    if((timelimits < 0) && (snakeSize1 > snakeSize2))
    {
      screen = 5;
    }
    
    if((timelimits < 0) && (snakeSize2 > snakeSize1))
    {
      screen = 6;
    }
    
    if((timelimits < 0)&&(snakeSize2 == snakeSize1))
    {
      screen = 7;
    } 
  
}


public void player1win()
{
   background(0);
   image(redwins,-20,-100);
  textSize(40);
  text("Final Score:",220,300);
  text("Red", 150,420);
  text("Blue",500,420);
  text(snakeSize1, 150,470);
  text(snakeSize2,500,470);
  image(bluesnake,425,350);
  image(redsnake,75,350);
  textSize(66);
  fill(0,35,133);
  rect(500,700,200,50);
  fill(180,30,110);
  text("Return to Main Menu",20,600);
  if((mouseY>500)&&(mousePressed == true))
  {
      screen = 1;
      snakeSize = 50;
      snakeSize1 = 50;
      snakeSize2 = 50;
      xspeed = 4;
      yspeed = 0;
      multispeedboostx2 = 200000;
      multispeedboosty2 = 200000;
      multidoublex2 = 2000000;
      multidoubley2 = 2000000;
      multithespeed1 = 4;
      multithespeed2 = 4;
      
    
  }
  
  
}

public void player2win()
{
  background(6,72,143);
  image(bluewins,0,0);
  textSize(40);
  fill(0);
  text("Final Score:",220,300);
  text("Red", 150,420);
  text("Blue",500,420);
  text(snakeSize1, 150,470);
  text(snakeSize2,500,470);
  image(bluesnake,425,350);
  image(redsnake,75,350);
  textSize(66);
    fill(34,110,3);
    rect(500,700,200,50);
  fill(180,30,110);
  fill(0);
  text("Return to Main Menu",20,600);
  if((mouseY>500)&&(mousePressed == true))
  {
      screen = 1;
      snakeSize = 50;
      snakeSize1 = 50;
      snakeSize2 = 50;
      xspeed = 4;
      yspeed = 0;
      multispeedboostx2 = 200000;
      multispeedboosty2 = 200000;
      multidoublex2 = 2000000;
      multidoubley2 = 2000000;
      multithespeed1 = 4;
      multithespeed2 = 4;
    
  }
  
  
}

public void itsadraw()
{
    background(56,123,198);
  image(gameover,-150,-100);
  textSize(40);
  text("Its a Draw!",240,350);
  textSize(66);
  fill(180,30,110);
  text("Return to Main Menu",20,600);
  if((mouseY>500)&&(mousePressed == true))
  {
      screen = 1;
      snakeSize = 50;
      snakeSize1 = 50;
      snakeSize2 = 50;
      xspeed = 4;
      yspeed = 0;
      multispeedboostx2 = 200000;
      multispeedboosty2 = 200000;
      multidoublex2 = 2000000;
      multidoubley2 = 2000000;
      multithespeed1 = 4;
      multithespeed2 = 4;
    
  }
  
  
}

public void youlose()
{
  background(56,123,198);
  image(gameover,-150,-100);
  textSize(52);
  text("You Lose!!!",220,350);
 // text(snakeSize, 450,350);
  textSize(66);
  fill(180,35,133);
  text("Return to Main Menu",20,600);
  if((mouseY>500)&&(mousePressed == true))
  {
      screen = 1;
      snakeSize = 50;
      snakeSize1 = 50;
      snakeSize2 = 50;
      xspeed = 4;
      yspeed = 0;
    
  }
  
  
}
  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "Snakes" });
  }
}
