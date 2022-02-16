package khaledmashaly.mirai.features.notes

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Slf4j
@Service
class NoteServiceImpl(
    val noteRepo: NoteRepo
): NoteService {
    override fun getManyNotes() = noteRepo.findAll()

    override fun createNote(note: Note) = noteRepo.save(note)
}
