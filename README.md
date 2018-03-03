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
 
 example:
 
 java -jar fast-subtitles-downloader-1.5.jar -i "C:\Users\Asaf\Downloads\someMovieFolder\" -l heb,eng -f -m 5
 will download subtitles for all video files in C:\Users\Asaf\Downloads\someMovieFolder\ folder , will prefer hebrew lang over english if subtitle rating is over 5
 
 
 credits:
 
 apache commons, apache xml-rpc ,

 port of opensub4j: https://github.com/wtekiela/opensub4j
 
 port of episode-parser: https://github.com/tregusti/episode-parser
 
 
 
 
 
