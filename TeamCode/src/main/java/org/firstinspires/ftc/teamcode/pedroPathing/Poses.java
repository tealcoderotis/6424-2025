package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.geometry.Pose;

public class Poses {
    public Pose BluePark;
    public Pose BlueLever;
    public Pose BlueIntake;
    public Pose BlueShooter;
    public Pose RedPark;
    public Pose RedLever;
    public Pose RedIntake;
    public Pose RedShooter;

    public Poses() {
        BluePark = new Pose(105.3, 33.2, Math.toRadians(0));
        BlueLever = new Pose(16.4, 70.5, Math.toRadians(0));
        BlueIntake = new Pose(117.9, 11.7, Math.toRadians(0));
        BlueShooter = new Pose(48, 95.6, Math.toRadians(135));
        RedPark = new Pose(38.8, 33.2, Math.toRadians(0));
        RedLever = new Pose(127.6, 70.5, Math.toRadians(180));
        RedIntake = new Pose(26.5, 11.7, Math.toRadians(180));
        RedShooter = new Pose(96.3, 95.6, Math.toRadians(45));
    }
}
