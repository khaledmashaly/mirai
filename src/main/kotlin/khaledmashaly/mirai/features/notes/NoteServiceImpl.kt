package khaledmashaly.mirai.features.notes

import khaledmashaly.mirai.features.notes.dto.params.NoteServiceGetManyParams
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Slf4j
@Service
class NoteServiceImpl(
    val noteRepo: NoteRepo
): NoteService {
    override fun getManyNotes(params: NoteServiceGetManyParams) = noteRepo.findAllBy(
        PageRequest.of(
            params.page,
            params.size,
            Sort.by(Sort.Order(Sort.Direction.DESC, "createdDate")),
        )
    )

    override fun createNote(note: Note) = noteRepo.save(note)
}
