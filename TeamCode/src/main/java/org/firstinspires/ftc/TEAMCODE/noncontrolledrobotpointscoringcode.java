package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

//package org.firstinspires.ftc.teamcode;

//        import com.qualcomm.hardware.bosch.BNO055IMU;
//        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
 //       import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
 //       import com.qualcomm.robotcore.hardware.ColorSensor;
 //       import com.qualcomm.robotcore.hardware.DcMotor;
 //       import com.qualcomm.robotcore.hardware.DistanceSensor;
@TeleOp(name="thetestcodethatwilllaterdefinethewaythaturprolongedarmilworkinourcompitition")
public class noncontrolledrobotpointscoringcode extends LinearOpMode {


    DcMotor motorTEST;

    @Override
    public void runOpMode() {
        motorTEST = hardwareMap.get(DcMotor.class, "themotorthatwilllaterdefineourarmpointscoringways");
        motorTEST.setDirection(DcMotorSimple.Direction.FORWARD);
      motorTEST.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();
        while (opModeIsActive());{
             boolean down = gamepad2.dpad_down                                         ;
             if (down){//0
                 motorTEST.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                 motorTEST.setTargetPosition(0);
                 motorTEST.setPower(1);
             } else if (gamepad2.dpad_up) {//80
                 motorTEST.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                 motorTEST.setTargetPosition(0);
                         motorTEST.setPower(1);

             }
             else if (gamepad2.dpad_right){
                   motorTEST.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                 motorTEST.setTargetPosition(0);
                                 motorTEST.setPower(1);
             }
            {
        }}}}