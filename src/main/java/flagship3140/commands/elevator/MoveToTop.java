package main.java.flagship3140.commands.elevator;

import edu.wpi.first.wpilibj.command.TimedCommand;
import main.java.flagship3140.Robot;

public class MoveToTop extends TimedCommand {
	public MoveToTop(double timeout) {//3 recommended timeout
		super(timeout);//Timeout forced to a maximum of 3, this is for the emergency case that a limit switch breaks
		//So that the elevator will not continue to drive up.
		requires(Robot.el);
	}
	
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.el.move(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.el.isArmAtTop() && Robot.el.isIntakeAbovePosition(36);
    	//return false;
    }


    // Called once after isFinished returns true
    protected void end() {
    	Robot.el.move(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}


