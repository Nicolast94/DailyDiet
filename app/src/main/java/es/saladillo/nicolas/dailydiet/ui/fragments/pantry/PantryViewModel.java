package es.saladillo.nicolas.dailydiet.ui.fragments.pantry;

import androidx.lifecycle.ViewModel;

import es.saladillo.nicolas.dailydiet.data.Repository;
import es.saladillo.nicolas.dailydiet.data.local.entities.Ingredient;

public class PantryViewModel extends ViewModel {
    private Repository repository;

    public PantryViewModel(Repository repository) {
        this.repository = repository;
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Pizza");
        ingredient.setImage("https://www.laespanolaaceites.com/wp-content/uploads/2019/06/pizza-con-chorizo-jamon-y-queso-1080x671.jpg");
        addIngredient(ingredient);
    }

    public void addIngredient(Ingredient ingredient){
        repository.insertIngredient(ingredient);
    }
    public void updateIngredient(Ingredient ingredient){
        repository.updateIngredient(ingredient);
    }
    public void deleteIngredient(Ingredient ingredient){
        repository.deleteIngredient(ingredient);
    }
}
