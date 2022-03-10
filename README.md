# gradle-kotlin-protobuf-example Project

This project shows how to use the Infinispan annotation processor `org.infinispan.protostream:protostream-processor` to generate your protobuf classes when you're using Gradle and Kotlin.

You can find the processor project [here](https://github.com/infinispan/protostream), where it is outlined how you can use the project together with `Maven`.

With `Gradle` there's one initial challenge of getting the annotation processor to run. If you're running a java project this is done using:
```
    annotationProcessor 'org.infinispan.protostream:protostream-processor:4.4.0.Final'
```

To get it to work when you're using kotlin you need to use `kapt`, it's the annotations processor for `kotlin` and `gradle`. You do this by adding the plugin in your build.gradle:
```
plugins {
    id 'org.jetbrains.kotlin.jvm' version "1.5.31"
    id "org.jetbrains.kotlin.plugin.allopen" version "1.5.31"
    id 'io.quarkus'
}
apply plugin: 'kotlin-kapt'
```

Then you add the annotations processor in your build.gradle:
```
dependencies {
    implementation enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}")
    implementation 'io.quarkus:quarkus-infinispan-client'
    ...

    compileOnly 'org.infinispan.protostream:protostream-processor:4.4.1.Final'
    kapt    'org.infinispan.protostream:protostream-processor:4.4.1.Final'
}
```

Now it's just about annotating your class in a way that works. A Java class would look like this:
```
@Data
public class CounterState {
    private Long index;

    @ProtoFactory
    public CounterState(Long index) {
        this.index = index;
    }

    @ProtoField(number = 1)
    public Long getIndex() {
        return index;
    }
}
```

It's possible to squeeze this into a kotlin data class though:
```
data class CounterState(@get:ProtoField(number = 1) var index: Long? = null) {
```
