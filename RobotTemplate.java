package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

public class RobotTemplate extends SimpleRobot 
{
    private RobotDrive  m_chassis = new RobotDrive(1, 2); //Makes new RobotDrive object with slots 1 and 2 as motors
    private Joystick m_leftStick = new Joystick(1);//Makes new joystick object for slot 1
    private Joystick m_rightStick = new Joystick(2);//Makes new joystick object for slot 2
    
    public void autonomous() 
    {
        m_chassis.setSafetyEnabled(false);//Safety turns off motors after .1sec if no input
        m_chassis.drive(-0.5, 0.0);//Drive .5 speed at turn rate 0.0 (negative because joystick input is negative)
        Timer.delay(2.0);//delays 2.0sec while robot continues forward
        m_chassis.drive(0.0, 0.0);//Drive at 0.0 speed and 0.0 turn (stop)
    }

    public void operatorControl() 
    {
        m_chassis.setSafetyEnabled(true);//Safety turns off motors after .1sec if no input
        while (isOperatorControl() && isEnabled()) 
        {
            m_chassis.tankDrive(m_leftStick, m_rightStick);//Begins tank steering with the joysticks
            Timer.delay(0.01);//Waits 0.01sec
        }
    }
    
    public void test() //Necessary I think(?)
    {
    
    }
}
