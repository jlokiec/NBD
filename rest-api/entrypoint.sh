#!/bin/bash
sleep 100
java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
