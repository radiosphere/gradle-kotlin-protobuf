package io.radiosphere

import org.infinispan.protostream.annotations.ProtoField
import java.util.*

data class CounterState(
    @get:ProtoField(number = 1) var index: Long? = null,
    @get:ProtoField(number = 2) var uuid: UUID? = null
)
