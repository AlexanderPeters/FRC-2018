package main.commands.drivetrain;

import interfacesAndAbstracts.ImprovedCommand;
import main.Robot;

public class TurnToAngle extends ImprovedCommand {
	private double angle;
    public TurnToAngle(double angle) {
    	this.angle = angle;
    	requires(Robot.dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dt.zeroGyro();
    }           

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Original
    	/*if(angle < 0)
    		if(Robot.dt.isDriveAtAngleGreaterThan(angle/2))
    			Robot.dt.timedTurn(TurnMode.Left, 0.35);
    		else if(Robot.dt.isDriveAtAngleGreaterThan(angle/1.75))
    			Robot.dt.timedTurn(TurnMode.Left, 0.3);
    		else if(Robot.dt.isDriveAtAngleGreaterThan(angle/1.5))
    			Robot.dt.timedTurn(TurnMode.Left, 0.22);
    		else if(Robot.dt.isDriveAtAngleGreaterThan(angle/1.25))
    			Robot.dt.timedTurn(TurnMode.Left, 0.18);
    		else
    			Robot.dt.timedTurn(TurnMode.Left, 0.4);
    	else
    		if(Robot.dt.isDriveAtAngleGreaterThan(angle/2))
    			Robot.dt.timedTurn(TurnMode.Right, 0.35);
    		else if(Robot.dt.isDriveAtAngleGreaterThan(angle/1.75))
    			Robot.dt.timedTurn(TurnMode.Right, 0.3);
    		else if(Robot.dt.isDriveAtAngleGreaterThan(angle/1.5))
    			Robot.dt.timedTurn(TurnMode.Right, 0.22);
    		else if(Robot.dt.isDriveAtAngleGreaterThan(angle/1.25))
    			Robot.dt.timedTurn(TurnMode.Right, 0.18);
    		else
    			Robot.dt.timedTurn(TurnMode.Right, 0.4);
    	*/
    	//Corrected
    	/*
    	if(angle < 0)
    		if(Robot.dt.isDriveAtAngleGreaterThan(angle * 0.9))
    			Robot.dt.timedTurn(TurnMode.Left, 0.18);
        	else if(Robot.dt.isDriveAtAngleGreaterThan(angle * .85))
    			Robot.dt.timedTurn(TurnMode.Left, 0.22);
        	else if(Robot.dt.isDriveAtAngleGreaterThan(angle * 0.75))
    			Robot.dt.timedTurn(TurnMode.Left, 0.3);
        	else if(Robot.dt.isDriveAtAngleGreaterThan(angle * 0.5))
    			Robot.dt.timedTurn(TurnMode.Left, 0.35);
    		else
    			Robot.dt.timedTurn(TurnMode.Left, 0.4);
    	else
    		if(Robot.dt.isDriveAtAngleGreaterThan(angle * 0.9))
    			Robot.dt.timedTurn(TurnMode.Right, 0.18);
        	else if(Robot.dt.isDriveAtAngleGreaterThan(angle * .85))
    			Robot.dt.timedTurn(TurnMode.Right, 0.22);
        	else if(Robot.dt.isDriveAtAngleGreaterThan(angle * 0.75))
    			Robot.dt.timedTurn(TurnMode.Right, 0.3);
        	else if(Robot.dt.isDriveAtAngleGreaterThan(angle * 0.5))
    			Robot.dt.timedTurn(TurnMode.Right, 0.35);
    		else
    			Robot.dt.timedTurn(TurnMode.Right, 0.4);
    	*/
    	//Improved
    	double throttle = Math.abs(Robot.dt.getAnglePercentError(angle)) + minimumTurnThrottle;
    	Robot.dt.timedTurn(angle < 0 ? TurnMode.Left : TurnMode.Right, throttle);
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return Robot.dt.isDriveTrainAtAngle(angle);    	
    }

    // Called once after isFinished returns true
    protected void end() {
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
