package task;

public class Alchemist extends BattleUnitBase {
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        int hpMin = Integer.MAX_VALUE;
        int hpMax = 0;
        BattleUnit minAlly = null;
        BattleUnit maxAlly = null;
        for (int i = 0; i < ownTeam.length; i++){
            if ((ownTeam[i].health() < hpMin) && (ownTeam[i].health() > 0)) {
                hpMin = ownTeam[i].health();
                minAlly = ownTeam[i];
            }
            if ((ownTeam[i].health() > hpMax) && (ownTeam[i].health() > 0)) {
                hpMax = ownTeam[i].health();
                maxAlly = ownTeam[i];
            }
        }
        minAlly.heal(10);
        maxAlly.setStrength(maxAlly.strength() + 1);
    }
    public void attack(BattleUnit other) {
        other.setStrength(other.strength() - 2);
        other.setMaxHealth(other.maxHealth() - 4);
    }
}
