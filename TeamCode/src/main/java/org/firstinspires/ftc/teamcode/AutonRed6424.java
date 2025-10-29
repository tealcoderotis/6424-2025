package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.pedroPathing.Paths;

@Configurable
@Autonomous
public class AutonRed6424 extends LinearOpMode {
    private Follower follower;
    private ShooterIntake shooterIntake;
    private int pathState;
    private Paths paths;

    @Override
    public void runOpMode() {
        shooterIntake = new ShooterIntake(hardwareMap);
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(96.3, 95.6, Math.toRadians(45)));
        paths = new Paths(follower);
        waitForStart();
        pathState = 0;
        while (opModeIsActive()) {
            shooterIntake.update();
            follower.update();
            autonomousPathUpdate();
            telemetry.addData("path state", pathState);
            telemetry.addData("x", follower.getPose().getX());
            telemetry.addData("y", follower.getPose().getY());
            telemetry.addData("heading", follower.getPose().getHeading());
            telemetry.update();
        }
    }

    public void autonomousPathUpdate() {
        switch (pathState) {
            case 0:
                shooterIntake.beginShooting();
                pathState = 1;
                break;
            case 1:
                if (!shooterIntake.isBusy()) {
                    follower.followPath(paths.RedRow1FirstBall);
                    pathState = 2;
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    shooterIntake.beginIntake();
                    pathState = 3;
                }
                break;
            case 3:
                if (!shooterIntake.isBusy()) {
                    follower.followPath(paths.RedRow1SecondBall);
                    pathState = 4;
                }
                break;
            case 4:
                if (!follower.isBusy()) {
                    shooterIntake.beginIntake();
                    pathState = 5;
                }
                break;
            case 5:
                if (!shooterIntake.isBusy()) {
                    follower.followPath(paths.RedRow1ThirdBall);
                    pathState = 6;
                }
                break;
            case 6:
                if (!follower.isBusy()) {
                    shooterIntake.beginIntake();
                    pathState = 7;
                }
                break;
            case 7:
                if (!shooterIntake.isBusy()) {
                    follower.followPath(paths.RedRow1ToShooter);
                    pathState = 8;
                }
                break;
            case 8:
                if (!follower.isBusy()) {
                    shooterIntake.beginShooting();
                    pathState = 9;
                }
                break;
            case 9:
                if (!shooterIntake.isBusy()) {
                    follower.followPath(paths.RedRow2FirstBall);
                    pathState = 10;
                }
                break;
            case 10:
                if (!follower.isBusy()) {
                    shooterIntake.beginIntake();
                    pathState = 11;
                }
                break;
            case 11:
                if (!shooterIntake.isBusy()) {
                    follower.followPath(paths.RedRow2SecondBall);
                    pathState = 12;
                }
                break;
            case 12:
                if (!follower.isBusy()) {
                    shooterIntake.beginIntake();
                    pathState = 13;
                }
                break;
            case 13:
                if (!shooterIntake.isBusy()) {
                    follower.followPath(paths.RedRow2ThirdBall);
                    pathState = 14;
                }
                break;
            case 14:
                if (!follower.isBusy()) {
                    shooterIntake.beginIntake();
                    pathState = 15;
                }
                break;
            case 15:
                if (!shooterIntake.isBusy()) {
                    follower.followPath(paths.RedRow2ToShooter);
                    pathState = 16;
                }
                break;
            case 16:
                if (!follower.isBusy()) {
                    shooterIntake.beginShooting();
                    pathState = 17;
                }
        }
    }
}
