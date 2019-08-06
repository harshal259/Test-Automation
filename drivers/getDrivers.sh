#!/bin/bash

curl -s https://api.github.com/repos/harshal259/HelloWorld/releases/latest \
| grep "browser_download_url.*exe" \
| cut -d : -f 2,3 \
| tr -d \" \
| wget -qi -


# https://eternallybored.org/misc/wget/