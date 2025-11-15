package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.pedroPathing.Paths;

//Auton for the red alliance
@Configurable
@Autonomous
public class AutonRed6424 extends LinearOpMode {
    private Follower follower;
    private ShooterIntake shooterIntake;
    private int pathState;
    private Paths paths;

    @Override
    public void runOpMode() {
        //initialization
        shooterIntake = new ShooterIntake(hardwareMap, telemetry);
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(83.39221704720353, 132.93753206455213, Math.toRadians(0)));
        paths = new Paths(follower);
        pathState = 0;
        DcMotor rightFrontDrive = (DcMotor)hardwareMap.get("rightFrontDrive");
        DcMotor rightBackDrive = (DcMotor)hardwareMap.get("rightBackDrive");
        DcMotor leftFrontDrive = (DcMotor)hardwareMap.get("leftFrontDrive");
        DcMotor leftBackDrive = (DcMotor)hardwareMap.get("leftBackDrive");
        waitForStart();
        while (opModeIsActive()) {
            //update shooter and follower
            shooterIntake.update();
            follower.update();
            autonomousPathUpdate();
            telemetry.addData("path state", pathState);
            telemetry.addData("x", follower.getPose().getX());
            telemetry.addData("y", follower.getPose().getY());
            telemetry.addData("heading", follower.getPose().getHeading());
            telemetry.addData("leftFrontDrive", leftFrontDrive.getPower());
            telemetry.addData("leftBackDrive", leftBackDrive.getPower());
            telemetry.addData("rightFrontDrive", rightFrontDrive.getPower());
            telemetry.addData("rightBackDrive", rightBackDrive.getPower());
            telemetry.update();
        }
    }

    //checks our current action and if the follower or shooter/intake are currently active, if not we increment at state counter, moving on to the next action
    public void autonomousPathUpdate() {
        switch (pathState) {
            case 0:
                shooterIntake.beginShooting(3);
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
                    shooterIntake.beginIntaking();
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
                    shooterIntake.beginIntaking();
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
                    shooterIntake.beginIntaking();
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
                    shooterIntake.beginShooting(3);
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
                    shooterIntake.beginIntaking();
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
                    shooterIntake.beginIntaking();
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
                    shooterIntake.beginIntaking();
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
                    shooterIntake.beginShooting(3);
                    pathState = 17;
                }
        }
    }
}
