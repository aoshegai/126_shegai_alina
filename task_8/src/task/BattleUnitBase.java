package task;

import javax.swing.*;
import java.beans.BeanProperty;

public abstract class BattleUnitBase implements BattleUnit {
    private String name;
    private int maxHealth;
    private int baseStrength;
    private int maxArmor;
    private int health;
    private int strength;
    private int armor;

    public BattleUnitBase(String name, int maxHealth, int baseStrength, int maxArmor) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.baseStrength = baseStrength;
        this.maxArmor = maxArmor;
        health = maxHealth;
        strength = baseStrength;
        armor = maxArmor;
    }

    @Override
    public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);
    @Override
    public abstract void attack(BattleUnit other);
    @Override
    public String name() {
        return name;
    }
    @Override
    public int health() {
        return health;
    }
    @Override
    public int maxHealth() {
        return maxHealth;
    }
    @Override
    public int baseStrength() {
        return baseStrength;
    }
    @Override
    public int maxArmor() {
        return maxArmor;
    }
    @Override
    public int strength() {
        return strength;
    }
    @Override
    public int armor() {
        return armor;
    }
    @Override
    public void setMaxHealth(int value) {
        int maxHealthChange;
        if (value < 0) {
            maxHealthChange = maxHealth;
            maxHealth = 0;
        } else {
            maxHealthChange = value;
            maxHealth = value;
        }
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    @Override
    public void heal(int value) {
        int healthChange;
        if (health + value > maxHealth) {
            healthChange = maxHealth - health;
            health = maxHealth;
        } else {
            healthChange = value;
            health += value;
        }
    }
    @Override
    public void takeDamage(int value) {
        int damage;
        if (health - value < 0) {
            damage = health;
            health = 0;
        } else {
            damage = value;
            health -= value;
        }
    }
    @Override
    public void setStrength(int value) {
        strength = value;
    }
    @Override
    public void restoreArmor(int value) {
        if (value + armor > maxArmor) {
            armor = maxArmor;
        } else {
            armor += value;
        }
    }
    @Override
    public void damageArmor(int value) {
        int damage;
        if (armor - value < 0) {
            damage = armor;
            armor = 0;
        } else {
            damage = value;
            armor -= value;
        }
    }
    @Override
    public void setMaxArmor(int value) {
        maxArmor = value;
        if (armor > maxArmor) {
            armor = maxArmor;
        }
    }
}
