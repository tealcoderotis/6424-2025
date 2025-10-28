package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.follower.Follower;
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
        /*shooterRotate = (DcMotor)hardwareMap.get("shooter1");
        //shooterShoot = (DcMotor)hardwareMap.get("shooter2");*/
        waitForStart();
        follower.startTeleopDrive();
        while (opModeIsActive()) {
            //drivebase
            follower.setTeleOpDrive(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x, false);
            follower.update();
            /*//shooter rotation
            shooterRotate.setPower(gamepad2.left_stick_x);
            //shooter action
            if (gamepad2.a) {
                shooterShoot.setPower(1);
            }
            else {
                shooterShoot.setPower(0);
            }*/
        }
    }
}
