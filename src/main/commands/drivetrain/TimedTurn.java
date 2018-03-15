package main.commands.drivetrain;

import edu.wpi.first.wpilibj.command.TimedCommand;
import main.Constants;
import main.Robot;

public class TimedTurn extends TimedCommand implements Constants {
	private final double throttle;
	private final TurnMode mode;

	public TimedTurn(TurnMode mode, double throttle, double timeout) {
		super(timeout);
		this.throttle = throttle;
		this.mode = mode;
		requires(Robot.dt);
	}
	
	@Override
	protected void execute() {
		Robot.dt.timedTurn(mode, throttle);//Turning is the same between both robots
	}
}
