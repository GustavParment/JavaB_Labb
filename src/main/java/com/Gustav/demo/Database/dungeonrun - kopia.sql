# ---------------------------------------------------------------------- #
# Create Database "dungeonrun"                                           #
# ---------------------------------------------------------------------- #

DROP DATABASE IF EXISTS dungeonrun;

CREATE DATABASE IF NOT EXISTS dungeonrun;

USE dungeonrun;

# ---------------------------------------------------------------------- #
# Create table "player"                                                  #
# ---------------------------------------------------------------------- #

CREATE TABLE IF NOT EXISTS player (
    player_id INT NOT NULL AUTO_INCREMENT,
    ClassName VARCHAR(100), 
    Health INT,
    Spirit INT,
    Strength INT,
    Agility INT,
    Damage INT,
    level INT,
    Gold INT,
    RoomsCompleted INT,
    Date VARCHAR(50),
    PRIMARY KEY(player_id)
    
);

# ---------------------------------------------------------------------- #
# Create table "monster"                                                 #
# ---------------------------------------------------------------------- #

CREATE TABLE IF NOT EXISTS monster(
    monster_id INT NOT NULL AUTO_INCREMENT,
    MonsterName VARCHAR(50),
    MonsterLevel INT,
    MonsterDamage INT,
    MonsterBaseHealth INT,
    MonsterSpirit INT,
    MonsterAgility INT,
    MonsterGold INT,
    PRIMARY KEY (monster_id)
);

# ---------------------------------------------------------------------- #
# Create table "item"                                                    #
# ---------------------------------------------------------------------- #

CREATE TABLE IF NOT EXISTS item (
    item_id INT NOT NULL AUTO_INCREMENT,
    Itemname VARCHAR(50),
    Health INT,
    Spirit INT,
    Strength INT,
    Agility INT,
    ItemPrice varchar(50),
    PRIMARY KEY (item_id)
);


# ---------------------------------------------------------------------- #
# Create table "playeritem"                                              #
# ---------------------------------------------------------------------- #

CREATE TABLE IF NOT EXISTS itemhistory (
	itemhistory_id INT NOT NULL AUTO_INCREMENT,
	player_id INT,
	item_id INT,
	PRIMARY KEY (itemhistory_id)
    
);

# ---------------------------------------------------------------------- #
# Create table "figthhistory"                                            #
# ---------------------------------------------------------------------- #

CREATE TABLE IF NOT EXISTS fighthistory (
	fighthistory_id INT NOT NULL AUTO_INCREMENT,
	DefenderHealth INT,
	DamageDonebyDefender INT,
	DamageDoneByAttacker INT,
	Result varchar(50),
	Time varchar(50),
	monster_id INT,
	player_id INT,
	PRIMARY KEY (fighthistory_id)

);

# ---------------------------------------------------------------------- #
# Add values into "item"                                                 #
# ---------------------------------------------------------------------- #

TRUNCATE TABLE item;

INSERT INTO item (Itemname, Health, Spirit, Strength, Agility, ItemPrice) 
VALUES('Book Of Wisdom', 20, 10 , 10 , 10, '20 Gold');

INSERT INTO item (ItemName, Health, ItemPrice) 
VALUES('Health Potion', 20, '20 Gold');

INSERT INTO item (ItemName,Spirit,Strength, Agility, ItemPrice) 
VALUES('Golem Heart Longbow', 10 , 30, 20, '40 Gold' );

INSERT INTO item (ItemName, Spirit, Strength, Agility,ItemPrice) 
VALUES('High Scholars Grand Staff', 30 , 10 , 20 , '40 Gold' );

INSERT INTO item (ItemName,Spirit, Strength,  Agility, ItemPrice) 
VALUES('Lung Breaker Dagger', 40 , 40 , 40 , '80 Gold' );

INSERT INTO item (ItemName, Health,ItemPrice) 
VALUES('Super Health Potion', 100 , '80 Gold');

INSERT INTO item(ItemName,Strength)
VALUES('Relic Of Fury',20);

INSERT INTO item(ItemName,Health)
VALUES('Relic Of Life',200);

INSERT INTO item(ItemName,Agility )
VALUES('Relic Of Protection',20);
# ---------------------------------------------------------------------- #
# Add values into "monster"                                              #
# ---------------------------------------------------------------------- #

TRUNCATE TABLE monster;

INSERT INTO monster (MonsterName, MonsterLevel,MonsterDamage,MonsterBaseHealth,MonsterAgility,MonsterGold)
VALUES ('Medusa',1,5,45,3,20 );

INSERT INTO monster (MonsterName,MonsterLevel,MonsterDamage,MonsterBaseHealth,MonsterAgility,MonsterGold)
VALUES ('Titan', 2,10,80,20,20);

INSERT INTO monster (MonsterName,MonsterLevel,MonsterDamage,MonsterBaseHealth,MonsterAgility,MonsterGold)
VALUES ('Giant Black Squirrel',3,30,110,25,20 );

INSERT INTO monster (MonsterName,MonsterLevel,MonsterDamage,MonsterBaseHealth,MonsterSpirit,MonsterAgility,MonsterGold)
VALUES ('La Chancla',4,45,150,20,40,30 );

INSERT INTO monster (MonsterName,MonsterLevel,MonsterDamage,MonsterBaseHealth,MonsterSpirit,MonsterAgility,MonsterGold)
VALUES ('The Bad DJ',5,30,200,30,50,30 );

INSERT INTO monster (MonsterName,MonsterLevel,MonsterDamage,MonsterBaseHealth,MonsterSpirit,MonsterAgility,MonsterGold)
VALUES ('Frida',6,55,300,70,65,70 );

INSERT INTO monster (MonsterName,MonsterLevel,MonsterDamage,MonsterBaseHealth,MonsterSpirit,MonsterAgility,MonsterGold)
VALUES ('Benny',7,60,400,70,70,100 );

# ---------------------------------------------------------------------- #
# Set foreign keys to "fighthistory"                                        #
# ---------------------------------------------------------------------- #

ALTER TABLE fighthistory
ADD CONSTRAINT fk_fighthistory_monster
FOREIGN KEY (monster_id) REFERENCES monster(monster_id);

ALTER TABLE fighthistory
ADD CONSTRAINT fk_fighthistory_player
FOREIGN KEY (player_id) REFERENCES player(player_id);

# ---------------------------------------------------------------------- #
# Set foreign keys to "itemhistory"                                         #
# ---------------------------------------------------------------------- #

ALTER TABLE itemhistory 
ADD CONSTRAINT fk_itemhistory_player
FOREIGN KEY (player_id) REFERENCES player(player_id);

ALTER TABLE itemhistory 
ADD CONSTRAINT fk_itemhistory_item
FOREIGN KEY (item_id) REFERENCES item(item_id);


