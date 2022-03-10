package io.radiosphere

import org.infinispan.protostream.FileDescriptorSource
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.Produces

@ApplicationScoped
class ProtoDefinition {
    @Produces
    fun bookProtoDefinition(): FileDescriptorSource {
        return FileDescriptorSource.fromString("library.proto", "package example;\n" +
                "\n" +
                "message CounterState {\n" +
                "  required int64 index = 1;\n" +
                "}\n")
    }
}