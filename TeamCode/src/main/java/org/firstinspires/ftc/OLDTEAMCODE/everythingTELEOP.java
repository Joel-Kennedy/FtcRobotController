package org.firstinspires.ftc.OLDTEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;


@Disabled
public class everythingTELEOP extends LinearOpMode {

    CRServo planeready;
    CRServo servo1;
    CRServo servo2;
    //    CRServo servoZero;
    CRServo servo3;
    DcMotor backLeft;
    DcMotor spool;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor skyhook;
    DcMotor rightArm;
    DcMotor leftArm;

    DcMotor extention;


    //test
    @Override
    public void runOpMode() {

        //Control Hub
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        //Expansion Hub
        spool = hardwareMap.get(DcMotor.class, "spool");
        rightArm = hardwareMap.get(DcMotor.class, "rightArm");
        leftArm = hardwareMap.get(DcMotor.class, "leftArm");
        skyhook = hardwareMap.get(DcMotor.class, "skyhook23695");
        //Servos
        planeready = hardwareMap.get(CRServo.class, "Dronelauncher");
        servo1 = hardwareMap.get(CRServo.class, "left_hand");
        servo2 = hardwareMap.get(CRServo.class, "right_hand");
        extention = hardwareMap.get(DcMotor.class, "spool");//this is arm extention
        servo3 = hardwareMap.get(CRServo.class, "claw.rotation");
//            distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
//            imu = hardwareMap.get(BNO055IMU.class, "imu");
        backLeft.setDirection(DcMotor.Direction.REVERSE);//-
        backRight.setDirection(DcMotor.Direction.FORWARD);//+
        frontLeft.setDirection(DcMotor.Direction.REVERSE);//-
        frontRight.setDirection(DcMotor.Direction.REVERSE);//+
//        spool.setDirection(DcMotorSimple.Direction.FORWARD);//+
//        rightArm.setDirection(DcMotorSimple.Direction.FORWARD);//+
//        leftArm.setDirection(DcMotorSimple.Direction.REVERSE);//-
//        skyhook.setDirection(DcMotorSimple.Direction.FORWARD);
//
//        rightArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        leftArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        spool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        waitForStart();
        while (opModeIsActive()) {
//            double leftdrive = -gamepad1.left_stick_y;
//            double rightdrive = -gamepad1.left_stick_y;
//            double driveright = gamepad1.left_stick_x;
//            double driveleft = gamepad1.left_stick_x;
//            double TURN_R = gamepad1.right_stick_x;
//            double fl = leftdrive + driveleft + TURN_R;  //front left=fl
//            double bl = leftdrive - driveleft + TURN_R;//back left=bl
//            double fr = rightdrive - driveright - TURN_R;//front right=fr
//            double br = rightdrive + driveright - TURN_R;//back right=br
            // gamepad 2

            //float leftarmposition;
            //float rightarmposition;
//            float wheelSpeed = 0.5F;
//            boolean rotation = gamepad2.dpad_right;
//            boolean rotationRe = gamepad2.dpad_left;
//            boolean extension = gamepad2.left_bumper;
//            boolean extensionRe = gamepad2.right_bumper;

            //rightArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            //leftArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//            backLeft.setPower(bl * wheelSpeed);
//            backRight.setPower(br * wheelSpeed);
//            frontLeft.setPower(fl * wheelSpeed);
//            frontRight.setPower(fr * wheelSpeed);

            //telemetry.addData("rightarmposition", rightArm.getCurrentPosition());
            //telemetry.addData("leftarmposition", leftArm.getCurrentPosition());
            telemetry.addData("gamepad2 leftstick y pos", gamepad2.left_stick_y);
            telemetry.addData("Starting at", "%7d :%7d %7d :%7d",
                    frontRight.getCurrentPosition(),
                    backRight.getCurrentPosition(),
                    frontLeft.getCurrentPosition(),
                    backLeft.getCurrentPosition());

            telemetry.update();


//            //Claw
//            boolean claw = gamepad2.b;//closes
//            boolean claw_open = gamepad2.a;//opens
//            //float clawUp = gamepad2.right_stick_y;//opens
//
//            if (claw_open) {
//                servo1.setPower(0.2);
//                servo2.setPower(-0.2);
//            } else if (claw) {
//                servo1.setPower(-0.2);
//                servo2.setPower(0.2);
//            } else {
//                servo1.setPower(0);
//                servo2.setPower(0);
//            }


            //Plane
//            boolean planeisready = gamepad2.x;//shoots
//
//            if (planeisready) {
//                planeready.setPower(-0.5);
//            } else {
//                planeready.setPower(0);
//            }
//
//
//            //Sky hook
//            if (gamepad1.dpad_up) {
//                skyhook.setPower(1);
//            } else if (gamepad2.dpad_down) {
//                skyhook.setPower(-1);
//            } else {
//                skyhook.setPower(0);
//            }

//
//            //Arm
//            //Boost arm power
//            double ArmPower = 0.3;
//            if (gamepad2.a) {
//                ArmPower = ArmPower * 2;
//            }
//
//            //Arm up and down
//            if (gamepad2.left_stick_y <= -0.3) {
//                leftArm.setPower(-ArmPower);
//                rightArm.setPower(ArmPower);
//            } else if (gamepad2.left_stick_y >= 0.3) {
//                rightArm.setPower(-ArmPower);
//                leftArm.setPower(ArmPower);
//            } else {
//                rightArm.setPower(0);
//                leftArm.setPower(0);
//            }
//
//
//            //Extend claw in and out of robot
//            if (extension) {
//                spool.setPower(.7);
//            } else if (extensionRe) {
//                spool.setPower(-.7);
//            } else {
//                spool.setPower(0);
//            }
//
//            //Rotate claw up and down
//            if (rotation) {
//                servo3.setPower(.2);
//            } else if (rotationRe) {
//                servo3.setPower(-.2);
//            } else {
//                servo3.setPower(0);
//            }
//
//          }
//       }
//    }
        }

    }

}