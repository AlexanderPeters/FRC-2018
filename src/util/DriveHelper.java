package util;

import main.Constants;
import main.subsystems.subsystemConstants.DrivetrainConstants;

/**
 *
 * @author Joseph Grube
 */
public class DriveHelper implements Constants, DrivetrainConstants{
    private double negInertiaScalar;
    private double negInertiaAccumulator;
    private double oldTurn;
    private double wheelNonLinearity;

    public DriveHelper(double negInertiaScalar) {
        this.negInertiaScalar = negInertiaScalar;
    }
    
    public double calculateThrottle(double throttle) {
    	return handleOverPower(handleDeadband(throttle, throttleDeadband));
    }
    
    public double calculateTurn(double turn, boolean highGear){
    	return handleOverPower(accountForInertia(smoothTurning(handleDeadband(turn, headingDeadband), highGear)));
    }    
    
    private double accountForInertia(double turn) {
        double newTurn = turn;
        double negInertia = newTurn - oldTurn;
        oldTurn = newTurn;
        
        double negInertiaPower = negInertia * negInertiaScalar;
        negInertiaAccumulator += negInertiaPower;
        newTurn += negInertiaAccumulator;
        
        if (negInertiaAccumulator > 1) {
            negInertiaAccumulator -= 1;
        } else if (negInertiaAccumulator < -1) {
            negInertiaAccumulator += 1;
        } else {
            negInertiaAccumulator = 0;
        }
        
        return newTurn;
    }
    
    public void reset() {
        negInertiaAccumulator = 0;
        oldTurn = 0;
    }

	private double smoothTurning(double turn, boolean highGear) {
		if (highGear) {
			wheelNonLinearity = 0.6;
			// Apply a sin function that's scaled to make it feel better.
			turn = Math.sin(Math.PI / 2.0 * wheelNonLinearity * turn)
					/ Math.sin(Math.PI / 2.0 * wheelNonLinearity);
			turn = Math.sin(Math.PI / 2.0 * wheelNonLinearity * turn)
					/ Math.sin(Math.PI / 2.0 * wheelNonLinearity);
		} else {
			wheelNonLinearity = 0.5;
			// Apply a sin function that's scaled to make it feel better.
			turn = Math.sin(Math.PI / 2.0 * wheelNonLinearity * turn)
					/ Math.sin(Math.PI / 2.0 * wheelNonLinearity);
			turn = Math.sin(Math.PI / 2.0 * wheelNonLinearity * turn)
					/ Math.sin(Math.PI / 2.0 * wheelNonLinearity);
			turn = Math.sin(Math.PI / 2.0 * wheelNonLinearity * turn)
					/ Math.sin(Math.PI / 2.0 * wheelNonLinearity);
		}
		return turn;
	}
	
    public double handleDeadband(double val, double deadband) {
        return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
    }
    
    public double handleOverPower(double joystickVal){
    	if(Math.abs(joystickVal) > 1.0)
    		return Math.signum(joystickVal);
    	else
    		return joystickVal;
    }
    
    public double handleJoystickHatingMe(double throttle) {
    	if(Math.abs(throttle) >= 0.95)
    		return Math.signum(throttle);
    	else 
    		return throttle;
    }
}
