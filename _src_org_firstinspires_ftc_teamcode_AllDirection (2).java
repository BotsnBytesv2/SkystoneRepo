/*
Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *23
 * Redistributions in binary form must reproduce  /`the above copyright notice, this
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

package org.firstinspires.ftc.competitioncode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.android.AndroidTextToSpeech;
/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
**/


@TeleOp(name = "AllDirection", group = "Concept")


public class AllDirection extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontleftmotor = null;
    private DcMotor frontrightmotor = null;
    private DcMotor backleftmotor = null;
    private DcMotor backrightmotor = null;
    private Servo movingFoundation1 = null;
    private Servo movingFoundation2 = null;
    private DcMotor intake1 = null;
    private DcMotor intake2 = null;
    private DcMotor arm = null;
    private CRServo rotateNub = null;
    private CRServo grabNub = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Working");
        telemetry.update();

        
       
        frontleftmotor = hardwareMap.get(DcMotor.class, "frontleftmotor");
        frontrightmotor = hardwareMap.get(DcMotor.class, "frontrightmotor");
        backrightmotor = hardwareMap.get(DcMotor.class, "backrightmotor");
        backleftmotor = hardwareMap.get(DcMotor.class, "backleftmotor");
        movingFoundation1 = hardwareMap.get(Servo.class, "movingFoundation1");
        movingFoundation2 = hardwareMap.get(Servo.class, "movingFoundation2");
        intake1 = hardwareMap.get(DcMotor.class, "intake1");
        intake2 = hardwareMap.get(DcMotor.class, "intake2");
        arm = hardwareMap.get(DcMotor.class, "arm");
        rotateNub = hardwareMap.get(CRServo.class, "rotateNub");
        grabNub = hardwareMap.get(CRServo.class, "grabNub");
        
        
        frontleftmotor.setPower(0.0);
        frontrightmotor.setPower(0.0);
        backleftmotor.setPower(0.0);
        backrightmotor.setPower(0.0);
        arm.setPower(0.0);
        rotateNub.setPower(0.0);
        grabNub.setPower(0.0);
        
        
        
        movingFoundation1.setPosition(1.0);
        movingFoundation2.setPosition(0.0);
        
        
        intake1.setPower(0.0);
        intake2.setPower(0.0);
        
        
        
        frontleftmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontrightmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backrightmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backleftmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
        /*output1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        output2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);*/
        
        
        
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();
        double constant1 = 1.0;

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {


            if(gamepad1.dpad_down == true && constant1 == 1.0){
                constant1 = 0.6;
            }
            
            else if(gamepad1.dpad_up == true && constant1 == 0.6){
                constant1 = 1.0;
            }
            else{
                
            }
            
            //lTrigger = gamepad1.left_trigger;
            //rTrigger = gamepad1.right_trigger;
            
            //This moves the base
            double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;
            final double v1 = -r * Math.sin(robotAngle) + rightX;
            final double v2 = r * Math.cos(robotAngle) + rightX;
            final double v3 = -r * Math.cos(robotAngle) + rightX;
            final double v4 = r * Math.sin(robotAngle) + rightX;

            frontleftmotor.setPower(-v1*constant1);
            frontrightmotor.setPower(-v2*constant1);
            backleftmotor.setPower(-v3*constant1);
            backrightmotor.setPower(-v4*constant1);
            
            if (gamepad1.a){
                movingFoundation1.setPosition(1.0);
                movingFoundation2.setPosition(0.0);
            }
            
            if(gamepad1.b){
                movingFoundation1.setPosition(0.3);
                movingFoundation2.setPosition(0.7);
            }
            
            
            if(gamepad2.right_stick_y == -1.0){
                arm.setPower(0.6);
            }
            else if(gamepad2.right_stick_y == 1.0){
                arm.setPower(-0.6);
            }
            else{
                arm.setPower(0.0);
            }
            
            if(gamepad1.left_trigger > 0){
                intake1.setPower(1.0);
                intake2.setPower(-1.0);
            }
            
            else if(gamepad1.right_trigger > 0){
                intake1.setPower(-1.0);
                intake2.setPower(1.0);
            }
            
            else{
                intake1.setPower(0.0);
                intake2.setPower(0.0);
            }
            if(gamepad2.x){
               rotateNub.setPower(0.7);
            }
            else if(gamepad2.y){
                rotateNub.setPower(-0.7);
            }
            else{
                rotateNub.setPower(0.0);
            }
            if(gamepad2.a){
                grabNub.setPower(0.9);
            }
            if(gamepad2.b){
                grabNub.setPower(-0.9);
            }
            
            
            
            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Mode", constant1);
            //telemetry.addData("Motors", "one (%.2f), two (%.2f), servoone (%.2f), servotwo (%.2f)", onePower, twoPower, servo1pos, servo2pos);
            telemetry.update();
        }
    }
}
