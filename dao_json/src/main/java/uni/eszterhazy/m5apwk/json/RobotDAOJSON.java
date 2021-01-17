package uni.eszterhazy.m5apwk.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import uni.eszterhazy.m5apwk.dao.RobotDAO;
import uni.eszterhazy.m5apwk.exceptions.RobotAlreadyAdded;
import uni.eszterhazy.m5apwk.exceptions.RobotNotFound;
import uni.eszterhazy.m5apwk.model.Robot;
import uni.eszterhazy.m5apwk.model.RobotTipus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RobotDAOJSON implements RobotDAO {
    File jsonFile;
    ObjectMapper mapper;
    public RobotDAOJSON(String jsonFilePath) throws IOException {
        jsonFile= new File(jsonFilePath);
        System.out.println(jsonFile.getAbsolutePath());
        if(!jsonFile.exists()){
            jsonFile.createNewFile();
            FileWriter writer = new FileWriter(jsonFile);
            writer.write("[]");
            writer.flush();
            writer.close();
        }

        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }
    @Override
    public void createRobot(Robot robot) throws RobotAlreadyAdded {

        Collection<Robot> gyar = readAllRobot();

        Robot result = null;
        try {
            result = readRobot(robot.getId());

        } catch (RobotNotFound robotNotFound){
            gyar.add(robot);
            try {
                mapper.writeValue(jsonFile, gyar);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(result!=null) {throw new RobotAlreadyAdded(robot.getId());}
    }

    @Override
    public Collection<Robot> readAllRobot() {
        Collection<Robot> gyar = new ArrayList<Robot>();
        TypeReference type = new TypeReference<ArrayList<Robot>>() {};
        try {
            gyar = (Collection<Robot>) mapper.readValue(jsonFile,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gyar;
    }


    public Robot readRobot(String id) throws RobotNotFound {
        Collection<Robot> gyar = readAllRobot();
        for (Robot k: gyar){
            if(k.getId().equalsIgnoreCase(id)){
                return k;
            }
        }
        throw new RobotNotFound(id);
    }

    @Override
    public Collection<Robot> readAllRobotByTipus(RobotTipus tipus) throws RobotNotFound {
        Collection<Robot> gyar= readAllRobot();
        Collection<Robot> result = new ArrayList<Robot>();
        for (Robot k: gyar){
            if(k.getRobotTipus().equals(tipus)){
                result.add(k);
            }
        }
        return result;
    }

    @Override
    public void deleteRobot(Robot robot) {
        Collection<Robot> gyar = readAllRobot();
        gyar.remove(robot);
    }

    @Override
    public void updateRobot(Robot robot) {

        try {
            Robot result = readRobot(robot.getId());
            result=robot;
        } catch (RobotNotFound robotNotFound) {
            robotNotFound.printStackTrace();
        }

    }
}
