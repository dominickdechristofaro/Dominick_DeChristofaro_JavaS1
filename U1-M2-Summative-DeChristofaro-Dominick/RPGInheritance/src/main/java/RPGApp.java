public class RPGApp {
    public static void main(String[] args) {
        Farmer farmer = new Farmer();
        Constable constable = new Constable(10);
        Warrior warrior = new Warrior();

        farmer.plow();
        farmer.harvest();
        constable.arrest();
        warrior.decreaseShieldStrength();
    }
}
