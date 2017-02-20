%%
%standalone
iden = ([$]|{let})[a-zA-Z0-9$_.]+
let = [a-zA-Z]
consint = ({decint}|{octint}|{hexint})
consreal = ({decreal}|{octreal}|{hexreal})
decint = [+|-]?[0-9]+
octint = [0][+|-]?[0-7]+
hexint = "0x"[+|-]?[0-9A-F]+
decreal = {decint}"."[0-9]+
octreal = {octint}"."[0-7]+
hexreal = {hexint}"."[0-9A-Z]+
conslit = "'"([^']|"\\'")+"'"
comentario = ({barrab}|{barraa})
barrab = "//"[^\n]+
barraa = "/*"([^*]|"*"[^/])+"*/"

%%
{iden} {System.out.print("<ident>");}
{consint} {System.out.print("<int>");}
{consreal} {System.out.print("<real>");}
{conslit} {System.out.print("<constlit>");}
{comentario} {System.out.print("<comentario>");}