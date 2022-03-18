#!/bin/sh

java -jar -Dquarkus.http.port=$1 -Dquarkus.profile=dev build/quarkus-app/quarkus-run.jar
