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
    static final double     TURN_SPEED    = 0.5;

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

        backLeft.setPower(FORWARD_SPEED);
        backRight.setPower(FORWARD_SPEED);
        frontLeft.setPower(FORWARD_SPEED);
        frontRight.setPower(FORWARD_SPEED);

        sleep(2500);

    }
}
// williams expiriment
