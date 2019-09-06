public class Person extends Animal {

    // instance vars
    private boolean canSeeVelNow = false;
    private int directionToVel;
    private int currentDirection;


    public Person(Model model, int row, int column) {
        super(model, row, column);
        currentDirection = Model.MIN_DIRECTION;
    }

    // person movement, 1 move per turn
    int decideMove() {
        canSeeVelNow = false;
        // Look in straight line down all 8 adjacent tiles to see Velociraptor
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.VELOCIRAPTOR) {
                canSeeVelNow = true;
                directionToVel = i;
            }
        }

        // if seen Velociraptor, try to break line of sight.
        if (canSeeVelNow) {
            // Try 1st position.
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
            // Else try 6th position. In trouble if this actually executes --- mainly here as it's necessary for program compilation
            else {
                currentDirection = ((directionToVel + 1) % 8);
                return (currentDirection);
            }
        }
        // No vel sighting
        else { return Model.STAY; }
    }
}
