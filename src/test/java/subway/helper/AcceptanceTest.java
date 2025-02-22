package subway.helper;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import subway.helper.db.Truncator;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcceptanceTest implements InitializingBean {

    @LocalServerPort
    private int port;

    @Autowired
    private Truncator truncator;

    @BeforeEach
    public void setPort() {
        RestAssured.port = port;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        truncator.truncateAll();
    }
}
