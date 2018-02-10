package edu.wpi.first.wpilibj;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.hal.HAL;

public class controller {

	  private static int m_rightRumble;

	  private static int m_leftRumble;


	public static class XboxController extends GenericHID {
		
     private enum Button { 
		 //button ports 
		    kBumperLeft(5),
		    kBumperRight(6),
		    kStickLeft(9),
		    kStickRight(10),
		    kA(1),
		    kB(2),
		    kX(3),
		    kY(4),
		    kBack(7),
		    kStart(8);

    	 
		    private int value;

		    Button(int value) {
		      this.value = value;
		    }
		  }
	
		  public XboxController(final int port) {
		    super(port);


		    HAL.report(tResourceType.kResourceType_Joystick, port);
		  }

	
		  @Override
		  public double getX(Hand hand) {
		    if (hand.equals(Hand.kLeft)) {
		      return getRawAxis(0);
		    } else {
		      return getRawAxis(4);
		    }
		  }

	
		  @Override
		  public double getY(Hand hand) {
		    if (hand.equals(Hand.kLeft)) {
		      return getRawAxis(1);
		    } else {
		      return getRawAxis(5);
		    }
		  }

		// left trigger activation degree
		  public double getTriggerAxis(Hand hand) {
		    if (hand.equals(Hand.kLeft)) {
		      return getRawAxis(2);
		    } else {
		      return getRawAxis(3);
		    }
		  }

		  //  bumper activation
		  public boolean getBumper(Hand hand) {
		    if (hand.equals(Hand.kLeft)) {
		      return getRawButton(Button.kBumperLeft.value);
		    } else {
		      return getRawButton(Button.kBumperRight.value);
		    }
		  }

		  	//D@nte was here		  
		  public boolean getBumperPressed(Hand hand) {
		    if (hand == Hand.kLeft) {
		      return getRawButtonPressed(Button.kBumperLeft.value);
		    } else {
		      return getRawButtonPressed(Button.kBumperRight.value);
		    }
		  }

		  
		
		  public boolean getBumperReleased(Hand hand) {
		    if (hand == Hand.kLeft) {
		      return getRawButtonReleased(Button.kBumperLeft.value);
		    } else {
		      return getRawButtonReleased(Button.kBumperRight.value);
		    }
		  }

		  // left stick button activation
		  public boolean getStickButton(Hand hand) {
		    if (hand.equals(Hand.kLeft)) {
		      return getRawButton(Button.kStickLeft.value);
		    } else {
		      return getRawButton(Button.kStickRight.value);
		    }
		  }

		
		  public boolean getStickButtonPressed(Hand hand) {
		    if (hand == Hand.kLeft) {
		      return getRawButtonPressed(Button.kStickLeft.value);
		    } else {
		      return getRawButtonPressed(Button.kStickRight.value);
		    }
		  }

		 
		  public boolean getStickButtonReleased(Hand hand) {
		    if (hand == Hand.kLeft) {
		      return getRawButtonReleased(Button.kStickLeft.value);
		    } else {
		      return getRawButtonReleased(Button.kStickRight.value);
		    }
		  }

		  // a button activation
		  public boolean getAButton() {
		    return getRawButton(Button.kA.value);
		  }

		  public boolean getAButtonPressed() {
		    return getRawButtonPressed(Button.kA.value);
		  }

		  public boolean getAButtonReleased() {
		    return getRawButtonReleased(Button.kA.value);
		  }

		// b button activation 
		  public boolean getBButton() {
		    return getRawButton(Button.kB.value);
		  }

		  public boolean getBButtonPressed() {
		    return getRawButtonPressed(Button.kB.value);
		  }

		
		  public boolean getBButtonReleased() {
		    return getRawButtonReleased(Button.kB.value);
		  }

		  // x button activation
		  public boolean getXButton() {
		    return getRawButton(Button.kX.value);
		  }
		   
		  public boolean getXButtonPressed() {
		    return getRawButtonPressed(Button.kX.value);
		  }
		   
		  public boolean getXButtonReleased() {
		    return getRawButtonReleased(Button.kX.value);
		  }
	//y button activation
		  public boolean getYButton() {
		    return getRawButton(Button.kY.value);
		  }
		 
		  public boolean getYButtonPressed() {
		    return getRawButtonPressed(Button.kY.value);
		  }

		  public boolean getYButtonReleased() {
		    return getRawButtonReleased(Button.kY.value);
		  }
// 
		  public boolean getBackButton() {
		    return getRawButton(Button.kBack.value);
		  }
		
		  public boolean getBackButtonPressed() {
		    return getRawButtonPressed(Button.kBack.value);
		  }
		
		  public boolean getBackButtonReleased() {
		    return getRawButtonReleased(Button.kBack.value);
		  }
//start button activation		   
		  public boolean getStartButton() {
		    return getRawButton(Button.kStart.value);
		  }

		  public boolean getStartButtonPressed() {
		    return getRawButtonPressed(Button.kStart.value);
		  }

		  public boolean getStartButtonReleased() {
		    return getRawButtonReleased(Button.kStart.value);}
		   		 
		      }
		     //rumble effect
		      public void setRumble(RumbleType type, double value) {
		        if (value < 0) {
		          value = 0;
		        } else if (value > 1) {
		          value = 1;
		        }
		        if (type == RumbleType.kLeftRumble) {
		          setM_leftRumble((short) (value * 65535));
		        } else {

		  }
	}

			public static int getM_rightRumble() {
				return m_rightRumble;
			}

			public static void setM_rightRumble(int m_rightRumble) {
				controller.m_rightRumble = m_rightRumble;
			}

			public static int getM_leftRumble() {
				return m_leftRumble;
			}

			public static void setM_leftRumble(int m_leftRumble) {
				controller.m_leftRumble = m_leftRumble;
			}

			public static boolean getBumperLeft(boolean b) {
				// TODO Auto-generated method stub
				return false;
			}

			public static boolean getBumperRight(boolean b) {
				// TODO Auto-generated method stub
				return false;
			}

		
}