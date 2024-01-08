package org.firstinspires.ftc.TEAMCODE;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name ="armTesting")
@Disabled
public class armTesting extends LinearOpMode {

    DcMotor arm_forward1;

    DcMotor arm_reverse1;

    DcMotor slide_motor;

    @Override
    public void runOpMode() {


        arm_forward1 = hardwareMap.get(DcMotor.class, "arm_f");
        arm_reverse1 = hardwareMap.get(DcMotor.class, "arm_r");
        slide_motor = hardwareMap.get(DcMotor.class, "slide");


        arm_forward1.setDirection(DcMotorSimple.Direction.FORWARD);
        arm_reverse1.setDirection(DcMotorSimple.Direction.REVERSE);
        slide_motor.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

            double arm_reverse = gamepad1.left_trigger;
            double arm_forward = gamepad1.right_trigger;
            boolean extract = gamepad1.left_bumper;// extends the slide
            boolean retract = gamepad1.right_bumper;// pulls the slide back in

            arm_forward1.setPower(0.5);

        }
    }
}
