package khaledmashaly.mirai.features.notes

import khaledmashaly.mirai.MiraiApplicationTests
import khaledmashaly.mirai.features.notes.mocks.NOTE_MOCKS
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Note endpoints")
class GetManyNotesIntegrationTests: MiraiApplicationTests() {
    @BeforeEach
    override fun setUp() {
        super.setUp()
        mongoOps.insertAll(NOTE_MOCKS).blockLast()
    }

    @Test
    @DisplayName("Returns a list of notes")
    fun returnListOfNotesTest() {
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
