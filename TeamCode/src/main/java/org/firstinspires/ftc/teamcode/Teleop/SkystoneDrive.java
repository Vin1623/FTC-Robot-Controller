package org.firstinspires.ftc.teamcode.Teleop;
//vincent was here

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "SkystoneDrive", group = "SkystoneTest")
public class SkystoneDrive extends LinearOpMode {

    private DcMotor Left;
    //Left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    private DcMotor Right;
    private DcMotor ArmHeight;
    private Servo arm;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        double RightStickY;
        double RightStickX;

        Left = hardwareMap.dcMotor.get("Left");
        Right = hardwareMap.dcMotor.get("Right");
        ArmHeight = hardwareMap.dcMotor.get("ArmHeight");
        arm = hardwareMap.servo.get("arm");
        double initialPos = ArmHeight.getCurrentPosition();

        // DcMotor1-Right| DcMotor2-Left
        // Put initialization blocks here.
        waitForStart();
        //Left.setDirection(DcMotorSimple.Direction.REVERSE);
        while (opModeIsActive()) {
            RightStickX = Math.pow(gamepad1.right_stick_x, 3);
            RightStickY = Math.pow(gamepad1.right_stick_y, 3);
            Left.setPower(-RightStickY + RightStickX);
            Right.setPower(-RightStickY - -RightStickX);
            // DcMotor3 Claw
            if (gamepad1.dpad_up) {
                ArmHeight.setPower(-0.4);
            } else {
                if (gamepad1.dpad_down && ArmHeight.getCurrentPosition() != -1) {
                    ArmHeight.setPower(0.2);
                } else {
                    ArmHeight.setPower(0);
                }
            }
            if (gamepad1.left_trigger == 1  && initialPos >= ArmHeight.getCurrentPosition() ) {
                arm.setPosition(arm.getPosition() + 0.25);
            } else {
                if (gamepad1.right_trigger == 1 && arm.getPosition() != -1) {
                    arm.setPosition(arm.getPosition() - 0.25);
                } else {
                    arm.setPosition(0);
                }
            }

            telemetry.addData("Left Drive", Left.getCurrentPosition());
            telemetry.addData("Right Drive", Right.getCurrentPosition());
            telemetry.addData("Arm Control", ArmHeight.getCurrentPosition());
            telemetry.addData("Servo Status", arm.getPosition());
        }
        telemetry.update();
    }
}

