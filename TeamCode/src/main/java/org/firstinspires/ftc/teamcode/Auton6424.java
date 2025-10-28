package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Configurable
@Autonomous
public class Auton6424 extends LinearOpMode {
    private Follower follower;
    private int pathState;
    private Paths paths;
    private int motif;

    @Override
    public void runOpMode() {
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(38.7, 33.3, Math.toRadians(180)));
        paths = new Paths(follower);
        waitForStart();
        pathState = 0;
        motif = -1;
        while (opModeIsActive()) {
            follower.update();
            autonomousPathUpdate();
            telemetry.addData("path state", pathState);
            telemetry.addData("motif", motif);
            telemetry.addData("x", follower.getPose().getX());
            telemetry.addData("y", follower.getPose().getY());
            telemetry.addData("heading", follower.getPose().getHeading());
            telemetry.update();
        }
    }

    public void autonomousPathUpdate() {
        switch (pathState) {
            case 0:
                follower.followPath(paths.Path1);
                pathState = 1;
                break;
            case 1:
                if (!follower.isBusy()) {
                    //TODO grab april tag with limelight
                    motif = 0;
                    follower.followPath(paths.Path2);
                    pathState = 2;
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    //TODO Intake!
                    pathState = 3;
                }
                break;
        }
    }
}
