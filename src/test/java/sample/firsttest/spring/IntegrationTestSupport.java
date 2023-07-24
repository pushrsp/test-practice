package sample.firsttest.spring;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import sample.firsttest.spring.client.mail.MailSendClient;

@ActiveProfiles("test")
@SpringBootTest
public class IntegrationTestSupport {
    @MockBean
    protected MailSendClient mailSendClient;
}
