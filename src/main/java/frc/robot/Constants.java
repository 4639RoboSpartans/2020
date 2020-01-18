/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.I2C;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double DEADZONE_VALUE = 0.01;
    public static final int NUMBER_OF_CONTROLLERS = 2;

    enum Axes {
        LEFT_STICK_X(0),
        LEFT_STICK_Y(1),
        LEFT_TRIGGER(2),
        RIGHT_TRIGGER(3),
        RIGHT_STICK_X(4),
        RIGHT_STICK_Y(5);

        private final int value;

        private Axes(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    enum Buttons {
        A_BUTTON(0),
        B_BUTTON(1),
        X_BUTTON(2),
        Y_BUTTON(3),
        LEFT_BUMPER(4),
        RIGHT_BUMPER(5),
        BACK_BUTTON(6),
        START_BUTTON(7),
        LEFT_STICK(8),
        RIGHT_STICK(9);

        private final int value;

        private Buttons(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }
}
