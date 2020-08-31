package diet;

import java.util.ArrayList;
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
    
    private double totCalories=0;
    private double totProteins=0;
    private double totCarbs=0;
    private double totFat=0;
    private double totQuantity = 0;
    
    private List<Ingredient> ingredients  = new ArrayList<>();
    
    private class Ingredient{
    	private NutritionalElement elem;
    	private double qty;
    	Ingredient(NutritionalElement element, double quantity){
    		this.elem=element;
    		this.qty=quantity;
    	}
		public String getName() {
			return elem.getName();
		}
		public Object getQuantity() {
			return qty;
		}
    }
    
	public Recipe(String name, Food food) {
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
		Ingredient ingredient = new Ingredient(food.getRawMaterial(material), quantity);
		final double x = quantity/100;
		
		ingredients.add(ingredient);
		
		totCalories += food.getRawMaterial(material).getCalories() * x;
	    totProteins += food.getRawMaterial(material).getProteins() * x;
	    totCarbs += food.getRawMaterial(material).getCarbs() * x;
	    totFat += food.getRawMaterial(material).getFat() * x;
	    totQuantity += quantity;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		return totCalories / totQuantity * 100;
	}

	@Override
	public double getProteins() {
		return totProteins / totQuantity * 100;
	}

	@Override
	public double getCarbs() {
		return totCarbs / totQuantity * 100;
	}

	@Override
	public double getFat() {
		return totFat / totQuantity * 100;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expresses nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return true;
	}
	
	
	/**
	 * Returns the ingredients composing the recipe.
	 * 
	 * A string that contains all the ingredients, one per per line, 
	 * using the following format:
	 * {@code "Material : ###.#"} where <i>Material</i> is the name of the 
	 * raw material and <i>###.#</i> is the relative quantity. 
	 * 
	 * Lines are all terminated with character {@code '\n'} and the ingredients 
	 * must appear in the same order they have been added to the recipe.
	 */
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		for(int i=0; i<ingredients.size(); i++) {
			res.append("Materiale : ").append(ingredients.get(i).getName() + ".").append(ingredients.get(i).getQuantity()).append("\n");
		}
		return res.toString();
	}
}
