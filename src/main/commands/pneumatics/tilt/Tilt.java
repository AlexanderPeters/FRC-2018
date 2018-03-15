package main.commands.pneumatics.tilt;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import interfacesAndAbstracts.ImprovedCommand;
import main.Robot;

class Tilt extends ImprovedCommand {
	public final DoubleSolenoid.Value v;
	
	public Tilt(DoubleSolenoid.Value v) {
		requires(Robot.pn);
		this.v = v;
	}
	
	@Override
	public void execute() {
		Robot.pn.tilt(v);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
