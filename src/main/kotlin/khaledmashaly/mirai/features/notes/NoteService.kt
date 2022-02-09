package khaledmashaly.mirai.features.notes

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface NoteService {
    fun getManyNotes(): Flux<Note>
    fun createNote(note: Note): Mono<Note>
}
