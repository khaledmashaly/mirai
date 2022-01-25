package khaledmashaly.mirai.features.notes

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import java.util.*

interface NoteRepo: ReactiveMongoRepository<Note, UUID>
