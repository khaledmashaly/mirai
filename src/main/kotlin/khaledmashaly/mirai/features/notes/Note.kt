package khaledmashaly.mirai.features.notes

import org.springframework.data.annotation.*
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document
@TypeAlias("mirai.features.note")
class Note(
    @Id
    val id: UUID = UUID.randomUUID(),
    @CreatedDate
    val createdDate: LocalDateTime,
    @LastModifiedDate
    val lastModifiedDate: LocalDateTime,
    @Version
    val version: Long,
    val title: String,
    val description: String,
)
