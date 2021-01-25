import beadando.m5apwk.dao.DiakDAO;
import beadando.m5apwk.dao.relational.DiakDAORelational;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@Configuration
public class MyConfig {
    @Bean("diakDB")
    public DiakDAO mysqldb()
    {
        return new DiakDAORelational();
    }
}
