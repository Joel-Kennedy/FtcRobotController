package org.firstinspires.ftc.OLDTEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="hexmotortesting")
@Disabled
public class hexmotortest extends LinearOpMode {



    DcMotor hextesting;



   @Override
   public void  runOpMode(){

        hextesting = hardwareMap.get(DcMotor.class,"hex");
        hextesting.setDirection(DcMotor.Direction.FORWARD);
        waitForStart();
        while (opModeIsActive()){

            hextesting.setPower(gamepad2.left_stick_y);
        }


   }
}
//