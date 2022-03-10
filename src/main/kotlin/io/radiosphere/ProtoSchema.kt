package io.radiosphere

import org.infinispan.protostream.GeneratedSchema
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
@AutoProtoSchemaBuilder(includeClasses = [CounterState::class], schemaPackageName = "tutorial")
interface ProtoSchema : GeneratedSchema {
}