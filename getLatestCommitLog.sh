#!/bin/bash

git show `git log --oneline | grep "README" | head -1 | cut -d " " -f1`