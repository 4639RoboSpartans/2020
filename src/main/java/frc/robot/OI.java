package frc.robot;

import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {
    private final Joystick[] sticks;
    private final Button[][] buttons;

    public OI() {
        buttons = new JoystickButton[NUMBER_OF_CONTROLLERS][10]; //10 buttons
        sticks = new Joystick[NUMBER_OF_CONTROLLERS];

        for (int i = 0; i < NUMBER_OF_CONTROLLERS; i++) {
            sticks[i] = new Joystick(i);
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JoystickButton(sticks[i], j);
            }
        }
    }

    /**
     * Creates a deadzone for joysticks, the controllers sticks are a little loose
     * and so there is a margin of error for where they should be considered
     * "neutral/not pushed"
     *
     * @param value
     *            Double between -1 and 1 to be deadzoned
     * @return The deadzoned value
     */
    private static double deadzone(double value) {
        // whenever the controller moves LESS than the magic number, the
        // joystick is in the loose position so return zero - as if the
        // joystick was not moved
        if (Math.abs(value) < Constants.DEADZONE_VALUE) {
            return 0;
        }

        // When the joystick is greater than the margin of error, scale the value so
        // that the point right after the deadzone
        // is 0 so the robot does not jerk forward when it passes the deadzone
        // It properly scales the controls to the new workable zone
        return (value / Math.abs(value)) * ((Math.abs(value) - DEADZONE_VALUE) / (1 - DEADZONE_VALUE));
    }

    public double getAxis(int joystick, Axes axis) {
        double value = sticks[joystick].getRawAxis(axis.getValue());
        if (axis == Axes.LEFT_STICK_Y || axis == Axes.RIGHT_STICK_Y)
            return deadzone(-value);
        else
            return deadzone(value);
    }

    public Button getButton(int joystick, Buttons button) {
        return buttons[joystick][button.getValue()];
    }
}
