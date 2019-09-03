package es.saladillo.nicolas.dailydiet.ui.fragments.pantry;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.saladillo.nicolas.dailydiet.R;
import es.saladillo.nicolas.dailydiet.data.RepositoryImpl;
import es.saladillo.nicolas.dailydiet.data.local.AppDatabase;
import es.saladillo.nicolas.dailydiet.data.local.DietDAO;
import es.saladillo.nicolas.dailydiet.data.local.Diet_DishDAO;
import es.saladillo.nicolas.dailydiet.data.local.DishDAO;
import es.saladillo.nicolas.dailydiet.data.local.Dish_IngredientDAO;
import es.saladillo.nicolas.dailydiet.data.local.IngredientDAO;

public class Pantry extends Fragment {

    private PantryViewModel vm;
    private RepositoryImpl repository;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pantry_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        repositoryCreation();
        vm = ViewModelProviders.of(getActivity(),new PantryViewModelFactory(repository)).get(PantryViewModel.class);
    }

    private void repositoryCreation() {
        DietDAO dietDAO = AppDatabase.getInstance(getContext()).dietDAO();
        DishDAO dishDAO = AppDatabase.getInstance(getContext()).dishDAO();
        Diet_DishDAO diet_dishDAO = AppDatabase.getInstance(getContext()).diet_dishDAO();
        IngredientDAO ingredientDAO = AppDatabase.getInstance(getContext()).ingredientDAO();
        Dish_IngredientDAO dish_ingredientDAO = AppDatabase.getInstance(getContext()).dish_ingredientDAO();

        repository = new RepositoryImpl(dietDAO,diet_dishDAO,dishDAO,dish_ingredientDAO,ingredientDAO);
    }

}
