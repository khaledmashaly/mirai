package khaledmashaly.mirai.features.notes

import khaledmashaly.mirai.features.notes.dto.request.CreateNoteRequest
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import javax.validation.Valid

@Slf4j
@RestController
@RequestMapping("/v1/note")
class NoteResource(
    val noteService: NoteService
) {
    @GetMapping
    fun getManyNotes() = noteService.getManyNotes()

    @PostMapping(
        path = [""],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun createNote(@Valid @RequestBody eventualRequest: Mono<CreateNoteRequest>) =
        eventualRequest
            .map { request -> Note(title = request.title, description = request.description) }
            .flatMap(noteService::createNote)
}
