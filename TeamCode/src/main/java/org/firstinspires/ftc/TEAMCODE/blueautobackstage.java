package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.TEAMCODE.vision.exampleblue;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

@Autonomous(name = "bluebackstage ")

public class blueautobackstage extends LinearOpMode  {

        OpenCvWebcam webcam;
        exampleblue pipeline = new exampleblue(telemetry);


        private DcMotor backLeft   = null;
        private DcMotor         backRight  = null;

        private DcMotor         frontRight  = null;

        private DcMotor         frontLeft  = null;

        DcMotor rightArm;
        DcMotor leftArm;

        CRServo servo1;

        DcMotor extention;

        CRServo servo3;



        @Override
        public void runOpMode() {

            backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            backRight = hardwareMap.get(DcMotor.class, "backRight");
            frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
            frontRight = hardwareMap.get(DcMotor.class, "frontRight");
            rightArm = hardwareMap.get(DcMotor.class, "rightArm");
            leftArm = hardwareMap.get(DcMotor.class, "leftArm");
            servo3 = hardwareMap.get(CRServo.class,"claw.rotation");

            servo1 = hardwareMap.get(CRServo.class, "left_hand");
            extention = hardwareMap.get(DcMotor.class, "spool");//this is arm extention

            backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            rightArm.setDirection(DcMotorSimple.Direction.FORWARD);//+
            leftArm.setDirection(DcMotorSimple.Direction.REVERSE);//-
            extention.setDirection(DcMotorSimple.Direction.FORWARD);//+





            backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


            int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
            webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
            webcam.setPipeline(pipeline);
            webcam.setMillisecondsPermissionTimeout(5000); // Timeout for obtaining permission is configurable. Set before opening.
            webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
                @Override
                public void onOpened() {
                    webcam.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);
                }

