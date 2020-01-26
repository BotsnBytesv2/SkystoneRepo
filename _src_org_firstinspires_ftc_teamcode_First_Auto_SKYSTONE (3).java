package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
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

@Autonomous(name = "Test_AUTO_SKYSTONE", group = "Concept")

public class First_Auto_SKYSTONE extends LinearOpMode{
    
    private ElapsedTime runtime = new ElapsedTime();
    
    private static DcMotor frontleftmotor = null;
    private static DcMotor frontrightmotor = null;
    private static DcMotor backleftmotor = null;
    private static DcMotor backrightmotor = null;
    
    double frontleftspeed = -0.8;
    double frontrightspeed = -0.8;
    double backleftspeed = -0.8;
    double backrightspeed = -0.8;
    
    
    public void runOpMode(){
        //initialize
        frontleftmotor = hardwareMap.get(DcMotor.class, "frontleftmotor");
        frontrightmotor = hardwareMap.get(DcMotor.class, "frontrightmotor");
        backrightmotor = hardwareMap.get(DcMotor.class, "backrightmotor");
        backleftmotor = hardwareMap.get(DcMotor.class, "backleftmotor");
        
        frontleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        
        
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        
        
        frontleftmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontrightmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backrightmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backleftmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
        
        waitForStart();
        
        //distanceCalculate(12.57, 'f');
        //sleep(3);
        //straferight(5);
        //strafeleft(5);
        //distanceCalculate(12.57, 'f');
        sleep(3);
       //moveForward(1);
        //spinleft(90);
        //telemetry.addLine("happyyyyyyyyyyyy");
        stop();
       //sleep(10000);
        
      // moveBackward(90);
        
        //sleep(100);
        
        
    }

    private void testMoveForward(){
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setTargetPosition(-560);
        frontleftmotor.setTargetPosition(560);
        backrightmotor.setTargetPosition(-560);
        backleftmotor.setTargetPosition(560);
        
        frontrightmotor.setPower(frontrightspeed);
        frontleftmotor.setPower(-frontleftspeed);
        backrightmotor.setPower(-backrightspeed);
        backleftmotor.setPower(backleftspeed);
        
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
         while(opModeIsActive() && (frontleftmotor.isBusy() || frontrightmotor.isBusy() || backrightmotor.isBusy() || backleftmotor.isBusy()) ){

         // run till the motors are busy going the distance 
        }
        stopMotor1();
        

    }
    // Function to move the robot Forward based on the distance and motor ticks using encoder. 
    private void moveForward(double distance){
        int distance_real = (int) distance; 
        telemetry.addData("The distance:", distance);
        
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        
        
        frontrightmotor.setTargetPosition(-distance_real);
        frontleftmotor.setTargetPosition(distance_real);
        backrightmotor.setTargetPosition(-distance_real);
        backleftmotor.setTargetPosition(distance_real);
        
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontrightmotor.setPower(-frontrightspeed);
        frontleftmotor.setPower(frontleftspeed);
        backrightmotor.setPower(-backrightspeed);
        backleftmotor.setPower(backleftspeed);
    
  
        telemetry.addData("The current position is:",(-frontleftmotor.getCurrentPosition()));
        telemetry.addData("The current position divided by 1120:",(-frontleftmotor.getCurrentPosition()/1120));
        telemetry.addData("The  current position :",(-frontleftmotor.getCurrentPosition()%1120));
        telemetry.addData("The motor state:",frontleftmotor.isBusy());
        telemetry.addData("Conditions:", (frontleftmotor.getCurrentPosition())< distance_real);
        
        

        while(opModeIsActive() && (frontleftmotor.isBusy() || frontrightmotor.isBusy() || backrightmotor.isBusy() || backleftmotor.isBusy()) ){

         // run till the motors are busy going the distance 
        }
        stopMotor1();
    }



