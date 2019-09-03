public class Person extends Animal {

    // instance vars
    private boolean haveSeenVel = false;
    private boolean canSeeVelNow = false;
    private int distanceToVel;
    private int directionToVel;
    private int currentDirection;


    public Person(Model model, int row, int column) {
        super(model, row, column);
        currentDirection = Model.random(Model.MIN_DIRECTION,
                Model.MAX_DIRECTION);
    }

    // person movement, 1 move per turn
    int decideMove() {
        canSeeVelNow = false;

        // Look in straight line down all 8 adjacent tiles to see things (velociraptor)
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.VELOCIRAPTOR) {
                canSeeVelNow = haveSeenVel = true;
                directionToVel = i;
                distanceToVel = distance(i);
            }
        }

        // if seen velociraptor, Try to move away from line of sight.
        if (canSeeVelNow) {
            // Try 1st position
            if (canMove((directionToVel + 5) % 8)) {
                currentDirection = ((directionToVel + 5) % 8);
                return currentDirection;
            }
            // Try 2nd position:
            if (canMove((directionToVel + 3) % 8)) {
                currentDirection = ((directionToVel + 3) % 8);
                return currentDirection;
            }
            // Try 3rd position:
            if (canMove((directionToVel + 4) % 8)) {
                currentDirection = ((directionToVel + 4) % 8);
                return currentDirection;
            }
            // Try 4th position:
            if (canMove((directionToVel + 6) % 8)) {
                currentDirection = ((directionToVel + 6) % 8);
                return currentDirection;
            }
            // Try 5th position:
            if (canMove((directionToVel + 2) % 8)) {
                currentDirection = ((directionToVel + 2) % 8);
                return currentDirection;
            }
            // Else do 6th position. In trouble if this actually executes --- mainly here as it's necessary for program compilation
            else {
                currentDirection = ((directionToVel + 1) % 8);
                return (currentDirection);
            }
            /*  // first attempt - not very clean, minus operator would not work (based on Java modulo negatives)
            *   if (!canMove(currentDirection)) {
            *       if (canMove(currentDirection+6) % 8) return (currentDirection-2) % 8);
            *       if (canMove(currentDirection+7) % 8) return (currentDirection-1);
            *       if (canMove(currentDirection+1)) return (currentDirection+1);
            *       if (canMove(currentDirection-3)) return (currentDirection-3);
            *   }
            */

        }
        // if NO velociraptor in sight, stay (assures first sighting advantage)
        else { return Model.STAY; }

        // OLD / given return, just gives a random direction
        // return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
    }
}
