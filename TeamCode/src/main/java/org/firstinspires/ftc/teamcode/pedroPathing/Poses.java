package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.geometry.Pose;

public class Poses {
    public Pose BluePark;
    public Pose BlueLever;
    public Pose BlueIntake;
    public Pose BlueShooter;

    public Poses() {
        BluePark = new Pose(105.3, 33.2, Math.toRadians(0));
        BlueLever = new Pose(16.4, 70.5, Math.toRadians(0));
        BlueIntake = new Pose(117.9, 11.7, Math.toRadians(0));
        BlueShooter = new Pose(96.300, 95.600, Math.toRadians(45));
    }
}
