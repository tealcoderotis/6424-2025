package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class Paths {
    public PathChain BlueRow1FirstBall;
    public PathChain BlueRow1SecondBall;
    public PathChain BlueRow1ThirdBall;
    public PathChain BlueRow1ToShooter;
    public PathChain BlueRow2FirstBall;
    public PathChain BlueRow2SecondBall;
    public PathChain BlueRow2ThirdBall;
    public PathChain BlueRow2ToShooter;

    public Paths(Follower follower) {
        BlueRow1FirstBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(96.300, 95.600), new Pose(115.000, 95.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(45), Math.toRadians(270))
                .build();

        BlueRow1SecondBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(115.000, 95.000), new Pose(120.000, 95.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(270))
                .build();

        BlueRow1ThirdBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(120.000, 95.000), new Pose(125.200, 95.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(270))
                .build();

        BlueRow1ToShooter = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(125.200, 95.000), new Pose(96.300, 95.600))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(45))
                .build();

        BlueRow2FirstBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(96.300, 95.600), new Pose(115.000, 71.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(45), Math.toRadians(270))
                .build();

        BlueRow2SecondBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(115.000, 71.000), new Pose(120.000, 71.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(270))
                .build();

        BlueRow2ThirdBall = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(120.000, 71.000), new Pose(125.200, 71.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(270))
                .build();

        BlueRow2ToShooter = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(125.200, 71.000), new Pose(96.300, 95.600))
                )
                .setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(45))
                .build();
    }
}