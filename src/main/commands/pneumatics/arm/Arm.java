package main.commands.pneumatics.arm;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import interfacesAndAbstracts.ImprovedCommand;
import main.Robot;

class Arm extends ImprovedCommand {
	public DoubleSolenoid.Value v;
	
	public Arm(DoubleSolenoid.Value v) {
		requires(Robot.pn);
		this.v = v;
	}
	
    @Override
	protected void execute() {
    	Robot.pn.toggleArm(v);
    }

	@Override
	protected boolean isFinished() {
		return true;
	}
}
