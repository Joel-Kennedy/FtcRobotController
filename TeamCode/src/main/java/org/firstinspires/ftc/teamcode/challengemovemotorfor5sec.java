package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class challengemovemotorfor5sec extends LinearOpMode {
    DcMotor Cf;
    @Override
    public void runOpMode(){
        Cf = hardwareMap.get(DcMotor.class, "ChickenFingers");
        Cf.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        while ( (opModeIsActive())
        {

    }
}
