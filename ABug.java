
/**
 * Write a description of class ABug here.
 * 
 * @author: Luis Arreguin.
 * @version: Apr 11, 2014.
 *
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ABug extends Bug {
    private int steps;
    private int sideLength;
    private int section;
    private int flag;
    //private int currentDir;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ABug(int length) {
        steps = 0;
        sideLength = length;
        section = 1;
        flag = 1;
        setDirection(180);

    }

    /**
     * Moves to the next location of the square.
     */
    public void act() {
        if (section<2) {
            if (section == 1 && steps == 0) {setDirection(getDirection()+180);}
            if (steps < (2+flag)*sideLength && canMove()) {
                move();
                steps++;
                //section++;
            }
            else {
                //currentDir = getDirection();
                //setDirection(currentDir-flag*90);
                //turn();
                steps = 0;
                section++;
            }
        }
        else if (section<3) {
            if (section == 2 && steps == 0) {setDirection(getDirection()+flag*90);} //{setDirection(flag*360);}
            if (steps < 2*sideLength && canMove()) {
                move();
                steps++;
                //section++;
            }
               else {
                //currentDir = getDirection();
                //setDirection(-currentDir);
                //turn();
                steps = 0;
                section++;
            }
        }
            else if (section<4) {
            if (section == 3 && steps == 0) {setDirection(getDirection()+flag*90);} //{setDirection(flag*360);}
            if (steps < (2+flag)*sideLength && canMove()) {
                move();
                steps++;
                //section++;
            }
            else {
                //currentDir = getDirection();
                //setDirection(-currentDir);
                //turn();
                steps = 0;
                section++;
            }
        }
        else {
            section = 1;
            flag = -flag;
        }

    }
}
