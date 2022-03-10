package io.radiosphere

import org.infinispan.protostream.annotations.ProtoField

data class CounterState(@get:ProtoField(number = 1) var index: Long? = null)
