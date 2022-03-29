package task;

public class ArmorDestroyer extends BattleUnitBase {
    public ArmorDestroyer(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        int maxArmor = -1;
        BattleUnit enemy = null;
        for (int i = 0; i < enemyTeam.length; i++) {
            if ((enemyTeam[i].health() > 0) && (enemyTeam[i].maxArmor() > maxArmor)) {
                maxArmor = enemyTeam[i].maxArmor();
                enemy = enemyTeam[i];
            }
        }
        if (enemy.armor() > 0) enemy.damageArmor(strength() * 2);
        else enemy.takeDamage(strength()/4);
    }
    public void attack(BattleUnit other) {
        if (other.armor() > 0) {
            if (strength()/4 > 0) {
                other.takeDamage(strength()/4);
            } else {
                other.takeDamage(1);
            }
            if (strength() > 0) {
                other.damageArmor(strength());
            } else {
                other.takeDamage(1);
            }
        } else {
            other.takeDamage(strength()/2);
        }
    }
}
