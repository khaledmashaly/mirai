package khaledmashaly.mirai.features.notes

import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/v1/note")
class NoteResource(
    val noteService: NoteService
) {
    @GetMapping
    fun getManyNotes() = noteService.getManyNotes()
}
