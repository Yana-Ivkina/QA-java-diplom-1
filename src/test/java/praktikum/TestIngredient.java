package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIngredient {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Sauce", 100F);

    @Test
    public void returnType() {
        assertEquals(ingredient.getType(), IngredientType.SAUCE);
    }

    @Test
    public void returnName() {
        assertEquals(ingredient.getName(), "Sauce");
    }

    @Test
    public void returnPrice() {
        assertEquals(ingredient.getPrice(), 100, 0);
    }
}
