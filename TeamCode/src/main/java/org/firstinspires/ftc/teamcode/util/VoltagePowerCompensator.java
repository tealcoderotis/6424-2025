package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

//Compenstates the shooter motor power based on the voltage
public class VoltagePowerCompensator {
    private VoltageSensor voltageSensor;
    public VoltagePowerCompensator(HardwareMap hardwareMap) {
        this.voltageSensor = hardwareMap.get(VoltageSensor.class, "Control Hub");
    }

    public double compensate(double originalPower) {
        double voltage = voltageSensor.getVoltage();
        if (voltage >= 13) {
            return originalPower * 0.935;
        }
        else if (voltage >= 12) {
            return originalPower;
        }
        else {
            return originalPower * 1.25;
        }
    }
}
