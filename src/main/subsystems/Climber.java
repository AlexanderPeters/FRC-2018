package main.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import main.Constants;
import main.HardwareAdapter;
import main.Robot;
import main.Robot.RobotState;

public class Climber extends Subsystem implements Constants, HardwareAdapter  {

	public void spin(double speed) {
		
		climberMotor.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	 
	
}
