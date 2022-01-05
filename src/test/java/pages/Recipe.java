package pages;

import java.util.*;

public class Recipe {
    private String name;
    private String instructions;
    private ArrayList<String> ingredients = new ArrayList<>();

    public Recipe (String newName, String newInstructions, String newIngredient) {
        setName(newName);
        setInstructions(newInstructions);
        setIngredients(newIngredient);
    }

    public String getName() {
        return name;
    }
    public String getInstructions() {
        return instructions;
    }
    public ArrayList<String> getIngredients() {
        return ingredients;
    }
    public void setName(String newName) {
        name = newName;
    }
    public void setInstructions(String newInstructions) {
        instructions = newInstructions;
    }
    public void setIngredients(String newIngredient) {
        ingredients.add(newIngredient);
    }
    public void create() {
        System.out.println("A new recipe " + name + " was created!");
    }
    public void edit() {
        System.out.println("The recipe " + name + " is ready to be edited!");
    }
    public void save() {
        System.out.println("The recipe " + name + " was just saved!");
    }
    public void delete() {
        System.out.println("The recipe " + name + " is marked for deletion!");
    }

}
