package khaledmashaly.mirai.features.notes

import reactor.core.publisher.Flux

interface NoteService {
    fun getManyNotes(): Flux<Note>
}