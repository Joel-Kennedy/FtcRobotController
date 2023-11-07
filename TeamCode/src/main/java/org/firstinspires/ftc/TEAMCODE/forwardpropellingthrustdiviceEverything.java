package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="compition.code!!!!")
public class forwardpropellingthrustdiviceEverything extends LinearOpMode {


    DcMotor backLeft;
    DcMotor Cf;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;

    Servo   servo;
//        ColorSensor color1;
//        DistanceSensor distance1;
//        BNO055IMU imu;

    @Override
    public void runOpMode() {
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        Cf = hardwareMap.get(DcMotor.class, "ChickenFingers");
        servo = hardwareMap.get(Servo.class, "left_hand");
        //           color1 = hardwareMap.get(ColorSensor.class, "color1");
//            distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
//            imu = hardwareMap.get(BNO055IMU.class, "imu");
        backLeft.setDirection(DcMotor.Direction.REVERSE);//-
        backRight.setDirection(DcMotor.Direction.FORWARD);//+
        frontLeft.setDirection(DcMotor.Direction.REVERSE);//-
        frontRight.setDirection(DcMotor.Direction.REVERSE);//+
        Cf.setDirection(DcMotorSimple.Direction.FORWARD);//+
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
            double CF = gamepad2.right_trigger;
            double CFR = gamepad2.left_trigger;





            backLeft.setPower(bl * 0.5);
            backRight.setPower(br * 0.5);
            frontLeft.setPower(fl * 0.5);
            frontRight.setPower(fr * 0.5);




            Cf.setPower(CF - CFR);


            telemetry.addData("speed", CF - CFR);
            telemetry.update();

            boolean claw= gamepad1.dpad_right;//closes


            boolean claw_open = gamepad1.dpad_left;//opens

            if (claw_open){
                servo.setPosition(1);

            } else if (claw) {

                servo.setPosition(0);

            }



            {

            }
        }
    }
}