# fast-subtitles-downloader
command line options for fast downloading subtitles using open subtitles api

usage: fast-subtitles-downloader
 -f           use for forcing download subtitle even if the file exists
 
 -help        print this message
 
 -i <arg>     use given file/folder for subtitles download
 
 -l <arg>     comma delimited list of subtitles langauge for example:
              heb,eng will download heb if possible and otherwise will
              fallback to eng
              
 -log <arg>   use for creating a log file
 
 -m <arg>     use for removing subtitles under score
 
 -n           search by name first
 
 -r           use for recursively iterating over directories
 
 
 credits:
 
 apache commons, apache xml-rpc ,
 port of opensub4j: https://github.com/wtekiela/opensub4j
 port of episode-parser: https://github.com/tregusti/episode-parser
 
 
 
 
 
