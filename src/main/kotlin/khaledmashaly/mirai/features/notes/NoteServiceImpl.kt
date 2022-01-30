package khaledmashaly.mirai.features.notes

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Slf4j
@Service
class NoteServiceImpl(
    val noteRepo: NoteRepo
): NoteService {
    override fun getManyNotes() = Flux.just(
        Note(
            title = "First note",
            description = "first description"
        ),
        Note(
            title = "second note",
            description = "second description"
        )
    )
}
