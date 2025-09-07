package org.firstinspires.ftc.teamcode;/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/*
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@TeleOp(name="Does everything but not really", group="Linear OpMode")
public class Prototype_Accelerate_Strafe_Rotate extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor FrontLeftDrive = null;
    private DcMotor FrontRightDrive = null;

    private DcMotor BackLeftDrive = null;
    private DcMotor BackRightDrive = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        FrontLeftDrive  = hardwareMap.get(DcMotor.class, "front_left_drive");
        FrontRightDrive = hardwareMap.get(DcMotor.class, "front_right_drive");
        //Set up the front and the rear motors for strafing
        BackLeftDrive  = hardwareMap.get(DcMotor.class, "back_left_drive");
        BackRightDrive = hardwareMap.get(DcMotor.class, "back_right_drive");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        FrontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        FrontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        BackLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        BackRightDrive.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            double FrontLeftPower;
            double FrontRightPower;
            //Rear motor power for strafing
            double BackLeftPower;
            double BackRightPower;

            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            /*
            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            FrontLeftPower = Range.clip(drive + turn, -1.0, 1.0) ;
            FrontRightPower = Range.clip(drive - turn, -1.0, 1.0) ;

            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
            // FrontLeftPower  = -gamepad1.left_stick_y ;
            // FrontRightPower = -gamepad1.right_stick_y ;
             */

            //New hand-spun code for the strafing wheels

            double acceleration = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double rotate = gamepad1.right_stick_x;
            double accel = 0;


            if(strafe >= 0) {
                if(rotate > 0){
                    FrontLeftPower = (strafe + rotate) /2;
                    FrontRightPower = (strafe + rotate) /2;
                    BackLeftPower = strafe-rotate;
                    BackRightPower = strafe-rotate;
                }
                else if(rotate == 0) {
                    FrontLeftPower = strafe;
                    FrontRightPower = -strafe;
                    BackLeftPower = -strafe;
                    BackRightPower = strafe;
                }
                //rotate < 0
                else{
                    FrontLeftPower = strafe + rotate;
                    FrontRightPower = strafe + rotate;
                    BackLeftPower = (strafe + rotate) /2;
                    BackRightPower = (strafe + rotate) /2;
                }
            }
            //strafe < 0
            else{
                if(rotate >0){
                    FrontLeftPower = strafe + rotate;
                    FrontRightPower = strafe + rotate;
                    BackLeftPower = (strafe + rotate) /2;
                    BackRightPower = (strafe + rotate) /2;
                }
                else if(rotate == 0){
                    FrontLeftPower = -strafe;
                    FrontRightPower = strafe;
                    BackLeftPower = strafe;
                    BackRightPower = -strafe;
                }
                //rotate<0
                else{
                    FrontLeftPower = (strafe + rotate) /2;
                    FrontRightPower = (strafe + rotate) /2;
                    BackLeftPower = strafe-rotate;
                    BackRightPower = strafe-rotate;
                }
            }
            //Weight acceleration as motor priority
            if(acceleration != 0) {
                accel = acceleration * 0.75;
                FrontLeftPower = (FrontLeftPower * .25) + accel;
                FrontRightPower = FrontRightPower * .25 + accel;
                BackLeftPower = BackLeftPower * .25 + accel;
                BackRightPower = BackRightPower * .25 + accel;
            }

            FrontLeftPower = Range.clip(FrontLeftPower, -1.0, 1.0);
            FrontRightPower = Range.clip(FrontRightPower, -1.0, 1.0);
            BackLeftPower = Range.clip(BackLeftPower, -1.0, 1.0);
            BackRightPower = Range.clip(BackRightPower, -1.0, 1.0);







            // Send calculated power to wheels
            FrontLeftDrive.setPower(FrontLeftPower);
            FrontRightDrive.setPower(FrontRightPower);
            BackLeftDrive.setPower(BackLeftPower);
            BackRightDrive.setPower(BackRightPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", FrontLeftPower, FrontRightPower);
            telemetry.update();
        }
    }
}
