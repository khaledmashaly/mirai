package khaledmashaly.mirai.features.notes

import khaledmashaly.mirai.MiraiApplicationTests
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.reactive.server.WebTestClient

@DisplayName("Note endpoints")
class GetManyNotesIntegrationTests: MiraiApplicationTests() {
    @Autowired
    lateinit var testClient: WebTestClient

    @Test
    @DisplayName("Returns a list of notes")
    fun `Returns a list of notes`() {
        testClient
            .get()
            .uri("/v1/note")
            .exchange()
            .expectStatus().isOk
            .expectBody()
                .jsonPath("$").isArray
                .jsonPath("$").value(hasSize<Any>(2))
    }
}
