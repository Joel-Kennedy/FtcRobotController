package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
//test problem fix

@TeleOp(name="competition.code!!!!")
public class forwardpropellingthrustdiviceEverything extends LinearOpMode {

     CRServo planeready;
    DcMotor backLeft;
    DcMotor spool;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;

    CRServo   servo_claw_pickup;

    CRServo servo_claw_rotation;

    DcMotor rightArm;

    DcMotor leftArm;
//        ColorSensor color1;
//        DistanceSensor distance1;
//

    //test
    @Override
    public void runOpMode() {
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        spool = hardwareMap.get(DcMotor.class, "spool");
        servo_claw_pickup = hardwareMap.get(CRServo.class, "left_hand");
        servo_claw_rotation = hardwareMap.get(CRServo.class,"claw_rotation");
        rightArm = hardwareMap.get(DcMotor.class, "rightArm");
        leftArm = hardwareMap.get(DcMotor.class, "leftArm");
        planeready = hardwareMap.get(CRServo.class,"Dronelauncher");
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

        rightArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);




        waitForStart();
        while (opModeIsActive()) {
            double leftdrive = -gamepad1.left_stick_y;
            double rightdrive = -gamepad1.left_stick_y;
            double driveright = gamepad1.left_stick_x;
            double driveleft = gamepad1.left_stick_x;
            double TURN_R = gamepad1.right_stick_x;
            double fl = leftdrive + driveleft + TURN_R;  //front left=fl
            double bl = leftdrive - driveleft + TURN_R;//back left=bl
            double fr = rightdrive - driveright + -TURN_R;//front right=fr
            double br = rightdrive + driveright + -TURN_R;//back right=br
            double spool_out = gamepad2.right_trigger;
            double spool_in = gamepad2.left_trigger;
            double joystickpos = gamepad2.left_stick_y;
            double spoolPower = Range.clip(spool_in - spool_out, -0.5, 0.5);
            double leftArmPower = Range.clip(-joystickpos, -1, 1);
            float leftarmposition;
            float rightarmposition;


            backLeft.setPower(bl * 0.5);
            backRight.setPower(br * 0.5);
            frontLeft.setPower(fl * 0.5);
            frontRight.setPower(fr * 0.5);



            spool.setPower(spoolPower);
            leftArm.setPower(-leftArmPower);
            rightArm.setPower(leftArmPower);


            telemetry.addData("speed", spoolPower);
            telemetry.addData("rightarmposition", rightArm.getCurrentPosition());
            telemetry.addData("leftarmposition", leftArm.getCurrentPosition());
            telemetry.addData("arm Power", leftArmPower);
            telemetry.addData("gamepad2 leftstick y pos", gamepad2.left_stick_y);
            telemetry.update();

            boolean claw = gamepad2.right_bumper;//closes


            boolean claw_open = gamepad2.left_bumper;//opens

            //Claw Open and Close
//            if (gamepad2.a) {
//                leftArmPower = leftArmPower *2;
//            }


            float clawUp = gamepad2.right_stick_y;//opens

            //Claw Open and Close
            if (clawUp > 0.799) {
                servo_claw_rotation.setPower(0.3);
            }
           else if (clawUp < -0.799) {
                servo_claw_rotation.setPower(-0.3);
            }
           else { servo_claw_rotation.setPower(0);}

            if (claw_open) {
                servo_claw_pickup.setPower(0.1);
            } else if (claw) {
                servo_claw_pickup.setPower(-0.1);//<(^-^)>
            }
            else  {
                servo_claw_pickup.setPower(0);
            }

//
                boolean planeisready = gamepad2.x;//shoots


                if (planeisready) {
                    planeready.setPower(-0.5);
                } else {
                    planeready.setPower(0);
                }


            //



            }
        }
    }