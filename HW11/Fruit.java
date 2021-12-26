package HW11;

import java.util.Objects;

public abstract class Fruit {

    protected float weight;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public abstract String getName();

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }


}
