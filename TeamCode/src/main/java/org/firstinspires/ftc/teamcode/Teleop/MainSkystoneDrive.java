package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "MainSkystoneDrive")
public class MainSkystoneDrive extends OpMode {

    DcMotor motorFL; //Front Left
    DcMotor motorFR; //Front Right
    DcMotor motorBL; //Back Left
    DcMotor motorBR; //Back Right
    Servo arm; //arm
    @Override
    public void init() {
        motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        motorFR = hardwareMap.get(DcMotor.class, "motorFR");
        motorBL = hardwareMap.get(DcMotor.class, "motorBL");
        motorBR = hardwareMap.get(DcMotor.class, "motorBR");

        telemetry.addData("I am", "working");
        telemetry.update();
    }

    @Override
    public void loop() {
//        double tgtPower = 0;
        double motorPowerY = gamepad1.left_stick_y;
        if (gamepad1.right_stick_y > 0 || gamepad1.right_stick_y < 0) {
            motorBL.setPower(motorPowerY);
            motorBR.setPower(motorPowerY);
        }
//        tgtPower = -this.gamepad1.left_stick_y;
        if(gamepad1.y) {
            // move to 0 degrees.
            arm.setPosition(0);
        }
        else if (gamepad1.x || gamepad1.b) {
            // move to 90 degrees.
            arm.setPosition(0.5);
        } else if (gamepad1.a) {
            // move to 180 degrees.
            arm.setPosition(1);
        }
        telemetry.addData("Servo Position", arm.getPosition());
//        telemetry.addData("Target Power", tgtPower);
        telemetry.addData("Motor Power", motorBL.getPower() + ", " + motorBR.getPower());
        telemetry.addData("Status", "Running");
        telemetry.update();

        motorFL.setPower(0);
        motorFR.setPower(0);
        motorBL.setPower(0);
        motorBR.setPower(0);
    }
}
