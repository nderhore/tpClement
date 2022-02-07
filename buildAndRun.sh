#!/bin/sh
mvn clean package && docker build -t com.lol.app/lol .
docker rm -f lol || true && docker run -d -p 9080:9080 -p 9443:9443 --name lol com.lol.app/lol