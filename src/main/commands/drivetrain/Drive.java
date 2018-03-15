package main.commands.drivetrain;

import interfacesAndAbstracts.ImprovedCommand;
import main.Robot;
import main.OI;

public class Drive extends ImprovedCommand {
	public Drive() {
    	requires(Robot.dt);
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {    	
    	Robot.dt.driveVelocity(OI.getXbox().getSmoothedMainY(), -OI.getXbox().getSmoothedAltX());
    	//Robot.dt.driveVelocity(-OI.getXbox().getSmoothedMainY(), -OI.getXbox().getSmoothedAltX());
    }
    
    @Override
	protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    }
}