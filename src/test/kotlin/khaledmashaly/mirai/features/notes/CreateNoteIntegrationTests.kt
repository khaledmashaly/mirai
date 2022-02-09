package khaledmashaly.mirai.features.notes

import khaledmashaly.mirai.MiraiApplicationTests
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.MediaType
import reactor.test.StepVerifier

@DisplayName("Create a note")
class CreateNoteIntegrationTests: MiraiApplicationTests() {
    @Test
    @DisplayName("Adds a new note")
    fun `Adds a new note test`() {
        val request = """{"title": "new note title","description": "new note description"}"""

        testClient
            .post()
                .uri("/v1/note")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
            .exchange()
                .expectStatus().isCreated
                .expectBody()
                    .jsonPath("$.length()").value(`is`(6))
                    .jsonPath("$.id").exists()
                    .jsonPath("$.title").value(`is`("new note title"))
                    .jsonPath("$.description").value(`is`("new note description"))

        val eventualCount = mongoOps.count(Query(), Note::class.java)

        StepVerifier
            .create(eventualCount)
            .expectNext(1)
            .verifyComplete()
    }
}
