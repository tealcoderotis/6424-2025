package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

//PedroPathing Paths
public class Paths {
    //declare all of our paths
    public PathChain RedRow1IntakeBegin;
    public PathChain RedRow1IntakeEnd;
    public PathChain RedRow1ToShooter;
    public PathChain RedRow2IntakeBegin;
    public PathChain RedRow2IntakeEnd;
    public PathChain RedRow2ToShooter;
    public PathChain BlueRow1IntakeBegin;
    public PathChain BlueRow1IntakeEnd;
    public PathChain BlueRow1ToShooter;
    public PathChain BlueRow2IntakeBegin;
    public PathChain BlueRow2IntakeEnd;
    public PathChain BlueRow2ToShooter;

    //initalize all of our paths
    public Paths(Follower follower) {
        RedRow1IntakeBegin = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(83.392, 132.938), new Pose(103.108, 83.762))
                )
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
                .build();

        RedRow1IntakeEnd = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(103.108, 83.762), new Pose(125.200, 83.762))
                )
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
                .build();

        RedRow1ToShooter = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(125.200, 83.762), new Pose(83.392, 132.938))
                )
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
                .build();

        RedRow2IntakeBegin = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(83.392, 132.938), new Pose(103.108, 59.579))
                )
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
                .build();

        RedRow2IntakeEnd = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(103.108, 59.579), new Pose(125.200, 59.579))
                )
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
                .build();

        RedRow2ToShooter = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(125.200, 59.579), new Pose(83.392, 132.938))
                )
                .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
                .build();

        BlueRow1IntakeBegin = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(61.051, 132.133), new Pose(40.892, 83.762))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                .build();

        BlueRow1IntakeEnd = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(40.892, 83.762), new Pose(19.100, 83.762))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                .build();

        BlueRow1ToShooter = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(19.100, 83.762), new Pose(61.051, 132.133))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                .build();

        BlueRow2IntakeBegin = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(61.051, 132.133), new Pose(40.892, 59.798))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                .build();

        BlueRow2IntakeEnd = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(40.892, 59.798), new Pose(19.100, 59.798))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                .build();

        BlueRow2ToShooter = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(19.100, 59.798), new Pose(61.051, 132.133))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                .build();
    }
}