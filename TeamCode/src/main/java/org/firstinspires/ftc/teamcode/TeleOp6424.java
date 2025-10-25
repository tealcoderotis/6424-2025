package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Configurable
@TeleOp
public class TeleOp6424 extends LinearOpMode {
    private Follower follower;

    @Override
    public void runOpMode() {
        follower = Constants.createFollower(hardwareMap);
        waitForStart();
        follower.startTeleopDrive();
        while (opModeIsActive()) {
            follower.setTeleOpDrive(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x, false);
            follower.update();
        }
    }
}
