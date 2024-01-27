package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "SkystoneDrive", group = "SkystoneTest")
public class Practice extends OpMode {

    DcMotor motor;

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        if(gamepad1.a){
            motor.setPower(0.5);
        }
        motor.setPower(0);
    }
}
