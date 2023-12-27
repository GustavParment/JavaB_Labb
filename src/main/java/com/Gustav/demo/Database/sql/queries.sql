select
    m.MonsterName,
    f.DamageDonebyDefender,
    p.ClassName,
    f.DamageDoneByAttacker,
    f.Result
from fighthistory f
join monster m on m.monster_id = f.monster_id
join player p on p.player_id = f.player_id
where p.player_id = 9;