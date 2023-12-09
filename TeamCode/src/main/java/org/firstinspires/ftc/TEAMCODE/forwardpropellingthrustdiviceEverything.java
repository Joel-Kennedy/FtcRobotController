package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

//test problem fix
//
@TeleOp(name="competition.code!!!!")
public class forwardpropellingthrustdiviceEverything extends LinearOpMode {

     CRServo planeready;
    CRServo  servo1;
    CRServo           servo2;

    CRServo servoZero;

    CRServo            servo3;
    DcMotor backLeft;
    DcMotor spool;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;

    DcMotor skyhook;


    DcMotor rightArm;

    DcMotor leftArm;
//        ColorSensor color1;
//        DistanceSensor distance1;
//

    //test
    @Override
    public void runOpMode() {

        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        spool = hardwareMap.get(DcMotor.class, "spool");

        rightArm = hardwareMap.get(DcMotor.class, "rightArm");
        leftArm = hardwareMap.get(DcMotor.class, "leftArm");
        planeready = hardwareMap.get(CRServo.class,"Dronelauncher");
        servo1 = hardwareMap.get(CRServo.class, "left_hand");
        servo2 = hardwareMap.get(CRServo.class, "right_hand");
        servoZero = hardwareMap.get(CRServo.class,"arm.extender");
        servo3 =hardwareMap.get(CRServo.class,"claw.rotation");
        skyhook = hardwareMap.get(DcMotor.class,"skyhook23695");
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
        skyhook.setDirection(DcMotorSimple.Direction.FORWARD);

        rightArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);




        waitForStart();
        while (opModeIsActive()) {
            double leftdrive = -gamepad1.left_stick_y;
            double rightdrive = -gamepad1.left_stick_y;
            double driveright = gamepad1.left_stick_x;
            double driveleft = gamepad1.left_stick_x;
            double TURN_R = gamepad1.right_stick_x;
            double fl = leftdrive + driveleft + TURN_R;  //front left=fl
            double bl = leftdrive - driveleft + TURN_R;//back left=bl
            double fr = rightdrive - driveright + -TURN_R;//front right=fr
            double br = rightdrive + driveright + -TURN_R;//back right=br
            boolean sk = gamepad2.dpad_up;




            float leftarmposition;
            float rightarmposition;


            backLeft.setPower(bl * 0.5);
            backRight.setPower(br * 0.5);
            frontLeft.setPower(fl * 0.5);
            frontRight.setPower(fr * 0.5);



        






            telemetry.addData("rightarmposition", rightArm.getCurrentPosition());
            telemetry.addData("leftarmposition", leftArm.getCurrentPosition());

            telemetry.addData("gamepad2 leftstick y pos", gamepad2.left_stick_y);
            telemetry.update();




            //Claw Open and Close
//            if (gamepad2.a) {
//                leftArmPower = leftArmPower *2;
//            }

            boolean claw= gamepad1.b;//closes
            boolean claw_open = gamepad1.a;//opens
            float clawUp = gamepad2.right_stick_y;//opens

            //Claw Open and Close


//
                boolean planeisready = gamepad2.x;//shoots


                if (planeisready) {
                    planeready.setPower(-0.5);
                } else {
                    planeready.setPower(0);
                }
                if(sk){
                    skyhook.setPower(.5);
                }
                else if (gamepad2.dpad_down) {

                    skyhook.setPower(-1);
                }

                else {

                    skyhook.setPower(0);

            }
                  

            boolean rotation = gamepad1.dpad_up;

            boolean rotationRe = gamepad1.dpad_down;



            boolean extension = gamepad1.left_bumper;

            boolean extensionRe =gamepad1.right_bumper;

            if (extension){

                servoZero.setPower(.2);
            } else if (extensionRe){

                servoZero.setPower(-.2);

            }

            else {
                servoZero.setPower(0);
            }
            if (claw_open) {
                servo1.setPower(.2);
                servo2.setPower(-.2);



            } else if (claw) {
                servo1.setPower(-.2);
                servo2.setPower(.2);

            }


            else {
                servo1.setPower(0);
                servo2.setPower(0);
            }

            if (rotation){
                servo3.setPower(.2);
            }
            else if (rotationRe){
                servo3.setPower(-.2);
            }

            else{
                servo3.setPower(0);
            }


            //



            }
        }
    }