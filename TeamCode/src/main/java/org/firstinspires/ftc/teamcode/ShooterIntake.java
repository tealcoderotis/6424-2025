package org.firstinspires.ftc.teamcode;

import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.util.VoltagePowerCompensator;

public class ShooterIntake {
    private DcMotor indexer;
    private DcMotor shooter;
    private Timer shootTimer;
    private boolean isShooterBusy = false;
    private boolean isReving = false;
    private boolean isIntaking = false;
    private static final int SHOOTING_TIME = 1000;
    private static final int INDEX_TIME = 500;
    private static final int INTAKE_TIME = 500;
    private static final int REV_TIME = 2000;
    private int ballsToShoot = 0;
    private int currentBall = -1;
    private VoltagePowerCompensator voltageCompensator;
    public ShooterIntake(HardwareMap hardwareMap) {
        shootTimer = new Timer();
        indexer = (DcMotor)hardwareMap.get("indexMotor");
        shooter = (DcMotor)hardwareMap.get("shooterMotor");
        voltageCompensator = new VoltagePowerCompensator(hardwareMap);
    }

    public void beginShooting(int ballsToShoot) {
        isIntaking = false;
        this.ballsToShoot = ballsToShoot;
        currentBall = 0;
        shootTimer.resetTimer();
        shooter.setPower(voltageCompensator.compensate(0.63));
        isShooterBusy = true;
        isReving = true;
    }

    public void beginIntaking() {
        isIntaking = true;
        shootTimer.resetTimer();
        indexer.setPower(voltageCompensator.compensate(0.4));
        isShooterBusy = true;
    }

    public void update() {
        if (isShooterBusy) {
            if (isIntaking) {
                if (shootTimer.getElapsedTime() >= INTAKE_TIME) {
                    indexer.setPower(0);
                    isShooterBusy = false;
                }
            }
            else {
                if (isReving) {
                    if (shootTimer.getElapsedTime() >= REV_TIME) {
                        isReving = false;
                        indexer.setPower(voltageCompensator.compensate(0.4));
                        shootTimer.resetTimer();
                    }
                }
                else {
                    if (shootTimer.getElapsedTime() >= INDEX_TIME) {
                        indexer.setPower(0);
                    }
                    if (shootTimer.getElapsedTime() >= SHOOTING_TIME) {
                        currentBall ++;
                        if (currentBall < ballsToShoot) {
                            indexer.setPower(voltageCompensator.compensate(0.4));
                            shootTimer.resetTimer();
                        }
                        else {
                            shooter.setPower(0);
                            indexer.setPower(0);
                            isShooterBusy = false;
                        }
                    }
                }
            }
        }
    }

    public void stop() {
        shooter.setPower(0);
        indexer.setPower(0);
        isShooterBusy = false;
    }

    public boolean isBusy() {
        return isShooterBusy;
    }
}