                @Override
                public void onError(int errorCode) {
                }
            });


            telemetry.addLine("Waiting for start");
            telemetry.update();





            waitForStart();

            String result = pipeline.getResult();
            webcam.stopStreaming();
            webcam.closeCameraDevice();

            if (result == "Left") Left();
            if (result == "Center") Center();
            if (result == "Right") Right();

            while (opModeIsActive()) {
                telemetry.update();
                sleep(100);

            }
        }

        void Left() {
            goStraight(750,0.3,500);

            turnL_R(-450,0.3,500);

            goStraight(430,0.3,500);

            goStraight(-430,0.3,500);

            turnL_R(450,0.3,500);

            goStraight(-100,0.3,500);

            turnL_R(-850,0.3,500);

            servo1.setPower(0.2);
            sleep(500);
            servo1.setPower(0);

            ////////////////////////////////////////////////////////////
            goStraight(1310,0.3,500);
            /////////////////////////////////////////////////////////
            strafeRight(250,0.3,500);
            //////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////


            ////////////////////////////////////////////////////////////////////
            armposition(350,0.3,1000);
            //////////////////////////////////////////////////////

            sleep(1000);

            extention.setPower(-0.8);
            sleep(2000);
            extention.setPower(0);

            //armposition(350,0.3,250);
            ///////////////////////////////
            goStraight(320,0.3,250);

            servo3.setPower(0.5);
            sleep(225);
            servo3.setPower(0);
            //////////////////////////////////////
            goStraight(-50,0.3,250);
            extention.setPower(0.8);
            sleep(2000);
            extention.setPower(0);

            strafeRight(-1145,0.3,250);


        }

        void Center() {


            goStraight(1450,0.3,500);

////////////////////////////////////////////////////////////////////////backing up

            goStraight(-500,0.3,500);

            ///////////////////////////////////////////////////////////////////strafe right
            turnL_R(-850,0.3,500);

            servo1.setPower(0.2);
            sleep(500);
            servo1.setPower(0);

            ////////////////////////////////////////////////////////////
            goStraight(1310,0.3,500);
            /////////////////////////////////////////////////////////
            strafeRight(270,0.3,500);
            //////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////


            ////////////////////////////////////////////////////////////////////
            armposition(350,0.3,1000);
            //////////////////////////////////////////////////////

            sleep(1000);

            extention.setPower(-0.8);
            sleep(2000);
            extention.setPower(0);

            //armposition(350,0.3,250);
            ///////////////////////////////
            goStraight(320,0.3,250);

            servo3.setPower(0.5);
            sleep(225);
            servo3.setPower(0);
            //////////////////////////////////////
            goStraight(-100,0.3,250);
            extention.setPower(0.8);
            sleep(2000);
            extention.setPower(0);

            strafeRight(-1195,0.3,250);





        }

        void Right() {
            goStraight(750,0.3,500);

            turnL_R(450,0.3,500);

            goStraight(530,0.3,500);

            goStraight(-530,0.3,500);

            turnL_R(-450,0.3,500);

            goStraight(-100,0.3,500);

            turnL_R(-850,0.3,500);

            servo1.setPower(0.2);
            sleep(500);
            servo1.setPower(0);

            ////////////////////////////////////////////////////////////
            goStraight(1310,0.3,500);
            /////////////////////////////////////////////////////////
            strafeRight(900,0.3,500);
            //////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////


            ////////////////////////////////////////////////////////////////////
            armposition(350,0.3,1000);
            //////////////////////////////////////////////////////

            sleep(1000);

            extention.setPower(-0.8);
            sleep(2000);
            extention.setPower(0);

            //armposition(350,0.3,250);
            ///////////////////////////////
            goStraight(320,0.3,250);

            servo3.setPower(0.5);
            sleep(225);
            servo3.setPower(0);
            //////////////////////////////////////
            goStraight(-50,0.3,250);
            extention.setPower(0.8);
            sleep(2000);
            extention.setPower(0);

            strafeRight(-1495,0.3,250);






        }



        void strafeRight(int distance,double power,long sleeptime){
            backLeft.setTargetPosition(distance + backLeft.getCurrentPosition());
            frontLeft.setTargetPosition(-distance + frontLeft.getCurrentPosition() );
            backRight.setTargetPosition(distance + backRight.getCurrentPosition());
            frontRight.setTargetPosition(distance + frontRight.getCurrentPosition());

            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            backLeft.setPower(power);
            backRight.setPower(power);
            frontLeft.setPower(power);
            frontRight.setPower(power);

            while (opModeIsActive() && backRight.isBusy()){
                idle();

            }
            backLeft.setPower(0);
            backRight.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
            sleep(sleeptime);

        }

        void goStraight(int distance, double power, long sleeptime){





            backLeft.setTargetPosition(-distance + backLeft.getCurrentPosition());
            frontLeft.setTargetPosition(-distance + frontLeft.getCurrentPosition());
            backRight.setTargetPosition(distance + backRight.getCurrentPosition());
            frontRight.setTargetPosition(-distance + frontRight.getCurrentPosition());
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            backLeft.setPower(power);
            backRight.setPower(power);
            frontLeft.setPower(power);
            frontRight.setPower(power);

            while (opModeIsActive() && backRight.isBusy()){
                idle();

            }
            backLeft.setPower(0);
            backRight.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
            sleep(sleeptime);

        }

        void turnL_R(int distance, double power, long sleeptime) {

            // negative = left
            //positive = right
            backLeft.setTargetPosition(-distance + backLeft.getCurrentPosition());
            frontLeft.setTargetPosition(-distance + frontLeft.getCurrentPosition());
            backRight.setTargetPosition(-distance + backRight.getCurrentPosition());
            frontRight.setTargetPosition(distance + frontRight.getCurrentPosition());
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            backLeft.setPower(power);
            backRight.setPower(power);
            frontLeft.setPower(power);
            frontRight.setPower(power);

            while (opModeIsActive() && backRight.isBusy()) {
                idle();

            }
            backLeft.setPower(0);
            backRight.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
            sleep(sleeptime);
        }

        void armposition (int distance,double power, long sleeptime) {

            rightArm.setTargetPosition(distance + rightArm.getCurrentPosition());
            leftArm.setTargetPosition(distance + leftArm.getCurrentPosition());

            rightArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);



            rightArm.setPower(power);
            leftArm.setPower(power);


        }
    }


