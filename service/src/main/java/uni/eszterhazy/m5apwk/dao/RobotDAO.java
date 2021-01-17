package uni.eszterhazy.m5apwk.dao;

import uni.eszterhazy.m5apwk.exceptions.RobotAlreadyAdded;
import uni.eszterhazy.m5apwk.exceptions.RobotNotFound;
import uni.eszterhazy.m5apwk.model.Robot;
import uni.eszterhazy.m5apwk.model.RobotTipus;

import java.util.Collection;

public interface RobotDAO {
    void createRobot(Robot robot) throws RobotAlreadyAdded;
    Collection<Robot> readAllRobot();
    Robot readRobot(String id) throws RobotNotFound;
    void updateRobot(Robot robot);
    void deleteRobot(Robot robot);
    Collection<Robot> readAllRobotByTipus(RobotTipus tipus) throws RobotNotFound;
}