    // Function to move backward using motor ticks and encoder. 
    private void moveBackward(double distance){
        int distance_real = (int) distance;

        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setTargetPosition(distance_real);
        frontleftmotor.setTargetPosition(-distance_real);
        backrightmotor.setTargetPosition(distance_real);
        backleftmotor.setTargetPosition(-distance_real);
        
        frontrightmotor.setPower(frontrightspeed);
        frontleftmotor.setPower(-frontleftspeed);
        backrightmotor.setPower(backrightspeed);
        backleftmotor.setPower(-backleftspeed);
        
        
        while(opModeIsActive() && (frontleftmotor.isBusy() || frontrightmotor.isBusy() || backrightmotor.isBusy() || backleftmotor.isBusy()) ){

         // run till the motors are busy going the distance 
        }
        stopMotor1();
    }

    // Function to spin robot by the provided degrees
    private void spinleft(double degrees){
        telemetry.addLine("in spin left");
        int distance_spin = (int) (degrees * 935/90);
        
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        telemetry.addLine("Ran to position");
        telemetry.addData("Encoder position", frontleftmotor.getCurrentPosition());
        telemetry.update();
        
        frontrightmotor.setTargetPosition(-distance_spin);
        frontleftmotor.setTargetPosition(-distance_spin);
        backrightmotor.setTargetPosition(-distance_spin);
        backleftmotor.setTargetPosition(-distance_spin);
        
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        runtime.reset();
        telemetry.addLine("Ran to position");
        telemetry.addData("Encoder position", frontleftmotor.getCurrentPosition());
        telemetry.update();
        
        frontrightmotor.setPower(-frontrightspeed);
        frontleftmotor.setPower(-frontleftspeed);
        backrightmotor.setPower(-backrightspeed);
        backleftmotor.setPower(-backleftspeed);
        
        
        //while(opModeIsActive() && (-frontleftmotor.getCurrentPosition())< distance_spin ){
            
          // opModeIsActive() && frontleft.isBusy() && frontright.isBusy() && backleft.isBusy() && backright.isBusy()){
         // telemetry.addData("The Target is:",frontleft.getTargetPosition());
         telemetry.addData("The current position is:",(-frontleftmotor.getCurrentPosition()));
       
        telemetry.addData("The current position is:",(-frontleftmotor.getCurrentPosition()/1120));
        telemetry.addData("The  position reminder:",(-frontleftmotor.getCurrentPosition()%1120));
        //telemetry.addData("The set position is:",frontleftmotor.isBusy());
        
        
        //}

        while(opModeIsActive() && (frontleftmotor.isBusy() || frontrightmotor.isBusy() || backrightmotor.isBusy() || backleftmotor.isBusy()) ){


         // run till the motors are busy going the distance 
        }
        
    }


    // Function to spin the robot to the right  the amount of degrees needed
    private void spinright(double degrees){
        int distance_spin = (int) (degrees * 935/90);

        
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontrightmotor.setTargetPosition(distance_spin);
        frontleftmotor.setTargetPosition(distance_spin);
        backrightmotor.setTargetPosition(distance_spin);
        backleftmotor.setTargetPosition(distance_spin);

        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        runtime.reset();

        frontrightmotor.setPower(frontrightspeed);
        frontleftmotor.setPower(frontleftspeed);
        backrightmotor.setPower(backrightspeed);
        backleftmotor.setPower(backleftspeed);

        //while(opModeIsActive() && (-frontleftmotor.getCurrentPosition())< distance_spin ){
            
          // opModeIsActive() && frontleft.isBusy() && frontright.isBusy() && backleft.isBusy() && backright.isBusy()){
       // telemetry.addData("The Target is:",frontleft.getTargetPosition());
         telemetry.addData("The current position is:",(-frontleftmotor.getCurrentPosition()));
       
        telemetry.addData("The current position is:",(-frontleftmotor.getCurrentPosition()/1120));
        telemetry.addData("The  position reminder:",(-frontleftmotor.getCurrentPosition()%1120));
        telemetry.addData("The set position is:",frontleftmotor.isBusy());

        
        
        //}
        
        while(opModeIsActive() && (frontleftmotor.isBusy() || frontrightmotor.isBusy() || backrightmotor.isBusy() || backleftmotor.isBusy()) ){
        
         // run till the motors are busy going the distance 
        }
        stopMotor1();
    }

