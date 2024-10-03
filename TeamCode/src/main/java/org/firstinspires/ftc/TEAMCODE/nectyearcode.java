package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp ( name = "goodcode")

public class nectyearcode extends LinearOpMode {
    DcMotor backLeft;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor frontRight;

    @Override
    public void runOpMode() {
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        backLeft.setDirection(DcMotor.Direction.REVERSE);//-
        backRight.setDirection(DcMotor.Direction.FORWARD);//+
        frontLeft.setDirection(DcMotor.Direction.REVERSE);//-
        frontRight.setDirection(DcMotor.Direction.REVERSE);//+

        while (opModeIsActive()) {
            double leftdrive = -gamepad1.left_stick_y;
            double rightdrive = -gamepad1.left_stick_y;
            double driveright = gamepad1.left_stick_x;
            double driveleft = gamepad1.left_stick_x;
            double TURN_R = gamepad1.right_stick_x;
            double fl = leftdrive + driveleft + TURN_R;  //front left=fl
            double bl = leftdrive - driveleft + TURN_R;//back left=bl
            double fr = rightdrive - driveright - TURN_R;//front right=fr
            double br = rightdrive + driveright - TURN_R;//back right=br

            float wheelSpeed = 0.5F;

            backLeft.setPower(bl * wheelSpeed);
            backRight.setPower(br * wheelSpeed);
            frontLeft.setPower(fl * wheelSpeed);
            frontRight.setPower(fr * wheelSpeed);

            if (gamepad1.right_bumper) {


                backLeft.setPower(bl * 1);
                backRight.setPower(br * 1);
                frontLeft.setPower(fl * 1);
                frontRight.setPower(fr * 1);

            }

            else {

                backLeft.setPower(bl * wheelSpeed);
                backRight.setPower(br * wheelSpeed);
                frontLeft.setPower(fl * wheelSpeed);
                frontRight.setPower(fr * wheelSpeed);}


            telemetry.addData("gamepad2 leftstick y pos", gamepad2.left_stick_y);
            telemetry.addData("Starting at", "%7d :%7d %7d :%7d",
                    frontRight.getCurrentPosition(),
                    backRight.getCurrentPosition(),
                    frontLeft.getCurrentPosition(),
                    backLeft.getCurrentPosition());

            telemetry.update();
        }
    }
}
