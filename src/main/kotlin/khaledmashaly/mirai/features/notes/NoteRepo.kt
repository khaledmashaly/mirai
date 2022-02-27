package khaledmashaly.mirai.features.notes

import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import java.util.*

interface NoteRepo: ReactiveMongoRepository<Note, UUID> {
    fun findAll(pageable: Pageable): Flux<Note>
}
