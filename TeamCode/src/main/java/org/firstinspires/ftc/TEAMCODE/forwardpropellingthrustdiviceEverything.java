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

    Servo   servo;

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
        servo = hardwareMap.get(Servo.class, "left_hand");
        rightArm = hardwareMap.get(DcMotor.class,"rightArm");
        leftArm = hardwareMap.get(DcMotor.class,"leftArm");
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

        rightArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();
        while (opModeIsActive()) {
            double leftdrive = -gamepad1.left_stick_y;
            double rightdrive = -gamepad1.left_stick_y;
            double driveright = -gamepad1.left_stick_x;
            double driveleft = -gamepad1.left_stick_x;
            double TURN_R = gamepad1.right_stick_x;
            double fl = leftdrive + driveleft+ TURN_R;  //front left=fl
            double bl = leftdrive - driveleft+ TURN_R;//back left=bl
            double fr = rightdrive - driveright+ -TURN_R;//front right=fr
            double br = rightdrive + driveright+ -TURN_R;//back right=br
            double spool_out = gamepad2.right_trigger;
            double spool_in = gamepad2.left_trigger;
            double spoolPower = Range.clip(spool_in - spool_out,-0.5,0.5);
            float leftarmposition;
            float rightarmposition;

            backLeft.setPower(bl * 0.5);
            backRight.setPower(br * 0.5);
            frontLeft.setPower(fl * 0.5);
            frontRight.setPower(fr * 0.5);

            spool.setPower(spoolPower);

            telemetry.addData("speed", spoolPower);
            telemetry.update();

            boolean claw= gamepad1.dpad_right;//closes


            boolean claw_open = gamepad1.dpad_left;//opens

            //Claw Open and Close
            if (claw_open){
                servo.setPosition(0.3);
            }
            else if (claw) {
                servo.setPosition(0);
            }


        }
    }
}