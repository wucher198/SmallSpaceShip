package pl.myjava.smallspaceship.enums;

/**
 * Created by anonim on 28.01.17.
 */
public enum Messages {
    NO_DRAW_METHOD("No draw method defined!!!"),
    NO_MOVE_METHOD("No move method defined!!!"),
    UNDEFINED_PARAMETER("Unknown parameter: %s!!!"),
    WORKING_DIRECTORY("Working Directory = %s");

    private String message;

    Messages(String message) {
        this.message = message;
    }
}
