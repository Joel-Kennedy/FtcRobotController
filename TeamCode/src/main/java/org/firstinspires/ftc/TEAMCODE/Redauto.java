package org.firstinspires.ftc.TEAMCODE;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.TEAMCODE.vision.examplered;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;


@Autonomous(name = "Red ")
public class Redauto extends LinearOpMode {
    OpenCvWebcam webcam;
    examplered pipeline = new examplered(telemetry);

    private DcMotor backLeft   = null;
    private DcMotor         backRight  = null;

    private DcMotor         frontRight  = null;

    private DcMotor         frontLeft  = null;

    CRServo servo1;

    DcMotor extention;

    DcMotor rightArm;
    DcMotor leftArm;



    @Override
    public void runOpMode() {

        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        servo1 = hardwareMap.get(CRServo.class, "left_hand");
        extention = hardwareMap.get(DcMotor.class, "spool");//this is arm extention

        rightArm.setDirection(DcMotorSimple.Direction.FORWARD);//+
        leftArm.setDirection(DcMotorSimple.Direction.REVERSE);//-
        extention.setDirection(DcMotorSimple.Direction.FORWARD);//+
        backLeft.setDirection(DcMotor.Direction.REVERSE);//-
        backRight.setDirection(DcMotor.Direction.FORWARD);//+
        frontLeft.setDirection(DcMotor.Direction.REVERSE);//-
        frontRight.setDirection(DcMotor.Direction.REVERSE);//+


        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



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

        servo1.setPower(-0.1);

        goStraight(750,0.3,500);

        turnL_R(-450,0.3,500);

        goStraight(460,0.3,500);

        goStraight(-460,0.3,500);

        turnL_R(450,0.3,500);

        strafeRight(-1100,.3, 500);

        /////////////////////////////////////////////////////////////////////

        goStraight(1500,.3, 500);
        ////////////////////////////////////////////////////////////////turn left

        turnL_R(900,0.3,500);

        ////////////////////////////////////////////////////////ending straight

        goStraight(4400,0.3,1000);
        ///////////////////////////////////////////////////////////////////////
        strafeRight(-1000,0.3, 1000);
        ////////////////////////////////////////////////////////////////////
        armposition(600,0.3,1000);
        ///////////////////////////////////////////////////////
        extention.setPower(0.8);
        sleep(1000);
        /////////////////////////////////
        servo1.setPower(0.2);
        sleep(1500);
        //////////////////////////////////////
        goStraight(-200,0.3,1000);

    }

    void Center() {
        servo1.setPower(-0.1);

        goStraight(1450,0.3,1500);

////////////////////////////////////////////////////////////////////////backing up
        goStraight(-500,0.3,1500);

        ///////////////////////////////////////////////////////////////////strafe right

        strafeRight(-1050,.3, 1500);

        /////////////////////////////////////////////////////////////////////

        goStraight(1400,.3, 1000);
        ////////////////////////////////////////////////////////////////turn left

        turnL_R( 900,0.3,1500);

        ////////////////////////////////////////////////////////ending straight

        goStraight(4400,0.3,1000);
        ///////////////////////////////////////////////////////////////////////
        strafeRight(-1000,0.3, 1000);
        ////////////////////////////////////////////////////////////////////
        armposition(600,0.3,1000);
        ///////////////////////////////////////////////////////
        extention.setPower(0.8);
        sleep(1000);
        /////////////////////////////////
        servo1.setPower(0.2);
        sleep(1500);
        //////////////////////////////////////
        goStraight(-200,0.3,1000);

    }

    void Right() {

        servo1.setPower(-0.1);

        goStraight(750,0.3,1000);

        turnL_R(450,0.3,1000);

        goStraight(530,0.3,1000);

        goStraight(-530,0.3,1000);

        turnL_R(-450,0.3,1000);

        strafeRight(-1100,.3, 1500);

        /////////////////////////////////////////////////////////////////////

        goStraight(1550,.3, 1000);
        ////////////////////////////////////////////////////////////////turn left

        turnL_R(900,0.3,1500);

        ////////////////////////////////////////////////////////ending straight

        goStraight(4400,0.3,1000);
        ///////////////////////////////////////////////////////////////////////
        strafeRight(-1000,0.3, 1000);
        ////////////////////////////////////////////////////////////////////
        armposition(600,0.3,1000);
        ///////////////////////////////////////////////////////
        extention.setPower(0.8);
        sleep(1000);
        /////////////////////////////////
        servo1.setPower(0.2);
        sleep(1500);
        //////////////////////////////////////
        goStraight(-200,0.3,1000);






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