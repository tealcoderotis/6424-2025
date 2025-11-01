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
    private static final int INTAKE_TIME = 500;
    private static final int INDEX_TIME = 500;
    private int ballsToShoot = 0;
    private int currentBall = 0;
    public ShooterIntake(HardwareMap hardwareMap) {
        shootTimer = new Timer();
        intakeTimer = new Timer();
        isShooterBusy = false;
        isIntakeBusy = false;
        intake = (DcMotor)hardwareMap.get("indexMotor");
        shooter = (DcMotor)hardwareMap.get("shooterMotor");
    }

    public void beginShooting(int ballsToShoot) {
        this.ballsToShoot = ballsToShoot;
        currentBall = 0;
        shootTimer.resetTimer();
        shooter.setPower(0.5);
        intake.setPower(0.4);
        isShooterBusy = true;
    }

    public void beginIntake() {
        intakeTimer.resetTimer();
        intake.setPower(0.5);
        isIntakeBusy = true;
    }

    public void update() {
        if (isShooterBusy) {
            if (shootTimer.getElapsedTime() >= INDEX_TIME) {
                intake.setPower(0);
            }
            if (shootTimer.getElapsedTime() >= SHOOTING_TIME) {
                currentBall ++;
                if (currentBall < ballsToShoot) {
                    intake.setPower(0.4);
                    shootTimer.resetTimer();
                }
                else {
                    shooter.setPower(0);
                    intake.setPower(0);
                    isShooterBusy = false;
                }
            }
        }
        if (isIntakeBusy) {
            if (intakeTimer.getElapsedTime() >= INTAKE_TIME) {
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
