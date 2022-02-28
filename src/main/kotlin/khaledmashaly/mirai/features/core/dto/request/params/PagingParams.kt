package khaledmashaly.mirai.features.core.dto.request.params

import javax.validation.constraints.Max
import javax.validation.constraints.Min

data class PagingParams(
    @field:Min(0)
    val page: Int = 0,

    @field:Min(1)
    @field:Max(100)
    val size: Int = 10,
)
