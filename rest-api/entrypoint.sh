#!/bin/bash
sleep 180
java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
