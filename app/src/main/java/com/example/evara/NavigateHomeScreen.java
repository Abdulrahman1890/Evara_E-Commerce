package com.example.evara;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.evara.databinding.ActivityNavigateHomeScreenBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NavigateHomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView userName , userEmail;
    Bundle bundle;
    private Menu searchbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate_home_screen);
        bundle = getIntent().getExtras();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState == null) {
            Fragment fragment ;
            Bundle bundle1 = new Bundle();
            bundle1.putString("token",bundle.getString("token"));
            fragment = new HomeFragement();
            fragment.setArguments(bundle1);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    fragment).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        View headerView = navigationView.getHeaderView(0);
        userName = headerView.findViewById(R.id.header_user_name);
        userEmail = headerView.findViewById(R.id.header_user_email);
        String name = bundle.getString("name");
        String email = bundle.getString("email");
        userName.setText(name);
        userEmail.setText(email);
    }



    public void openSearch(){
            startActivity(new Intent(NavigateHomeScreen.this,SearchBar.class));
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment ;
        Bundle bundle1 = new Bundle();
        bundle1.putString("token",bundle.getString("token"));
        switch (item.getItemId()){
            case R.id.nav_home:
                fragment = new HomeFragement();
                fragment.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        fragment).commit();
                break;
            case R.id.nav_cart:
                fragment = new CartFragement();
                fragment.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        fragment).commit();
                break;
            case R.id.nav_catogary:
                fragment = new CatogaryFragment();
                fragment.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        fragment).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutUsFragement()).commit();
                break;
            case R.id.nav_update:
                fragment = new UpdateAccountFragement();
                fragment.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        fragment).commit();
                break;
            case R.id.nav_delete:
                AlertDialog.Builder m = new AlertDialog.Builder(NavigateHomeScreen.this)
                        .setTitle("Delete?!")
                        .setIcon(R.drawable.evara)
                        .setMessage("Are you sure you want to delete your account? \uD83E\uDD7A")
                        .setPositiveButton("No", null)
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //نربطها بالapi عشان نمسح الداتا

                                startActivity(new Intent(NavigateHomeScreen.this,LogIn.class));
                                finish();
                            }
                        });
                m.create().show();
                break;
            case R.id.nav_logout:
                // لازم نعمل هنا الshared preference
              /*  getSharedPreferences("rememberstu",MODE_PRIVATE)
                        .edit()
                        .clear()
                        .commit();
                */

                String token = bundle1.getString("token");
                Call<LogOutRespond> call = ApiClient.getInstance().getApi().logOut(token);
                call.enqueue(new Callback<LogOutRespond>() {
                    @Override
                    public void onResponse(Call<LogOutRespond> call, Response<LogOutRespond> response) {
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LogOutRespond> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                startActivity(new Intent(NavigateHomeScreen.this,LogIn.class));                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }{
            super.onBackPressed();
        }
    }
}