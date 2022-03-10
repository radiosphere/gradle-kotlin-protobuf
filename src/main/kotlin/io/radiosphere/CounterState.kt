package io.radiosphere

import org.infinispan.protostream.annotations.ProtoFactory
import org.infinispan.protostream.annotations.ProtoField

data class CounterState(@get:ProtoField(number = 1) var index: Long? = null) {

//    @ProtoFactory
//    constructor(index: Long?) : this() {
//        this.index = index
//    }

//    @get:ProtoField(number = 1)
//    var index: Long? = 0
}