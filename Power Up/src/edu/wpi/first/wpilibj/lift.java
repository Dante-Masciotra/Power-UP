package edu.wpi.first.wpilibj;
import edu.wpi.first.wpilibj.controller;
import edu.wpi.first.wpilibj.Relay;


public class lift {{
	Relay relayLift = new Relay(11);
	while(isOperatorControl()&isEnabled()) {
		if (controller.getBumperRight(true)) {
	  		relayLift.set(Relay.Value.kForward);	
		}
		
		else if (controller.getBumperLeft(true)){
			relayLift.set(Relay.Value.kReverse);	
	  	} 
		
		else {
			relayLift.set(Relay.Value.kOff);
	  		
	  	}
		
		}
	}
}