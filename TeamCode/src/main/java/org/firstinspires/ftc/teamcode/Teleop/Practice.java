package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Practice")
public class Practice extends OpMode {

    DcMotor motor;
   //Elene
    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "motor");
        telemetry.addData("I am", "working");
        telemetry.update();
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            motor.setPower(0.5);
        }
        motor.setPower(0);
    }
}
