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

            boolean claw= gamepad1.dpad_right;//closes


            boolean claw_open = gamepad1.dpad_left;//opens

            if (claw_open){
                servo.setPosition(1);

            } else if (claw) {

                servo.setPosition(0);

            }

        }


    }

}
