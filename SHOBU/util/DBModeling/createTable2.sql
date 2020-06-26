use shobu;
create table team(
teamCode varchar(10) primary key,
image varchar(50),
ranking int(10),
games int(10),
win int(10),
draw int(10),
lose int(10),
rate double(4,3),
distance double(3,1),
teamAVG double(4,3),
teamERA double(4,2),
stream varchar(50),
games10 varchar(50));
create table player(
playerId int(10) primary key,
teamCode varchar(10),
name varchar(10),
position varchar(10),
image varchar(50),
number int(10),
birth varchar(20),
type varchar(10),
foreign key(teamCode) references team(teamCode) on delete cascade);
create table pitcher(
playerid int(10),
games int(10),
inning varchar(10),
era double(5,2),
rate double(3,2),
win int(10),
lose int(10),
save int(10),
hold int(10),
runs int(10),
hr int(10),
hits int(10),
so int(10),
bb int(10),
foreign key(playerid) references player(playerid) on delete cascade);
create table hitter(
playerId int(10),
games int(10),
rate double(4,3),
ab int(10),
hits int(10),
hr int(10),
rbi int(10),
runs int(10),
bb int(10),
so int(10),
obp double(4,3),
slg double(4,3),
ops double(4,3),
steal int(10),
error int(10),
foreign key(playerid) references player(playerid) on delete cascade);
create table matches(
date varchar(10),
time varchar(10),
home varchar(10),
away varchar(10),
homePitcher varchar(10),
awayPitcher varchar(10),
place varchar(10));
create table members(
id varchar(10) primary key,
password varchar(20) not null,
nickName varchar(20),
image varchar(50),
point int(10));
create table chat(
chatId int(10) primary key auto_increment,
id varchar(10),
word varchar(200),
date_time datetime,
foreign key(id) references members(id) on delete cascade);
create table toto(
id varchar(10),
date date,
game1 varchar(10),
game2 varchar(10),
game3 varchar(10),
game4 varchar(10),
game5 varchar(10),
foreign key(id) references members(id) on delete cascade);
create table pitcher3(
playerId int(10),
day1 varchar(20),
day2 varchar(20),
day3 varchar(20),
foreign key(playerId) references player(playerId) on delete cascade);