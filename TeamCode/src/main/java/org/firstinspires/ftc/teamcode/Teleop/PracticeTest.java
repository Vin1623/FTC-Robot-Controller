package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name = "PracticeTest")
public class PracticeTest extends OpMode {

    DcMotor motor1;
    public void init(){
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
    }

    public void loop() {
        float x = gamepad1.right_stick_x;
        float y = gamepad1.right_stick_y;
        if (gamepad1.right_stick_x > 0 || gamepad1.right_stick_x < 0) {
            motor1.setPower(x);
        }
        if (gamepad1.right_stick_y > 0 || gamepad1.right_stick_y < 0) {
            motor1.setPower(y);
        }
        motor1.setPower(0);
    }
}
