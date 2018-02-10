package com.frc4940;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.hal.HAL;

public class joycon {
	
	public static class Joystick extends GenericHID {
	  static final byte kDefaultXAxis = 0;
	  static final byte kDefaultYAxis = 1;
	  static final byte kDefaultZAxis = 2;
	  static final byte kDefaultTwistAxis = 2;
	  static final byte kDefaultThrottleAxis = 3;

		  public enum AxisType {
	    kX(0), kY(1), kZ(2), kTwist(3), kThrottle(4);


	    public final int value;

	    AxisType(int value) {
	      this.value = value;
	    }
	  }


	  public enum ButtonType {
	    kTrigger(1), kTop(2);

	    @SuppressWarnings("MemberName")
	    public final int value;

	    ButtonType(int value) {
	      this.value = value;
	    }
	  }


	  private enum Button {
	    kTrigger(1), kTop(2);

	    @SuppressWarnings("MemberName")
	    public final int value;

	    Button(int value) {
	      this.value = value;
	    }
	  }


	  private enum Axis {
	    kX(0), kY(1), kZ(2), kTwist(3), kThrottle(4), kNumAxes(5);

	    @SuppressWarnings("MemberName")
	    public final int value;

	    Axis(int value) {
	      this.value = value;
	    }
	  }

	  private final byte[] m_axes = new byte[Axis.kNumAxes.value];

	  public Joystick(final int port) {
	    super(port);

	    m_axes[Axis.kX.value] = kDefaultXAxis;
	    m_axes[Axis.kY.value] = kDefaultYAxis;
	    m_axes[Axis.kZ.value] = kDefaultZAxis;
	    m_axes[Axis.kTwist.value] = kDefaultTwistAxis;
	    m_axes[Axis.kThrottle.value] = kDefaultThrottleAxis;

	    HAL.report(tResourceType.kResourceType_Joystick, port);
	  }

	  public void setXChannel(int channel) {
	    m_axes[Axis.kX.value] = (byte) channel;
	  }


	  public void setYChannel(int channel) {
	    m_axes[Axis.kY.value] = (byte) channel;
	  }

	  public void setZChannel(int channel) {
	    m_axes[Axis.kZ.value] = (byte) channel;
	  }

	  public void setThrottleChannel(int channel) {
	    m_axes[Axis.kThrottle.value] = (byte) channel;
	  }

	  public void setTwistChannel(int channel) {
	    m_axes[Axis.kTwist.value] = (byte) channel;
	  }

	  @Deprecated
	  public void setAxisChannel(AxisType axis, int channel) {
	    m_axes[axis.value] = (byte) channel;
	  }

	  public int getXChannel() {
	    return m_axes[Axis.kX.value];
	  }

	  public int getYChannel() {
	    return m_axes[Axis.kY.value];
	  }

	  public int getZChannel() {
	    return m_axes[Axis.kZ.value];
	  }

	  public int getTwistChannel() {
	    return m_axes[Axis.kTwist.value];
	  }

	  public int getThrottleChannel() {
	    return m_axes[Axis.kThrottle.value];
	  }

	  @Deprecated
	  public int getAxisChannel(AxisType axis) {
	    return m_axes[axis.value];
	  }

	  @Override
	  public final double getX(Hand hand) {
	    return getRawAxis(m_axes[Axis.kX.value]);
	  }

	  @Override
	  public final double getY(Hand hand) {
	    return getRawAxis(m_axes[Axis.kY.value]);
	  }

	  public double getZ() {
	    return getRawAxis(m_axes[Axis.kZ.value]);
	  }

	  public double getTwist() {
	    return getRawAxis(m_axes[Axis.kTwist.value]);
	  }

	  public double getThrottle() {
	    return getRawAxis(m_axes[Axis.kThrottle.value]);
	  }

	  @Deprecated
	  public double getAxis(final AxisType axis) {
	    switch (axis) {
	      case kX:
	        return getX();
	      case kY:
	        return getY();
	      case kZ:
	        return getZ();
	      case kTwist:
	        return getTwist();
	      case kThrottle:
	        return getThrottle();
	      default:
	        return 0.0;
	    }
	  }

	 
	  public boolean getTrigger() {
	    return getRawButton(Button.kTrigger.value);
	  }
	   
	  public boolean getTriggerPressed() {
	    return getRawButtonPressed(Button.kTrigger.value);
	  }

	  
	  public boolean getTriggerReleased() {
	    return getRawButtonReleased(Button.kTrigger.value);
	  }

	  
	  public boolean getTop() {
	    return getRawButton(Button.kTop.value);
	  }

	  
	  public boolean getTopPressed() {
	    return getRawButtonPressed(Button.kTop.value);
	  }

	 
	  public boolean getTopReleased() {
	    return getRawButtonReleased(Button.kTop.value);
	  }

	 
	  @Deprecated
	  public boolean getButton(ButtonType button) {
	    return getRawButton(button.value);
	  }

	 
	  public double getMagnitude() {
	    return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
	  }

	 	  public double getDirectionRadians() {
	    return Math.atan2(getX(), -getY());
	  }

	 	  public double getDirectionDegrees() {
	    return Math.toDegrees(getDirectionRadians());
	  }
	}

	

}
