package main.commands.intake;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import main.Constants;
import main.HardwareAdapter;

public class CloseIntake extends CommandGroup implements Constants, HardwareAdapter{
    // Called just before this Command runs the first time
    public CloseIntake() {
    	clawOpener.set(RET);
    	addSequential(new WaitCommand(0.1));
    	clawOpener.set(OFF);
    }
}
