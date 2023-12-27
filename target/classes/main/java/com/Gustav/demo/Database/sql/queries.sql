select *
from player p
join dungeonrun.fighthistory f on p.player_id = f.player_id
where p.player_id = 1
