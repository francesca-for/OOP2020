package diet;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
	private String name;
	private Food food;

	private List<Ingredient> ingredients = new LinkedList<Ingredient>();
	private static class Ingredient {
		final NutritionalElement en;
		final double qty;
		Ingredient(NutritionalElement e, double q){
			this.en=e; this.qty=q;
		}
	}

	// It is possible to use just the sum of all values
	//
	private double calories = 0.0;
	private double proteins = 0.0;
	private double carbs = 0.0;
	private double fat = 0.0;
	private double weight = 0.0;


	Recipe(String name, Food food) {
		this.name = name;
		this.food = food;
	}

	/**
	 * Adds a given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 * @return the same Recipe object, it allows method chaining.
	 */
	public Recipe addIngredient(String material, double quantity) {
		NutritionalElement en = food.getRawMaterial(material);

		Ingredient ing = new Ingredient(en,quantity);
		ingredients.add(ing);

		// With the compact version
		calories += en.getCalories(quantity);
		proteins += en.getProteins(quantity);
		carbs += en.getCarbs(quantity);
		fat += en.getFat(quantity);

		weight += quantity;

		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		double cals=0.0;
		for(Ingredient i : ingredients) {
			cals += i.en.getCalories(i.qty);
		}
		return cals * 100 / weight;
		// OR
		//return calories * 100 / weight;
	}

	@Override
	public double getProteins() {
		return proteins * 100 / weight;
	}

	@Override
	public double getCarbs() {
		return carbs * 100 / weight;
	}

	@Override
	public double getFat() {
		return fat * 100 / weight;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expressed nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return true;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Ingredient i : ingredients) {
			sb.append(i.en.getName()).append(" : ")
			.append(i.qty).append('\n');
		}
		return sb.toString();
	}

}
