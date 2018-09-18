#!/bin/bash
sbt clean compile assembly
docker build -t videoamp/audience-sizing .

