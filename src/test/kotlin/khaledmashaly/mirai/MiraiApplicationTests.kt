package khaledmashaly.mirai

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class MiraiApplicationTests {
    @Autowired
    lateinit var mongoOps: ReactiveMongoOperations
    @Autowired
    lateinit var testClient: WebTestClient
}
