package khaledmashaly.mirai.features.notes

import khaledmashaly.mirai.features.notes.dto.params.NoteServiceGetManyParams
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface NoteService {
    fun getManyNotes(params: NoteServiceGetManyParams): Flux<Note>
    fun createNote(note: Note): Mono<Note>
}
