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
    ),

    Note(
        id = UUID.fromString("2784c59e-21e2-4b1f-8c23-d165af5319a4"),
        createdDate = TODAY.minusDays(2),
        lastModifiedDate = TODAY.minusDays(2),
        version = 0,
        title = "title-3",
        description = "description-3",
    ),

    Note(
        id = UUID.fromString("dd590182-1c18-4db8-9a6a-86586cb58f82"),
        createdDate = TODAY.minusDays(3),
        lastModifiedDate = TODAY.minusDays(3),
        version = 0,
        title = "title-4",
        description = "description-4",
    ),

    Note(
        id = UUID.fromString("b6a792fd-1a0a-44ac-b11d-c447bb7b5158"),
        createdDate = TODAY.minusDays(4),
        lastModifiedDate = TODAY.minusDays(4),
        version = 0,
        title = "title-5",
        description = "description-5",
    )
)
