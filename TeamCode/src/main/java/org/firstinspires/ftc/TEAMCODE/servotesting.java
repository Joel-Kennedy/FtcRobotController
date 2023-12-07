package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class servotesting extends LinearOpMode {
    Servo   servo;



    @Override
    public  void  runOpMode() {
        // Connect to servo (Assume Robot Left Hand)
        // Change the text in quotes to match any servo name on your robot.
        servo = hardwareMap.get(Servo.class, "left_hand");

        waitForStart();

        while(opModeIsActive()){

            boolean claw= gamepad1.right_stick_button;//closes


            boolean claw_open = gamepad1.left_stick_button;//opens

            if (claw_open) {
                servo.setPosition(.3);



            } else if (claw) {
                servo.setPosition(0);

            }//


        }


    }

}
