/*
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
public class SBug extends Bug {
    private int steps;
    private int sideLength;
    private int section;
    private int flag;
    private int currentDir;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public SBug(int length) {
        steps = 0;
        sideLength = length;
        section = 1;
        flag = 1;

    }

    /**
     * Moves to the next location of the square.
     */
    public void act() {
        if (section<5) {
            if (section == 1) {setDirection(-flag*90);}
            if (steps < sideLength && canMove()) {
                move();
                steps++;
                //section++;
            }
            else {
                currentDir = getDirection();
                setDirection(currentDir-45);
                //turn();
                steps = 0;
                section++;
            }
        }
        else if (section<10) {
            if (section == 5) {setDirection(flag*90);}
            if (steps < sideLength && canMove()) {
                move();
                steps++;
                //section++;
            }
            else {
                currentDir = getDirection();
                setDirection(currentDir+45);
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
