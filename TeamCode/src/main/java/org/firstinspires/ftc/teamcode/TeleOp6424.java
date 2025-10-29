package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Configurable
@TeleOp
public class TeleOp6424 extends LinearOpMode {
    private Follower follower;
    private DcMotor shooterRotate;
    private DcMotor shooterShoot;

    @Override
    public void runOpMode() {
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(96.300, 95.600, Math.toRadians(45)));
        shooterRotate = (DcMotor)hardwareMap.get("shooter1");
        shooterShoot = (DcMotor)hardwareMap.get("shooter2");
        waitForStart();
        follower.startTeleopDrive();
        while (opModeIsActive()) {
            //drivebase
            if (!follower.isBusy()) {
                follower.setTeleOpDrive(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x, false);
            }
            else {
                //cancel automated movement upon joystick movement
                if (gamepad1.left_stick_y != 0 || gamepad1.left_stick_x != 0) {
                    follower.breakFollowing();
                    follower.setTeleOpDrive(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x, false);
                }
            }
            if (gamepad1.aWasPressed()) {
                //moves to parking positon
                follower.breakFollowing();
                follower.followPath(createPathToPose(new Pose(105.3, 33.2, Math.toRadians(0))));
            }
            if (gamepad1.yWasPressed()) {
                //moves to lever
                follower.breakFollowing();
                follower.followPath(createPathToPose(new Pose(16.4, 70.5, Math.toRadians(0))));
            }
            if (gamepad1.xWasPressed()) {
                //moves to intake
                follower.breakFollowing();
                follower.followPath(createPathToPose(new Pose(117.9, 11.7, Math.toRadians(0))));
            }
            if (gamepad1.bWasPressed()) {
                //moves to shooter
                follower.breakFollowing();
                follower.followPath(createPathToPose(new Pose(96.300, 95.600, Math.toRadians(45))));
            }
            follower.update();
            //shooter rotation
            shooterRotate.setPower(gamepad2.left_stick_x);
            //shooter action
            if (gamepad2.a) {
                shooterShoot.setPower(1);
            }
            else if (gamepad2.b) {
                shooterShoot.setPower(-1);
            }
            else {
                shooterShoot.setPower(0);
            }
        }
    }

    private PathChain createPathToPose(Pose pose) {
        return follower
                .pathBuilder()
                .addPath(new BezierLine(follower.getPose(), pose))
                .setLinearHeadingInterpolation(follower.getHeading(), pose.getHeading())
                .build();
    }
}
