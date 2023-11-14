package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class SHORTIE_AUTO extends LinearOpMode
{
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;
    static final double     FORWARD_SPEED = 0.5;
    static final double     REVERSE_SPEED = -0.5;
    static final double     TURN_SPEED    = 0.5;
    static final double     TURN_SPEED_RE    = -0.5;// RE = REVERSE
    static final double     CF_speed      = 0.5;
    static final double     CF_speed_RE      = -0.5;// RE = REVERSE

    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

//
//        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
//        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        backLeft.setDirection(DcMotor.Direction.REVERSE);//-
        backRight.setDirection(DcMotor.Direction.FORWARD);//+
        frontLeft.setDirection(DcMotor.Direction.REVERSE);//-
        frontRight.setDirection(DcMotor.Direction.REVERSE);//+
        waitForStart();
        //H H EEE
     //   H H E
      //  HHH EEE
     //   H H E
     //   H H EEE
        backLeft.setPower(REVERSE_SPEED);
        backRight.setPower(REVERSE_SPEED);
        frontLeft.setPower(REVERSE_SPEED);
        frontRight.setPower(REVERSE_SPEED);
        sleep(2499);
        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);

    }
}
