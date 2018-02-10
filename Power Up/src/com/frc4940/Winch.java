package com.frc4940;
import edu.wpi.first.wpilibj.Talon;


public class Winch {
	

		Talon _winch; 
		Winch(int _CANPort){
			_winch = new Talon(_CANPort);
		}
		
		public void setSpeed (double speed){		
			_winch.set(speed);
		}
			
	}

