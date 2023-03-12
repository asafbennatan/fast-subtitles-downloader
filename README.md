# fast-subtitles-downloader
command line options for fast downloading subtitles using open subtitles api (opensubtitles.com)


#### NAME
download - download subtitles

#### SYNOPSIS
download -n boolean [-i File] [-l String[]] -f boolean -r boolean -m int [-t String] [-u String] [-p String] --title String --season Integer --episode Integer --help

#### OPTIONS
```
-n boolean
search subtitles by name first
[Optional, default = false]

-i File
input file or directory
[Mandatory]

-l String[]
language, comma delimited language codes
[Mandatory]

-f boolean
force download
[Optional, default = false]

-r boolean
recursive , search recursively on the file provided by -i
[Optional, default = false]

-m int
minimum score, filters results by minimum user's score
[Optional, default = 0]

-t String
token, API token obtained from opensubtitles.com
[Mandatory]

-u String
username, opensubtitles.com username
[Mandatory]

-p String
password, opensubtitles.com username
[Mandatory]

--title String
title, hint title in case filenames do not follow known format
[Optional]

--season Integer
season, hint season in case filenames do not follow known format
[Optional]

--episode Integer
episode, hint episode in case filenames do not follow known format
[Optional]

--help or -h 
help for download
[Optional]```



 
 
 
 
