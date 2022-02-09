package khaledmashaly.mirai.features.notes.dto.request

import javax.validation.constraints.NotBlank

data class CreateNoteRequest(
    @NotBlank
    val title: String,

    @NotBlank
    val description: String,
)