    private void spinrighttest(){
        frontrightmotor.setTargetPosition(1120);
        frontleftmotor.setTargetPosition(1120);
        backrightmotor.setTargetPosition(1120);
        backleftmotor.setTargetPosition(1120);
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setPower(-frontrightspeed);
        frontleftmotor.setPower(frontleftspeed);
        backrightmotor.setPower(backrightspeed);
        backleftmotor.setPower(-backleftspeed);
        stopMotor1();
    }

    // Function to strafe robot to right. 
    private void straferight(double distance){
        int distance_real = (int) (distance * 1120/ 2.5);

        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontrightmotor.setTargetPosition(distance_real);
        frontleftmotor.setTargetPosition(distance_real);
        backrightmotor.setTargetPosition(distance_real);
        backleftmotor.setTargetPosition(distance_real);
        
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontrightmotor.setPower(frontrightspeed);
        frontleftmotor.setPower(frontleftspeed);
        backrightmotor.setPower(-backrightspeed);
        backleftmotor.setPower(-backleftspeed);
        
        
        //while(opModeIsActive() && (-frontleftmotor.getCurrentPosition())< distance_real ){
            
          // opModeIsActive() && frontleft.isBusy() && frontright.isBusy() && backleft.isBusy() && backright.isBusy()){
       // telemetry.addData("The Target is:",frontleft.getTargetPosition());
       telemetry.addData("The current position is:",(-frontleftmotor.getCurrentPosition()));
       
        telemetry.addData("The current position is:",(-frontleftmotor.getCurrentPosition()/1120));
        telemetry.addData("The  position reminder:",(-frontleftmotor.getCurrentPosition()%1120));
        telemetry.addData("The set position is:",frontleftmotor.isBusy());

        
        //}
        
        while(opModeIsActive() && (frontleftmotor.isBusy() || frontrightmotor.isBusy() || backrightmotor.isBusy() || backleftmotor.isBusy()) ){
        
         // run till the motors are busy going the distance 
        }
        stopMotor1();

    }
    
    // Funtion to strafe robot to the left 
    private void strafeleft(double distance){
        int distance_real = (int) (distance * 1120/ 2.5);

        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontrightmotor.setTargetPosition(distance_real);
        frontleftmotor.setTargetPosition(distance_real);
        backrightmotor.setTargetPosition(-distance_real);
        backleftmotor.setTargetPosition(-distance_real);

        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontrightmotor.setPower(-frontrightspeed);
        frontleftmotor.setPower(-frontleftspeed);
        backrightmotor.setPower(backrightspeed);
        backleftmotor.setPower(backleftspeed);

  //      while(opModeIsActive() && (-frontleftmotor.getCurrentPosition())< distance_real ){
            
          // opModeIsActive() && frontleft.isBusy() && frontright.isBusy() && backleft.isBusy() && backright.isBusy()){
       // telemetry.addData("The Target is:",frontleft.getTargetPosition());
       telemetry.addData("The current position is:",(-frontleftmotor.getCurrentPosition()));
       
        telemetry.addData("The current position is:",(-frontleftmotor.getCurrentPosition()/1120));
        telemetry.addData("The  position reminder:",(-frontleftmotor.getCurrentPosition()%1120));
        telemetry.addData("The set position is:",frontleftmotor.isBusy());

        
//        }

        while(opModeIsActive() && (frontleftmotor.isBusy() || frontrightmotor.isBusy() || backrightmotor.isBusy() || backleftmotor.isBusy()) ){
        
         // run till the motors are busy going the distance 
        }
        
        stopMotor1();

    }


