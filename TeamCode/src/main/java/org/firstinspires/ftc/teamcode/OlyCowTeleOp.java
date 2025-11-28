package org.firstinspires.ftc.teamcode;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.util.ElapsedTime;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.util.PoseTrig;

@TeleOp(name = "OlyCowTeleOp")
//@Disabled
public class OlyCowTeleOp extends OpMode {
    final double FEED_TIME_SECONDS = 0.5;
    final double STOP_SPEED = 0.0;
    final double HALF_SPEED = 0.5;
    final double FULL_SPEED = 1.0;

    final double LAUNCHER_MAX_VELOCITY = 2000;
    final double LAUNCHER_MIN_VELOCITY = 1450;

    private DcMotor leftFrontDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightBackDrive = null;
    private DcMotorEx launcher = null;
    private DcMotorEx feeder = null;
    private Follower follower;

    ElapsedTime feederTimer = new ElapsedTime();

    private int alliance = -1;

    private enum LaunchState {
        IDLE,
        SPIN_UP,
        LAUNCH,
        LAUNCHING,
    }

    private LaunchState launchState;

    double leftFrontPower;
    double rightFrontPower;
    double leftBackPower;
    double rightBackPower;
    double trackingAngle;

    @Override
    public void init() {
        launchState = LaunchState.IDLE;

        leftFrontDrive = hardwareMap.get(DcMotor.class, "leftFrontDrive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "rightFrontDrive");
        leftBackDrive = hardwareMap.get(DcMotor.class, "leftBackDrive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "rightBackDrive");
        launcher = hardwareMap.get(DcMotorEx.class, "launcher");
        feeder = hardwareMap.get(DcMotorEx.class, "feeder");

        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);
        launcher.setDirection(DcMotor.Direction.REVERSE);

        launcher.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFrontDrive.setZeroPowerBehavior(BRAKE);
        rightFrontDrive.setZeroPowerBehavior(BRAKE);
        leftBackDrive.setZeroPowerBehavior(BRAKE);
        rightBackDrive.setZeroPowerBehavior(BRAKE);
        launcher.setZeroPowerBehavior(BRAKE);

        feeder.setPower(STOP_SPEED);

        launcher.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients(300, 0, 0, 10));

        follower = Constants.createFollower(hardwareMap);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
        if (gamepad1.bWasPressed()) {
            //Red starting pose
            follower.setStartingPose(new Pose(125.200, 70.930, Math.toRadians(0)));
            alliance = 0;
            telemetry.addLine("Red alliance");
            telemetry.update();
        } else if (gamepad1.xWasPressed()) {
            //Blue starting pose
            follower.setStartingPose(new Pose(46.892, 59.798, Math.toRadians(180)));
            alliance = 1;
            telemetry.addLine("Blue alliance");
            telemetry.update();
        }
    }

    @Override
    public void start() {
    }

    @Override
    public void loop() {

        mecanumDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        if (gamepad2.x){
            launcher.setDirection(DcMotor.Direction.REVERSE);
            launcher.setPower(0.25);
            feeder.setDirection(DcMotor.Direction.REVERSE);
            feeder.setPower(FULL_SPEED);
        }

        if (gamepad2.a) {
            feeder.setDirection(DcMotor.Direction.FORWARD);
            feeder.setPower(FULL_SPEED);
        }

        if (gamepad2.b) {
            launcher.setVelocity(STOP_SPEED);
            feeder.setPower(STOP_SPEED);
        }
        if (gamepad2.y) {
            launcher.setVelocity(LAUNCHER_MIN_VELOCITY);
        }
        if (gamepad2.dpad_up) {
            launcher.setVelocity(LAUNCHER_MAX_VELOCITY);
        }

        if (gamepad2.dpad_down) {
            launcher.setVelocity(LAUNCHER_MIN_VELOCITY);
        }
        else {
            feeder.setPower(STOP_SPEED);
        }

        launch(gamepad2.rightBumperWasPressed());

        telemetry.addData("State", launchState);
        telemetry.addData("motorSpeed", launcher.getVelocity());
        if (alliance != -1) {
            if (alliance == 0) {
                trackingAngle = PoseTrig.angleBetweenPoses(follower.getPose(), new Pose(144,144));
            }
            else if (alliance == 1) {
                trackingAngle = PoseTrig.angleBetweenPoses(follower.getPose(), new Pose(0,144));
            }
            telemetry.addData("x", follower.getPose().getX());
            telemetry.addData("y", follower.getPose().getY());
            telemetry.addData("heading", Math.toDegrees(follower.getPose().getHeading()));
            telemetry.addData("angleToShooter", Math.toDegrees(trackingAngle));
            follower.update();
        }
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void stop() {
    }

    void mecanumDrive(double forward, double strafe, double rotate){

        double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(rotate), 1);

        leftFrontPower = (forward + strafe + rotate) / denominator;
        rightFrontPower = (forward - strafe - rotate) / denominator;
        leftBackPower = (forward - strafe + rotate) / denominator;
        rightBackPower = (forward + strafe - rotate) / denominator;

        leftFrontDrive.setPower(leftFrontPower);
        rightFrontDrive.setPower(rightFrontPower);
        leftBackDrive.setPower(leftBackPower);
        rightBackDrive.setPower(rightBackPower);

    }

    void launch(boolean shotRequested) {
        switch (launchState) {
            case IDLE:
                if (shotRequested) {
                    launchState = LaunchState.SPIN_UP;
                }
                break;
            case SPIN_UP:
                launcher.setVelocity(LAUNCHER_MIN_VELOCITY);
                if (launcher.getVelocity() > LAUNCHER_MIN_VELOCITY) {
                    launchState = LaunchState.LAUNCH;
                }
                break;
            case LAUNCH:
                feeder.setPower(FULL_SPEED);
                feederTimer.reset();
                launchState = LaunchState.LAUNCHING;
                break;
            case LAUNCHING:
                feeder.setPower(FULL_SPEED);
                if (feederTimer.seconds() > FEED_TIME_SECONDS) {
                    launchState = LaunchState.IDLE;
                }
                break;
        }
    }
}
