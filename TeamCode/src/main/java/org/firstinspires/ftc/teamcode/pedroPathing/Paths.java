package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class Paths {
    public PathChain RedRow1FirstBall;
    public PathChain RedRow1SecondBall;
    public PathChain RedRow1ThirdBall;
    public PathChain RedRow1ToShooter;
    public PathChain RedRow2FirstBall;
    public PathChain RedRow2SecondBall;
    public PathChain RedRow2ThirdBall;
    public PathChain RedRow2ToShooter;

    public Paths(Follower follower) {
        RedRow1FirstBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(96.300, 95.600), new Pose(115.000, 95.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(45), Math.toRadians(270))
                .build();

        RedRow1SecondBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(115.000, 95.000), new Pose(120.000, 95.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(270))
                .build();

        RedRow1ThirdBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(120.000, 95.000), new Pose(125.200, 95.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(270))
                .build();

        RedRow1ToShooter = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(125.200, 95.000), new Pose(96.300, 95.600))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(45))
                .build();

        RedRow2FirstBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(96.300, 95.600), new Pose(115.000, 71.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(45), Math.toRadians(270))
                .build();

        RedRow2SecondBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(115.000, 71.000), new Pose(120.000, 71.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(270))
                .build();

        RedRow2ThirdBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(120.000, 71.000), new Pose(125.200, 71.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(270))
                .build();

        RedRow2ToShooter = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(125.200, 71.000), new Pose(96.300, 95.600))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(45))
                .build();
    }
}