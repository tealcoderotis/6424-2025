package org.firstinspires.ftc.teamcode;

import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterIntake {
    private DcMotor shooterRotate;
    private DcMotor shooterShoot;
    private Timer shootTimer;
    private boolean isBusy;
    private static final int SHOOTING_TIME = 1000;
    public ShooterIntake(HardwareMap hardwareMap) {
        shootTimer = new Timer();
        isBusy = false;
        shooterRotate = (DcMotor)hardwareMap.get("indexMotor");
        shooterShoot = (DcMotor)hardwareMap.get("shooterMotor");
    }

    public void beginShooting() {
        shootTimer.resetTimer();
        shooterShoot.setPower(1);
        isBusy = true;
    }

    public void update() {
        if (isBusy) {
            if (shootTimer.getElapsedTime() >= SHOOTING_TIME) {
                shooterShoot.setPower(0);
                isBusy = false;
            }
        }
    }

    public boolean isBusy() {
        return isBusy;
    }
}
