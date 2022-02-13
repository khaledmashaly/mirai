package khaledmashaly.mirai.features.notes

import khaledmashaly.mirai.MiraiApplicationTests
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.startsWith
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.MediaType
import reactor.test.StepVerifier
import java.time.LocalDate

@DisplayName("Create a note")
class CreateNoteIntegrationTests: MiraiApplicationTests() {
    @Test
    @DisplayName("Adds a new note")
    fun addNewNoteTest() {
        val request = """{
            |"title": "new note title",
            |"description": "new note description"
        |}""".trimMargin()

        testClient
            .post()
                .uri("/v1/note")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
            .exchange()
                .expectStatus().isCreated
                .expectBody()
                    .jsonPath("$.length()").value(equalTo(6))
                    .jsonPath("$.id").exists()

        val eventualCount = mongoOps.count(Query(), Note::class.java)

        StepVerifier
            .create(eventualCount)
            .expectNext(1)
            .verifyComplete()
    }

    @Test
    @DisplayName("Sets title and description")
    fun setTitleDescriptionTest() {
        val request = """{
            |"title": "new note title",
            |"description": "new note description"
        |}""".trimMargin()

        testClient
            .post()
                .uri("/v1/note")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
            .exchange()
                .expectStatus().isCreated
                .expectBody()
                    .jsonPath("$.title").value(equalTo("new note title"))
                    .jsonPath("$.description").value(equalTo("new note description"))
    }

    @Test
    @DisplayName("Sets auditing properties: createdDate, lastModifiedDate, version")
    fun setAuditingProperties() {
        val request = """{
            |"title": "new note title",
            |"description": "new note description"
        |}""".trimMargin()

        testClient
            .post()
                .uri("/v1/note")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
            .exchange()
                .expectStatus().isCreated
                .expectBody()
                    .jsonPath("$.createdDate").value(startsWith(LocalDate.now().toString()))
                    .jsonPath("$.lastModifiedDate").value(startsWith(LocalDate.now().toString()))
                    .jsonPath("$.version").value(equalTo(0))
    }
}
