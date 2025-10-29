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
public class AutonBlue6424 extends LinearOpMode {
    private Follower follower;
    private ShooterIntake shooterIntake;
    private int pathState;
    private Paths paths;

    @Override
    public void runOpMode() {
        shooterIntake = new ShooterIntake(hardwareMap);
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(96.300, 95.600, Math.toRadians(45)));
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
                follower.followPath(paths.BlueRow1FirstBall);
                pathState = 1;
                break;
            case 1:
                if (!follower.isBusy()) {
                    follower.followPath(paths.BlueRow1SecondBall);
                    pathState = 2;
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    follower.followPath(paths.BlueRow1ThirdBall);
                    pathState = 3;
                }
                break;
            case 3:
                if (!follower.isBusy()) {
                    follower.followPath(paths.BlueRow1ToShooter);
                    pathState = 4;
                }
                break;
            case 4:
                if (!follower.isBusy()) {
                    follower.followPath(paths.BlueRow2FirstBall);
                    pathState = 5;
                }
                break;
            case 5:
                if (!follower.isBusy()) {
                    follower.followPath(paths.BlueRow2SecondBall);
                    pathState = 6;
                }
                break;
            case 6:
                if (!follower.isBusy()) {
                    follower.followPath(paths.BlueRow2ThirdBall);
                    pathState = 7;
                }
                break;
            case 7:
                if (!follower.isBusy()) {
                    follower.followPath(paths.BlueRow2ToShooter);
                    pathState = 8;
                }
                break;
        }
    }
}
