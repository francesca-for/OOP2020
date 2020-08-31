package diet;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a complete menu.
 * 
 * It can be made up of both packaged products and servings of given recipes.
 *
 */
public class Menu implements NutritionalElement {
	private String name;
	private Food food;
	
	private double totCalories=0;
	private double totProteins=0;
	private double totCarbs=0;
	private double totFat=0;
//	private double totQuantity = 0;
	
	private List<Portion> portions = new ArrayList<>();
	private List<NutritionalElement> products = new ArrayList<>();

	public Menu(String name, Food food) {
		this.name = name;
		this.food = food;
	}
	
	/**
	 *  Classe interna Portion
	 *  Una porzione è data da una ricetta e dalla quantità in grammi della stessa 
	 */
	private class Portion {
		NutritionalElement recipe;
		double quantity;
		Portion(NutritionalElement portion, double quantity) {
			this.recipe = portion;
			this.quantity = quantity;
		}
	}
	
	/**
	 * Adds a given serving size of a recipe.
	 * 
	 * The recipe is a name of a recipe defined in the
	 * {@Link Food} in which this menu has been defined.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 * @return the same Menu to allow method chaining
	 */
	public Menu addRecipe(String recipe, double quantity) {
		Portion p = new Portion(food.getRecipe(recipe), quantity);
		final double x = quantity/100;
		
		portions.add(p);
		
		totCalories += food.getRecipe(recipe).getCalories() * x;
	    totProteins += food.getRecipe(recipe).getProteins() * x;
	    totCarbs += food.getRecipe(recipe).getCarbs() * x;
	    totFat += food.getRecipe(recipe).getFat() * x;
//	    totQuantity += quantity;
		
		return this;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the
	 * {@Link Food} in which this menu has been defined.
	 * 
	 * @param product the name of the product to be used as ingredient
	 * @return the same Menu to allow method chaining
	 */
	public Menu addProduct(String product) {
		products.add(food.getProduct(product));
		
		totCalories += food.getProduct(product).getCalories();
	    totProteins += food.getProduct(product).getProteins();
	    totCarbs += food.getProduct(product).getCarbs();
	    totFat += food.getProduct(product).getFat();
		
		return this;
	}

	/**
	 * Name of the menu
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Total KCal in the menu
	 */
	@Override
	public double getCalories() {
		return totCalories;
	}

	/**
	 * Total proteins in the menu
	 */
	@Override
	public double getProteins() {
		return totProteins;
	}

	/**
	 * Total carbs in the menu
	 */
	@Override
	public double getCarbs() {
		return totCarbs;
	}

	/**
	 * Total fats in the menu
	 */
	@Override
	public double getFat() {
		return totFat;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Menu} class it must always return {@code false}:
	 * nutritional values are provided for the whole menu.
	 * 
	 * @return boolean 	indicator
	 */
	@Override
	public boolean per100g() {
		// nutritional values are provided for the whole menu.
		return false;
	}
}
