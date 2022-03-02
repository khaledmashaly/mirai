package khaledmashaly.mirai.features.notes

import khaledmashaly.mirai.MiraiApplicationTests
import khaledmashaly.mirai.features.notes.mocks.NOTE_MOCKS
import org.hamcrest.Matchers.contains
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
                    .jsonPath("$").value(hasSize<Any>(5))
    }

    @Test
    @DisplayName("Sorts notes by createdDate descending")
    fun sortNotesCreateDateDescending() {
        testClient
            .get()
                .uri("/v1/note")
            .exchange()
                .expectStatus().isOk
                .expectBody()
                    .jsonPath("$").isArray
                    .jsonPath("$[*].id", contains(
                        NOTE_MOCKS[0].id,
                        NOTE_MOCKS[1].id,
                        NOTE_MOCKS[2].id,
                        NOTE_MOCKS[3].id,
                        NOTE_MOCKS[4].id
                    ))
    }

    @Test
    @DisplayName("Adjusts response size using `size` paramter")
    fun adjustResponseSizeUsingSizeParameter() {
        testClient
            .get()
                .uri("/v1/note?size=3")
            .exchange()
                .expectStatus().isOk
                .expectBody()
                .jsonPath("$").isArray
                .jsonPath("$").value(hasSize<Any>(3))
    }

    @Test
    @DisplayName("Adjusts response offset using `page` paramter")
    fun adjustResponseOffsetUsingPageParameter() {
        testClient
            .get()
                .uri("/v1/note?page=1")
            .exchange()
                .expectStatus().isOk
                .expectBody()
                    .jsonPath("$").isArray
                    .jsonPath("$").value(hasSize<Any>(0))
    }

    @Test
    @DisplayName("Requires `page` parameter to be a non-negative integer")
    fun requirePageParameterNonNegativeInteger() {
        testClient
            .get()
                .uri("/v1/note?page=-1")
            .exchange()
                .expectStatus().isBadRequest
    }

    @Test
    @DisplayName("Requires `size` parameter to be a positive integer")
    fun requireSizeParameterPositiveInteger() {
        testClient
            .get()
                .uri("/v1/note?size=0")
            .exchange()
                .expectStatus().isBadRequest
    }

    @Test
    @DisplayName("Requires `size` parameter to be less than 101")
    fun requireSizeParameterMax() {
        testClient
            .get()
                .uri("/v1/note?size=101")
            .exchange()
                .expectStatus().isBadRequest
    }
}
