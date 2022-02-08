package khaledmashaly.mirai.features.notes

import org.springframework.data.annotation.*
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document
@TypeAlias("mirai.features.note")
data class Note(
    @Id
    val id: UUID = UUID.randomUUID(),
    @CreatedDate
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    val lastModifiedDate: LocalDateTime = LocalDateTime.now(),
    @Version
    val version: Long = 0,
    val title: String,
    val description: String,
)
