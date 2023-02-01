package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

    @Mock
    Bun bunMock;
    @Spy
    @InjectMocks
    Burger burger;
    @Mock
    Burger burgerMock;

    @Before
    public void setUp() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sauce", 20F));
        ingredients.add(new Ingredient(IngredientType.FILLING, "filling", 10.5F));
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void getPriceBurger() {
        Mockito.when(bunMock.getPrice()).thenReturn(100F);
        assertEquals(230.5F, burger.getPrice(), 0);

    }

    @Test
    public void getReceiptBurger() {
        Mockito.when(bunMock.getName()).thenReturn("Bun");
        assertThat(burger.getReceipt(), is(notNullValue()));
    }

    @Test
    public void removeIngredientInBurger() {
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void addIngredientInBurger() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Salsa", 30F));
        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void moveIngredientInBurger() {
        burger.moveIngredient(0, 1);
        assertEquals(burger.ingredients.get(1).getName(), "sauce");
    }

    @Test
    public void setBunsInBurger() {
        burger.setBuns(bunMock);
        Mockito.verify(burger).setBuns(bunMock);
    }
}
