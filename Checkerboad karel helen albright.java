/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		if (frontIsBlocked()) {
			makeColumn();
		}
		while (frontIsClear()) {
			oddLevel();
			if (leftIsClear()) {
			evenLevel();	
			}
		} 
	}	
	
	/*
	 * This has karel on the first street move twice and put a beeper down. Karel starts facing 
	 * east and ends facing east at the end of the street.
	 */
	private void oddLevel() {
		putBeeper();
		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		}
	}
	
	/*
	 * When karel is facing east at the end of an odd level this has karel move to the 
	 * next even level. Karel starts the next level facing west.
	 */
	private void moveToNextLevel() {
		turnLeft();
		move();
		turnRight();
		turnAround();
	}
	
	/*
	 * This has karel put beepers on the opposite avenues that beepers are on on odd levels.
	 */
	private void evenLevel() {
		if (beepersPresent()) {
			moveToNextLevel();
			move();
		} else {
			moveToNextLevel();
		  }
		putBeeper();
		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			} 
		}
		if (rightIsClear()) {
				turnRight();
				move();
				turnLeft();
				turnAround();
		}
	}
	
	/*
	 * This is a special condition where the world only has one street and karel starts facing
	 * a wall. 
	 */
	private void makeColumn() {
		turnLeft();
		oddLevel();
	}
}