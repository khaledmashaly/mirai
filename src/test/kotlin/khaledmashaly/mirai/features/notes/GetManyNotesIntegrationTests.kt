package khaledmashaly.mirai.features.notes

import khaledmashaly.mirai.MiraiApplicationTests
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Note endpoints")
class GetManyNotesIntegrationTests: MiraiApplicationTests() {
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
