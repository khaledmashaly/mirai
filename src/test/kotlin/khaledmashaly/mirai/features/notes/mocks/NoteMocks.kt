package khaledmashaly.mirai.features.notes.mocks

import khaledmashaly.mirai.features.notes.Note
import java.time.LocalDateTime
import java.util.*

private val TODAY = LocalDateTime.now()

val NOTE_MOCKS = listOf(
    Note(
        id = UUID.fromString("53016adc-e8f2-449c-b345-407a21a9c8e2"),
        createdDate = TODAY,
        lastModifiedDate = TODAY,
        version = 0,
        title = "title-1",
        description = "description-1",
    ),

    Note(
        id = UUID.fromString("af296b29-c98e-4719-b51d-941ac491a854"),
        createdDate = TODAY.minusDays(1),
        lastModifiedDate = TODAY.minusDays(1),
        version = 0,
        title = "title-2",
        description = "description-2",
    )
)
