package Things;

import Interfaces.WithName;

public abstract class Food implements WithName {
    protected boolean bake;

    public void bake(){
        this.bake = true;
    }

    public abstract String getType();

    @Override
    public String getName() {
        if (bake){
            return "печенный " + getType();
        } else {
            return getType();
        }
    }
    public static class AppleStatic extends Food {
        @Override
        public String getType() {
            return "яблоко";
        }
    }
}
