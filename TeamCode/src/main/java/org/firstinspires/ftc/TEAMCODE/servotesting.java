package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class servotesting extends LinearOpMode {
    Servo   servo;

    @Override
    public  void  runOpMode() {
        // Connect to servo (Assume Robot Left Hand)
        // Change the text in quotes to match any servo name on your robot.
        servo = hardwareMap.get(Servo.class, "left_hand");

        waitForStart();

        while(opModeIsActive()){
            servo.setPosition(1);
            sleep(1000);

            servo.setPosition(0.5);
            sleep(1000);
        }


    }

}