    // Function to do the steps to stop motor after required action and reset 
    private void stopMotor1() {
        
        frontleftmotor.setPower(0.0);
        frontrightmotor.setPower(0.0);
        backleftmotor.setPower(0.0);
        backrightmotor.setPower(0.0);
        
        
        
        frontleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
         frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    
    // Funtion to calculate distance needed to travel 
    // This function uses the motor tics and the wheel circumference
    // Based on the user input the function to move the robot backward or forward is called. 
    
    private void distanceCalculate(double inches, char type){
        
        double wheelTicks = 1120;
        double wheelCirc = 12.57;
        double distance_x = inches/wheelCirc;
        double distance_full = distance_x * wheelTicks;
        
        if(type == 'f'){
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            moveForward(distance_full);
        }
        else if(type == 'b'){
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            moveBackward(distance_full);
        }
        else{
          // nothing is done currently. 
        }
        
    }
    
    
    // Distance formula uses coordinates on the field based on the robot current position 
    // start position is obtained from the path calculator program 
    // This data is then sent to the distance calculator function which in turn then calls the motion function. 
    private void distanceFormula(double x1, double y1, double x2, double y2, char type){
        double final_x = Math.pow(x2 - x1, 2);
        double final_y = Math.pow(y2 - y1, 2);
        double distance = (Math.sqrt(final_x + final_y));
        distanceCalculate(distance, type);
    }   
    
    
    // Function to handle 1st path of the robot on the field. 
    private void path_1(){
        straferight(3);
        distanceFormula(-54, 45, -54, 60, 'f');
        telemetry.addLine("distance");
        telemetry.update();
        spinright(90);
        distanceFormula(-45, 53, -30, 53, 'f');
        spinleft(180);
        distanceFormula(-30, 53, -26, 53, 'b' );
        distanceFormula(-26, 53, -53, 53, 'f');
        straferight(53);
    }
    
    private void test(){
        distanceCalculate(1, 'f');
    }

    private void path_2(){
        straferight(9);
        distanceFormula(-54, 45, -54, 60, 'f');
        spinright(90);
        distanceFormula(-45, 53, -30, 53, 'f');
        spinleft(180);
        distanceFormula(-30, 53, -26, 53, 'b' );
        distanceFormula(-26, 53, -53, 53, 'f');
        straferight(53);
        distanceFormula(-53, 0, -27, 0, 'b');
    }

    private void path_3(){
        straferight(9);
        distanceFormula(-54, 21, -54, 60, 'f');
        spinright(90);
        distanceFormula(-45, 53, -30, 53, 'f');
        spinleft(180);
        distanceFormula(-30, 53, -26, 53, 'b' );
        distanceFormula(-26, 53, -53, 53, 'f');
        straferight(53);

    }

    private void path_4(){
        straferight(9);
        distanceFormula(-54, 21, -54, 60, 'f');
        spinright(90);
        distanceFormula(-45, 53, -30, 53, 'f');
        spinleft(180);
        distanceFormula(-30, 53, -26, 53, 'b' );
        distanceFormula(-26, 53, -53, 53, 'f');
        straferight(53);
        distanceFormula(-53, 0, -27, 0, 'b');
    }

    /*private void path_5(){
        strafeleft(25);
        distanceFormula(-38, -21, -38, -61, 'f');
        distanceFormula(-38, -61, -38, 23, 'b');
        spinright(180);
        distanceFormula(-38, 41, -38, 32, 'b');
        straferight(25);
        strafeleft(25);
        distanceFormula(-38, 32, -38, -61, 'b');
        distanceFormula(-38, -61, -38, 32, 'f');
        straferight(25);
        strafeleft(25);
        spinleft(90);
        distanceFormula(-29, 23, -70, 23, 'f');
        strafeleft(23);
    }

    private void path_6(){
        strafeleft(25);
        distanceFormula(-38, -21, -38, -61, 'f');
        distanceFormula(-38, -61, -38, 23, 'b');
        spinright(180);
        distanceFormula(-38, 41, -38, 32, 'b');
        straferight(25);
        strafeleft(25);
        distanceFormula(-38, 32, -38, -61, 'b');
        distanceFormula(-38, -61, -38, 32, 'f');
        straferight(25);
        strafeleft(25);
        spinleft(90);
        distanceFormula(-29, 23, -44, 23, 'f');
        strafeleft(23);
    }

    private void path_7(){
        strafeleft(25);
        distanceFormula(-38, -45, -38, -61, 'f');
        distanceFormula(-38, -61, -38, 23, 'b');
        spinright(180);
        distanceFormula(-38, 41, -38, 32, 'b');
        straferight(25);
        strafeleft(25);
        distanceFormula(-38, 32, -38, -61, 'b');
        distanceFormula(-38, -61, -38, 32, 'f');
        straferight(25);
        strafeleft(25);
        spinleft(90);
        distanceFormula(-29, 23, -70, 23, 'f');
        strafeleft(23);
    }

    private void path_8(){
        strafeleft(25);
        distanceFormula(-38, -45, -38, -61, 'f');
        distanceFormula(-38, -61, -38, 23, 'b');
        spinright(180);
        distanceFormula(-38, 41, -38, 32, 'b');
        straferight(25);
        strafeleft(25);
        distanceFormula(-38, 32, -38, -61, 'b');
        distanceFormula(-38, -61, -38, 32, 'f');
        straferight(25);
        strafeleft(25);
        spinleft(90);
        distanceFormula(-29, 23, -44, 23, 'f');
        strafeleft(23);
    }*/

    private void path_9(){
        strafeleft(9);
        distanceFormula(54, 45, 54, 60, 'f');
        spinleft(90);
        distanceFormula(45, 53, 30, 53, 'f');
        spinright(180);
        distanceFormula(30, 53, 26, 53, 'b' );
        distanceFormula(26, 53, 53, 53, 'f');
        strafeleft(53);
    }
    
    private void path_10(){
        strafeleft(9);
        distanceFormula(54, 45, 54, 60, 'f');
        spinleft(90);
        distanceFormula(45, 53, 30, 53, 'f');
        spinright(180);
        distanceFormula(30, 53, 26, 53, 'b' );
        distanceFormula(26, 53, 53, 53, 'f');
        strafeleft(53);
        distanceFormula(53, 0, 27, 0, 'b');
    }

    private void path_11(){
        strafeleft(9);
        distanceFormula(54, 21, 54, 60, 'f');
        spinleft(90);
        distanceFormula(45, 53, 30, 53, 'f');
        spinright(180);
        distanceFormula(30, 53, 26, 53, 'b' );
        distanceFormula(26, 53, 53, 53, 'f');
        strafeleft(53);
    }

    private void path_12(){
        strafeleft(9);
        distanceFormula(54, 21, 54, 60, 'f');
        spinleft(90);
        distanceFormula(45, 53, 30, 53, 'f');
        spinright(180);
        distanceFormula(30, 53, 26, 53, 'b' );
        distanceFormula(26, 53, 53, 53, 'f');
        strafeleft(53);
        distanceFormula(53, 0, 27, 0, 'b');
    }

    /*private void path_13(){
        straferight(25);
        distanceFormula(38, -21, 38, -61, 'f');
        distanceFormula(38, -61, 38, 23, 'b');
        spinright(180);
        distanceFormula(38, 41, 38, 32, 'b');
        strafeleft(25);
        straferight(25);
        distanceFormula(38, 32, 38, -61, 'b');
        distanceFormula(38, -61, 38, 32, 'f');
        strafeleft(25);
        straferight(25);
        spinright(90);
        distanceFormula(29, 23, 70, 23, 'f');
        straferight(23);
    }

    private void path_14(){
        straferight(25);
        distanceFormula(38, -21, 38, -61, 'f');
        distanceFormula(38, -61, 38, 23, 'b');
        spinright(180);
        distanceFormula(38, 41, 38, 32, 'b');
        strafeleft(25);
        straferight(25);
        distanceFormula(38, 32, 38, -61, 'b');
        distanceFormula(38, -61, 38, 32, 'f');
        strafeleft(25);
        straferight(25);
        spinright(90);
        distanceFormula(29, 23, 44, 23, 'f');
        straferight(23);
    }*/

}
