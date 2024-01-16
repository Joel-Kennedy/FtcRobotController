package org.firstinspires.ftc.TEAMCODE;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
@Disabled
public class athomeauto extends LinearOpMode {

    DcMotor backLeft;

    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;

    DcMotor leftarm;
    DcMotor rightarm;


    private ElapsedTime runtime = new ElapsedTime();

    static final double     FORWARD_SPEED = 0.5;

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // No External Gearing.
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);

    static final double     arm_Speed = 0.5;

    @Override
    public void runOpMode() {

        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        leftarm=hardwareMap.get(DcMotor.class,"leftarm");
        rightarm=hardwareMap.get(DcMotor.class,"rightarm");

        rightarm.setDirection(DcMotorSimple.Direction.FORWARD);//+
        leftarm.setDirection(DcMotorSimple.Direction.REVERSE);//-
        backLeft.setDirection(DcMotor.Direction.REVERSE);//-
        backRight.setDirection(DcMotor.Direction.FORWARD);//+
        frontLeft.setDirection(DcMotor.Direction.REVERSE);//-
        frontRight.setDirection(DcMotor.Direction.REVERSE);//+

        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backLeft.setPower(FORWARD_SPEED);
        backRight.setPower(FORWARD_SPEED);
        frontLeft.setPower(FORWARD_SPEED);
        frontRight.setPower(FORWARD_SPEED);





    }
}

