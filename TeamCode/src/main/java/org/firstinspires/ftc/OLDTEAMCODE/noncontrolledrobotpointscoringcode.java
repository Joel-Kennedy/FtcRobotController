package org.firstinspires.ftc.OLDTEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

//package org.firstinspires.ftc.teamcode;

@TeleOp(name="encoder test1")
@Disabled
public class noncontrolledrobotpointscoringcode extends LinearOpMode {

//
    DcMotor motorTEST;

    @Override
    public void runOpMode() {
        motorTEST = hardwareMap.get(DcMotor.class, "encoder");
        motorTEST.setDirection(DcMotorSimple.Direction.FORWARD);
      motorTEST.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

      motorTEST.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      motorTEST.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        while (opModeIsActive()){
             boolean down = gamepad2.dpad_down;

            motorTEST.setTargetPosition(0);
             if (down){//0
                 motorTEST.setTargetPosition(0);
                 motorTEST.setPower(1);
                 telemetry.addData("Dpad Pressed", "Down");
             } else if (gamepad2.dpad_up) {//80
                 motorTEST.setTargetPosition(80);

                         motorTEST.setPower(0.4);
                 telemetry.addData("Dpad Pressed", "Up");

             }
             else if (gamepad2.dpad_right){
                 motorTEST.setTargetPosition(500);
                                 motorTEST.setPower(0.4);
                 telemetry.addData("Dpad Pressed", "Right");
             }
             else if (gamepad2.dpad_left){
                 motorTEST.setTargetPosition(-300);
                 motorTEST.setPower(-0.4);
                 telemetry.addData("Dpad Pressed", "Left");
             }
             motorTEST.setMode(DcMotor.RunMode.RUN_TO_POSITION);

             telemetry.addData("Position", motorTEST.getCurrentPosition());
             telemetry.update();


        }
    }
}
;//his name is jimmy