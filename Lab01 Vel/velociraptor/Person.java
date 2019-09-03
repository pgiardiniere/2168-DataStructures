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

        // if seen velociraptor, try move out of line of sight:
        if (canSeeVelNow) {
            currentDirection = (directionToVel + 5) % 8;
            return (currentDirection);
        }
        // if NO velociraptor in sight, stay (assures first sighting advantage)
        else { return Model.STAY; }

        // OLD / given return, just gives a random direction
        // return random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
    }
}
