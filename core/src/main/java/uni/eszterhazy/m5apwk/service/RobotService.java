package uni.eszterhazy.m5apwk.service;

import uni.eszterhazy.m5apwk.exceptions.RobotAlreadyAdded;
import uni.eszterhazy.m5apwk.exceptions.RobotNotFound;
import uni.eszterhazy.m5apwk.model.Robot;
import uni.eszterhazy.m5apwk.model.RobotTipus;

import java.util.Collection;

public interface RobotService {
    void addRobot(Robot robot) throws RobotAlreadyAdded;
    Collection<Robot> getAllRobot();
    Robot getRobotById(String id) throws RobotNotFound;
    void updateRobot(Robot robot);
    void removeRobot(Robot robot);
    Collection<Robot> readAllRobotByTipus(RobotTipus tipus) throws RobotNotFound;
}
