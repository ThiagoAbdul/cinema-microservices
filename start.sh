#!/bin/bash

for d in $(ls | grep cinema); do
    cd ./$d/
    ./start.sh &
    cd ..
done