package org.firstinspires.ftc.teamcode;

import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterIntake {
    private DcMotor intake;
    private DcMotor shooter;
    private Timer shootTimer;
    private Timer intakeTimer;
    private boolean isShooterBusy;
    private boolean isIntakeBusy;
    private static final int SHOOTING_TIME = 1000;
    private static final int INTAKE_TIME = 1000;
    private int shootingTime = SHOOTING_TIME;
    private int intakeTime = INTAKE_TIME;
    public ShooterIntake(HardwareMap hardwareMap) {
        shootTimer = new Timer();
        intakeTimer = new Timer();
        isShooterBusy = false;
        isIntakeBusy = false;
        intake = (DcMotor)hardwareMap.get("indexMotor");
        shooter = (DcMotor)hardwareMap.get("shooterMotor");
    }

    public void beginShooting(int time) {
        shootingTime = time;
        shootTimer.resetTimer();
        shooter.setPower(1);
        isShooterBusy = true;
    }

    public void beginShooting()  {
        beginShooting(SHOOTING_TIME);
    }

    public void beginIntake(int time) {
        intakeTime = time;
        intakeTimer.resetTimer();
        intake.setPower(1);
        isIntakeBusy = true;
    }

    public void beginIntake() {
        beginIntake(INTAKE_TIME);
    }

    public void update() {
        if (isShooterBusy) {
            if (shootTimer.getElapsedTime() >= shootingTime) {
                shooter.setPower(0);
                isShooterBusy = false;
            }
        }
        if (isIntakeBusy) {
            if (intakeTimer.getElapsedTime() >= intakeTime) {
                intake.setPower(0);
                isIntakeBusy = false;
            }
        }
    }

    public void stop() {
        shooter.setPower(0);
        isShooterBusy = false;
        intake.setPower(0);
        isIntakeBusy = false;
    }

    public boolean isBusy() {
        return isShooterBusy || isIntakeBusy;
    }
}
