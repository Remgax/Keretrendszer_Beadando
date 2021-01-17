package uni.eszterhazy.m5apwk.service.impl;

import org.apache.log4j.Logger;
import uni.eszterhazy.m5apwk.dao.RobotDAO;
import uni.eszterhazy.m5apwk.exceptions.RobotAlreadyAdded;
import uni.eszterhazy.m5apwk.exceptions.RobotNotFound;
import uni.eszterhazy.m5apwk.model.Robot;
import uni.eszterhazy.m5apwk.model.RobotTipus;
import uni.eszterhazy.m5apwk.service.RobotService;

import java.util.Collection;

public class RobotServiceImpl implements RobotService{
    Logger logger = Logger.getLogger(this.getClass());

    private RobotDAO dao;

    public RobotServiceImpl(RobotDAO dao) {
        this.dao = dao;
    }
    @Override
    public void addRobot(Robot robot) throws RobotAlreadyAdded {
        dao.createRobot(robot);
    }

    @Override
    public Collection<Robot> getAllRobot() {
        Collection<Robot> result = dao.readAllRobot();
        logger.info("Eltárolt robotok száma: "+ result.size());
        return result;
    }
    @Override
    public Robot getRobotById(String id) throws RobotNotFound{
        return dao.readRobot(id);
    }

    @Override
    public void updateRobot(Robot robot) {
        dao.updateRobot(robot);
    }
    @Override
    public void removeRobot(Robot robot) {
        Collection<Robot> robots= getAllRobot();
        robots.remove(robots);
    }

    @Override
    public Collection<Robot> readAllRobotByTipus(RobotTipus tipus) throws RobotNotFound {
        return dao.readAllRobotByTipus(tipus);
    }
}
