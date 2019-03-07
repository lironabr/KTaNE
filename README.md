# KTaNE
Programmed bomb defusal manual for the game "Keep Talking and Nobody Explodes"  
This project is based on the offical manual which can be found in [here](http://www.bombmanual.com/manual/1/pdf/Bomb-Defusal-Manual_1.pdf).  
The project is a command line app.  
## How to use the app
Upon launching the project you will have to enter the bomb description as asked.  
After entering all the information needed a menu will appear-  
in which you will choose the desired module according to it's number in the menu.  

## General Usage Tips
* It does not matter whether you write in capital letters or not in the whole project.  
* In Simon Says module writing the first letter of the color is enough.
* In Complicated Wires module writing the first letter of the property is enough.

## Keypad Dictionary
![ktane_keypad](https://user-images.githubusercontent.com/26528371/53954953-5e45de80-40e0-11e9-887c-f272283731e1.jpg)

## Who's On First
After entering the initial word you will be asked to enter the word in the #n position  
the position is according to the following table:  
1 2  
3 4  
5 6  

## Maze
Upon selecting the maze module the app will ask you to enter the position of the first and second green dots, the source and the target.  
The coordintaes (x y) are according to the following table:  
(1 6) (2 6) (3 6) (4 6) (5 6) (6 6)  
(1 5) (2 5) (3 5) (4 5) (5 5) (6 5)  
(1 4) (2 4) (3 4) (4 4) (5 4) (6 4)  
(1 3) (2 3) (3 3) (4 3) (5 3) (6 3)  
(1 2) (2 2) (3 2) (4 2) (5 2) (6 2)  
(1 1) (2 1) (3 1) (4 1) (5 1) (6 1)  
  
There is no meaning to the order of entering the green dots.  
The source is the white light and the target is the red triangle.  

## Complicated Wires
On each stage you need to enter the special properties of the wire:  
Red/R for red or red&white wire
Blue/B for blue or blue&white wire
Star/S for wire with a star.
Light/L for wire with a light.  
  
For Example:
If the wire has all the properties you should enter:  
```
r b s l (the order does not matter).  
```
If the wire is white with no other properties you should enter:  
```
nothing  
or you could just enter a space.  
```

## Simon Says
In each stage you need to enter only the last color appeared as input for the application.  
Entering the first letter of the color is enough.  
In Example:  
```
B for Blue  
G for Green  
```
## Built With
* [Intellij](https://www.jetbrains.com/idea/)

## Author
* **Liron Abraham** - Software Engineering Student at Ben-Gurion University of the Negev.
