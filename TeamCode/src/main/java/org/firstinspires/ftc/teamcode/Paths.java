package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class Paths {
    public PathChain Path1;
    public PathChain Path2;
    public PathChain Path3;
    public Paths(Follower follower) {
        Path1 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(38.7, 33.3), new Pose(72.1, 120.3))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(90))
                .build();
        Path2 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(72.100, 120.300), new Pose(24.300, 97.600))
                )
                .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(270))
                .build();

        Path3 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(24.300, 97.600), new Pose(108.200, 120.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(45))
                .build();
    }
}