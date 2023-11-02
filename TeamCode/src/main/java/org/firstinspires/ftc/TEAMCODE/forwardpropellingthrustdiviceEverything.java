package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="compition.code!!!!")
public class forwardpropellingthrustdiviceEverything extends LinearOpMode {


    DcMotor backLeft;
    DcMotor Cf;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;
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
            double fl = leftdrive + driveleft;  //front left=fl
            double bl = leftdrive - driveleft;//back left=bl
            double fr = rightdrive - driveright;//front right=fr
            double br = rightdrive + driveright;//back right=br

            backLeft.setPower(bl * 0.5);
            backRight.setPower(br * 0.5);
            frontLeft.setPower(fl * 0.5);
            frontRight.setPower(fr * 0.5);


            double CF = gamepad2.right_trigger;
            double CFR = gamepad2.left_trigger;

            Cf.setPower(CF - CFR);


            telemetry.addData("speed", CF - CFR);
            telemetry.update();

            {

            }
        }
    }
}