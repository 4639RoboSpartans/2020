package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.ColorSensorV3;

public class ColorWheelSys extends SubsystemBase {
    private final I2C.Port i2cPort = I2C.Port.kOnboard;

    private final ColorSensorV3 m_colorSensor;

    public ColorWheelSys() {
        m_colorSensor = new ColorSensorV3(i2cPort);
    }

    public ColorSensorV3 getColorSensor() {
        return m_colorSensor;
    }
}
