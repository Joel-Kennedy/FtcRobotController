package org.firstinspires.ftc.TEAMCODE.oldcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;



public class PROJECT_CSHH_CSHH extends LinearOpMode {
    CRServo  servo1;
    CRServo  servo2;
    DcMotor extention;
    CRServo  servo3;


    @Override
    public  void  runOpMode() {
        // Connect to servo (Assume Robot Left Hand)
        // Change the text in quotes to match any servo name on your robot.
        servo1 = hardwareMap.get(CRServo.class, "left_hand");
        servo2 = hardwareMap.get(CRServo.class, "right_hand");
        extention = hardwareMap.get(DcMotor.class,"spool");
        servo3 = hardwareMap.get(CRServo.class,"claw.rotation");
        waitForStart();

        while(opModeIsActive()){

            boolean claw= gamepad1.b;//closes

            boolean rotation = gamepad1.dpad_up;

            boolean rotationRe = gamepad1.dpad_down;

            boolean claw_open = gamepad1.a;//opens

            boolean extension = gamepad2.left_bumper;

            boolean extensionRe =gamepad2.right_bumper;

            if (extension){

                extention.setPower(.6);
            } else if (extensionRe){

                extention.setPower(-.2);

            }

            else {
                extention.setPower(0);
            }
            if (claw_open) {
                servo1.setPower(.2);
                servo2.setPower(-.2);
            } else if (claw) {
                servo1.setPower(-.2);
                servo2.setPower(.2);
            }


            else {
                servo1.setPower(0);
                servo2.setPower(0);
            }

            if (rotation){
                servo3.setPower(.2);
            }
            else if (rotationRe){
                servo3.setPower(-.2);
            }

            else{
                servo3.setPower(0);
            }
        }
    }
}


