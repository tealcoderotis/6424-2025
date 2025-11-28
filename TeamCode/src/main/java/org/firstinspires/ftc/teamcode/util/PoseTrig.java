package org.firstinspires.ftc.teamcode.util;

import com.pedropathing.geometry.Pose;

public class PoseTrig {
    public static double distanceBetweenPoses(Pose pose1, Pose pose2) {
        return Math.sqrt(Math.pow(pose2.getX() - pose1.getX(), 2) + Math.pow(pose2.getY() - pose1.getY(), 2));
    }

    public static double angleBetweenPoses(Pose pose1, Pose pose2) {
        double xDistance = Math.abs(pose2.getX() - pose1.getX());
        double yDistance = Math.abs(pose2.getY() - pose1.getY());
        return Math.atan(yDistance/xDistance);
    }
}
