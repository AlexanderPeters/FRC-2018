package main.commands.altermativeAuto;

import edu.wpi.first.wpilibj.command.WaitCommand;
import interfacesAndAbstracts.ImprovedCommandGroup;
import main.commands.drivetrain.DistanceDriveStraight;
import main.commands.drivetrain.TurnToAngle;
import main.commands.drivetrain.TurnToAngleGyro;
import main.commands.elevator.MovePID;
import main.commands.elevator.MoveToBottom;
import main.commands.elevator.MoveToTop;
import main.commands.intake.SpinOff;
import main.commands.intake.SpinOut;
import main.commands.pneumatics.arm.ArmClose;
import main.commands.pneumatics.arm.ArmOpen;
import main.commands.pneumatics.arm.SwitchArm;
import main.commands.pneumatics.tilt.SwitchTilt;
import main.commands.pneumatics.tilt.TiltDown;
import main.commands.pneumatics.tilt.TiltUp;

public class AltLeftToLeftScale extends ImprovedCommandGroup {
	public AltLeftToLeftScale() {
		addSequential(new DistanceDriveStraight(230));
		addSequential(new TurnToAngleGyro(35, 3));
		addSequential(new WaitCommand(0.3));
		addSequential(new MovePID(elevatorHeight, 4));
		addSequential(new WaitCommand(0.5));
		addSequential(new DistanceDriveStraight(50));
		addSequential(new WaitCommand(0.5));
		addSequential(new TiltDown());
		addSequential(new WaitCommand(0.3));
		addSequential(new ArmOpen());
		addSequential(new WaitCommand(0.3));
		addSequential(new TiltUp());
		addSequential(new WaitCommand(0.3));
		addSequential(new ArmClose());
		addSequential(new WaitCommand(0.3));
		addSequential(new DistanceDriveStraight(-30));
		addSequential(new MoveToBottom(5));
	}
}
