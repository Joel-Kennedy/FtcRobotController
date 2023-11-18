package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="competition.code!!!!")
public class forwardpropellingthrustdiviceEverything extends LinearOpMode {


    DcMotor backLeft;
    DcMotor spool;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;

    Servo   servo_claw_pickup;

    Servo   servo_claw_rotation;

    DcMotor rightArm;

    DcMotor leftArm;
//        ColorSensor color1;
//        DistanceSensor distance1;
//

    @Override
    public void runOpMode() {
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        spool = hardwareMap.get(DcMotor.class, "spool_arm_string");
        servo_claw_pickup = hardwareMap.get(Servo.class, "left_hand");
        rightArm = hardwareMap.get(DcMotor.class, "rightArm");
        leftArm = hardwareMap.get(DcMotor.class, "leftArm");
        //           color1 = hardwareMap.get(ColorSensor.class, "color1");
//            distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
//            imu = hardwareMap.get(BNO055IMU.class, "imu");
        backLeft.setDirection(DcMotor.Direction.REVERSE);//-
        backRight.setDirection(DcMotor.Direction.FORWARD);//+
        frontLeft.setDirection(DcMotor.Direction.REVERSE);//-
        frontRight.setDirection(DcMotor.Direction.REVERSE);//+
        spool.setDirection(DcMotorSimple.Direction.FORWARD);//+
        rightArm.setDirection(DcMotorSimple.Direction.FORWARD);//+
        leftArm.setDirection(DcMotorSimple.Direction.REVERSE);//-

        rightArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        leftArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        rightArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();
        while (opModeIsActive()) {
            double leftdrive = -gamepad1.left_stick_y;
            double rightdrive = -gamepad1.left_stick_y;
            double driveright = -gamepad1.left_stick_x;
            double driveleft = -gamepad1.left_stick_x;
            double TURN_R = gamepad1.right_stick_x;
            double fl = leftdrive + driveleft + TURN_R;  //front left=fl
            double bl = leftdrive - driveleft + TURN_R;//back left=bl
            double fr = rightdrive - driveright + -TURN_R;//front right=fr
            double br = rightdrive + driveright + -TURN_R;//back right=br
            double spool_out = gamepad2.right_trigger;
            double spool_in = gamepad2.left_trigger;
            double spoolPower = Range.clip(spool_in - spool_out, -0.5, 0.5);
            float leftarmposition;
            float rightarmposition;

            backLeft.setPower(bl * 0.5);
            backRight.setPower(br * 0.5);
            frontLeft.setPower(fl * 0.5);
            frontRight.setPower(fr * 0.5);

            spool.setPower(spoolPower);

            telemetry.addData("speed", spoolPower);
            telemetry.addData("rightarmposition", rightArm.getCurrentPosition());
            telemetry.addData("leftarmposition", leftArm.getCurrentPosition());
            telemetry.update();

            boolean claw = gamepad2.right_bumper;//closes


            boolean claw_open = gamepad2.left_bumper;//opens

            //Claw Open and Close
            if (claw_open) {
                servo_claw_pickup.setPosition(0.3);
            } else if (claw) {
                servo_claw_pickup.setPosition(0);

         //       leave my code alone you monkey DEEZ NUTZ

            }
            float clawDown = -gamepad2.right_stick_y;//closes


            float clawUp = gamepad2.right_stick_y;//opens

            //Claw Open and Close
                if (clawUp > 0.799) {
                    servo_claw_rotation.setPosition(0.3);
                }
                if (clawDown > 0.799) {
                    servo_claw_rotation.setPosition(0);
                }

                if (claw_open) {
                    servo_claw_pickup.setPosition(0.3);
                } else if (claw) {
                    servo_claw_pickup.setPosition(0);


                }
                boolean planeready  = gamepad2.x;//closes

                //Claw Open and Close
                if (planeready) {
                    servo_claw_rotation.setPosition(0.3);

                }
//            if (gamepad2.dpad_up) {
//
//                rightArm.setTargetPosition(700);
//                leftArm.setTargetPosition(700);
//
//                rightArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//                leftArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//                rightArm.setPower(.5);
//                leftArm.setPower(.5);
//            }
//            else if (gamepad2.dpad_right) {
//
//                rightArm.setTargetPosition(350);
//                leftArm.setTargetPosition(350);
//
//                rightArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//                leftArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//                rightArm.setPower(.5);
//                leftArm.setPower(.5);
//            }
//
//            else if (gamepad2.dpad_down) {
//
//                rightArm.setTargetPosition(0);
//                leftArm.setTargetPosition(0);
//
//                rightArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//                leftArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//                rightArm.setPower(-0.5);
//                leftArm.setPower(-0.5);
//            }


            }
        }
    }