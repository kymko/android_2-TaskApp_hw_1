package kg.geektech.taskapp;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profile)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        navController.navigate(R.id.boardFragment);
        // скрыть нижние табы
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull @NotNull NavController controller, @NonNull @NotNull NavDestination destination, @Nullable @org.jetbrains.annotations.Nullable Bundle arguments) {

                ArrayList<Integer> list = new ArrayList<>();
                list.add(R.id.navigation_home);
                list.add(R.id.navigation_dashboard);
                list.add(R.id.navigation_notifications);
                list.add(R.id.navigation_profile);

                if (list.contains(destination.getId())){
                    navView.setVisibility(View.VISIBLE);
                } else {
                    navView.setVisibility(View.GONE);
                }

                if (destination.getId() == R.id.boardFragment){
                    getSupportActionBar().hide();
                } else {
                    getSupportActionBar().show();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {

        return navController.navigateUp();
    }

}

//        1. Сделать зебру для списка
//        2. При нажатии на элемент, показать в тосте его position ("0: asd")
//        3. При долгом нажатии удалить элемент из списка с помощью AlertDialog