package es.saladillo.nicolas.dailydiet.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import es.saladillo.nicolas.dailydiet.R;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.navHostFragment);
        setupViews();
    }

    private void setupViews() {
        BottomNavigationView bottomNavigationView;

        bottomNavigationView = ActivityCompat.requireViewById(this, R.id.bottomNavigationView);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
