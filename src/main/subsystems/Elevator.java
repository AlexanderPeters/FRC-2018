package main.subsystems;

import Util.DriveHelper;
import interfacesAndAbstracts.ImprovedSubsystem;
import main.commands.elevator.MoveWithJoystick;

public class Elevator extends ImprovedSubsystem {
	private final DriveHelper driveHelper = new DriveHelper(7.5);
	
	//max velocity was 100523u/100ms	
	public Elevator() {
		setElevatorDefaults();
	}
	
	/*************************
	 * TALON SUPPORT METHODS *
	 ************************/
	private void setBrakeMode() {
		elevatorMaster.setNeutralMode(BRAKE_MODE);
		elevatorSlave.setNeutralMode(BRAKE_MODE);
	}
	
	private void setCtrlMode() {
		elevatorSlave.follow(elevatorMaster);
	}
	
	private void setVoltageMode(boolean set, double voltage, int timeout) {
		elevatorMaster.enableVoltageCompensation(set);
		elevatorSlave.enableVoltageCompensation(set);
		elevatorMaster.configVoltageCompSaturation(voltage, timeout);
		elevatorSlave.configVoltageCompSaturation(voltage, timeout);

		elevatorMaster.configPeakOutputForward(1.0, timeout);
		elevatorMaster.configNominalOutputForward(0, timeout);
		elevatorMaster.configPeakOutputReverse(-1.0, timeout);
		elevatorMaster.configNominalOutputReverse(0, timeout);
		elevatorSlave.configPeakOutputForward(1.0, timeout);
		elevatorSlave.configNominalOutputForward(0, timeout);
		elevatorSlave.configPeakOutputReverse(-1, timeout);
		elevatorSlave.configNominalOutputReverse(0, timeout);
	}
	
	private void setElevatorDefaults() {
		setCtrlMode();
		setBrakeMode();
		setVoltageMode(true, 12, 10);
	}

	/**************************
	 * SENSOR SUPPORT METHODS *
	 **************************/
	
	@Override
	public void zeroSensors() {
		//elevatorMaster.getSensorCollection().setQuadraturePosition(0, 10);
	}
	
	// Sets encoders to 0 if the arm is at the bottom (this helps to avoid offset)
	@Override
	public void check() {
		/*if (isArmAtBottom())
			zeroSensors();*/
	}
	
	/***************
	 * RECORD/PLAY *
	 ***************/
	public double getElevatorVoltage() {
		return (elevatorMaster.getMotorOutputVoltage()); //+ elevatorSlave.getMotorOutputVoltage())/2;
	}
	
	/********************
	 * MOVEMENT METHODS *
	 ********************/
	
	public void moveFromPlay(double voltage) {
		elevatorMaster.set(voltage/12);
	}

	public void moveWithJoystick(double throttle) {
		// if(throttle == 0 || (throttle > 0 && !isArmAtTop()) || (throttle < 0 && !isArmAtBottom()))
		if (isCompetitionRobot)
			elevatorMaster.set(driveHelper.handleOverPower(driveHelper.handleDeadband(-throttle, elevatorDeadband)));
		else
			elevatorMaster.set(driveHelper.handleOverPower(driveHelper.handleDeadband(throttle, elevatorDeadband)));
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveWithJoystick());
	}

}
