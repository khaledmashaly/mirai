package khaledmashaly.mirai.features.notes

import khaledmashaly.mirai.MiraiApplicationTests
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.MediaType

@DisplayName("Create a note")
class CreateNoteIntegrationTests: MiraiApplicationTests() {
    @Test
    @DisplayName("Adds a new note")
    fun `Adds a new note test`() {
        val request = """{
            "title": "new note title",
            "description": "new note description"
        }"""

        testClient
            .post()
            .uri("/v1/note")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .exchange()
            .expectStatus().isCreated
            .expectBody()
            .jsonPath("$.length()").value(`is`(5))
            .jsonPath("$.id").exists()
            .jsonPath("$.createdAt").exists()
            .jsonPath("$.updatedAt").exists()
            .jsonPath("$.title").value(`is`("new note title"))
            .jsonPath("$.description").value(`is`("new note description"))

        assertThat(mongoOps.count(Query(), Note::class.java)).isEqualTo(1)
    }
}
