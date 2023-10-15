package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class challengemovemotorfor5sec extends LinearOpMode {
    DcMotor Cf;
     private ElapsedTime   runTime = new ElapsedTime();
    @Override
    public void runOpMode(){
        Cf = hardwareMap.get(DcMotor.class, "ChickenFingers");
        Cf.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()){
            
        }

    }
}