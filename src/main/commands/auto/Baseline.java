  package main.commands.auto;

import interfacesAndAbstracts.ImprovedCommandGroup;
import main.commands.drivetrain.TimedDrive;

public class Baseline extends ImprovedCommandGroup {
	//Baseline is 10ft away so the robot should drive 11ft
	public Baseline() {
		addSequential(new TimedDrive(TIMED_DRIVE_PERCENT, 144/TIMED_DISTANCE_MULTIPLIER));
	}
}
