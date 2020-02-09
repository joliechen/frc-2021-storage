/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystem;

import frc.robot.subsystem.climber.Climber;
import frc.robot.subsystem.climber.ClimberSBTab;
import frc.robot.subsystem.controlpanel.ControlPanel;
import frc.robot.subsystem.controlpanel.ControlPanelSBTab;
import frc.robot.subsystem.pixylinecam.PixyLineCam;
import frc.robot.subsystem.pixylinecam.PixyLineCamSBTab;
import frc.robot.subsystem.telemetry.Telemetry;
import frc.robot.subsystem.telemetry.TelemetrySBTab;
import frc.robot.subsystem.transport.Transport;
import frc.robot.subsystem.transport.TransportSBTab;
import frc.robot.subsystem.twowheelshooter.TwoWheelShooter;
import frc.robot.subsystem.twowheelshooter.TwoWheelShooterSBTab;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Add your docs here.
 */
public class DisplayManager {
    private ControlPanelSBTab controlPanelDisplay;
    private TransportSBTab transportDisplay;
    private ClimberSBTab climberDisplay;
    private TelemetrySBTab telemetryDisplay;
    private PixyLineCamSBTab pixyDisplay;

    private static Logger logger = Logger.getLogger(DisplayManager.class.getName());
    private TwoWheelShooterSBTab twoWheelShooterDisplay;

    private ArrayList<SBInterface> subsystemUpdateList;

    public DisplayManager(){
        subsystemUpdateList = new ArrayList<SBInterface>();
    }

    public void addCP(ControlPanel cp){
        controlPanelDisplay = new ControlPanelSBTab(cp);
        subsystemUpdateList.add(controlPanelDisplay);
        
    }

    public void addTransport(Transport t){
        transportDisplay = new TransportSBTab(t);
        subsystemUpdateList.add(transportDisplay);

    }

    public void addClimber(Climber c){
        climberDisplay = new ClimberSBTab(c);
        subsystemUpdateList.add(climberDisplay);

    }
    public void addTelemetry(Telemetry te){
        telemetryDisplay = new TelemetrySBTab(te);
        subsystemUpdateList.add(telemetryDisplay);

    }

    public void addPixyLineCam(PixyLineCam p) {
        pixyDisplay = new PixyLineCamSBTab(p);
        subsystemUpdateList.add(pixyDisplay);
    }
        
    public void addTwoWheelShooter(TwoWheelShooter tws){
        twoWheelShooterDisplay = new TwoWheelShooterSBTab(tws);
        subsystemUpdateList.add(twoWheelShooterDisplay);

    }


    public void update() {
        for (int j = 0; j < subsystemUpdateList.size(); j ++) {
            subsystemUpdateList.get(j).update();
          }
    }
}
