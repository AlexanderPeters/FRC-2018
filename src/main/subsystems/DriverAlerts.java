package main.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import interfacesAndAbstracts.RobotSubsystem;
import main.HardwareAdapter;

public class DriverAlerts extends RobotSubsystem implements HardwareAdapter {

	/*public void setAlertLightState(boolean state) {
		alertRelay.set(!state);
	}

	public boolean getAlertLightState() {
		return alertRelay.get();
	}

	public void pulseAlertLight(int pulseLength) {
		alertRelay.pulse(pulseLength);
	}

	public boolean isPulsing() {
		return alertRelay.isPulsing();
	}*/

	@Override
	protected void initDefaultCommand() {
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub

	}

	@Override
	public void zeroSensors() {
	}
}

