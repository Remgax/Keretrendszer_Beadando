package uni.eszterhazy.m5apwk.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uni.eszterhazy.m5apwk.dao.RobotDAO;
import uni.eszterhazy.m5apwk.json.RobotDAOJSON;
import uni.eszterhazy.m5apwk.service.impl.RobotServiceImpl;

import java.io.IOException;

@Configuration
public class RobotConfig {
    @Bean("robotDB")
    public RobotServiceImpl service() throws IOException{
        RobotDAO dao = new RobotDAOJSON("database.json");
        return new RobotServiceImpl(dao);
    }
}
