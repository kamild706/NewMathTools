package pl.t32.newmathtools;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import pl.t32.newmathtools.ap.ArithmeticProgressionFragment;
import pl.t32.newmathtools.calendar.CalendarFragment;
import pl.t32.newmathtools.nbc.NumberBaseConverterFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new CalendarFragment());
        transaction.commit();

        navigationView.getMenu().getItem(0).setChecked(true);
        setTitle(navigationView.getMenu().getItem(0).getTitle());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;

        switch (id) {
            case R.id.nav_calendar:
                fragment = new CalendarFragment();
                break;
            case R.id.nav_arithmetic_progression:
                fragment = new ArithmeticProgressionFragment();
                break;
            case R.id.nav_number_base_converter:
                fragment = new NumberBaseConverterFragment();
                break;
            case R.id.nav_combination:

                break;
            case R.id.nav_permutation:

                break;
            case R.id.nav_rising_factorial:

                break;
            case R.id.nav_divisors:

                break;
            case R.id.nav_factorization:

                break;
            case R.id.nav_gcd:

                break;
            case R.id.nav_lcm:

                break;
            case R.id.nav_linear_congruence:

                break;
            case R.id.nav_extended_euclidean_algorithm:

                break;
            case R.id.nav_about:

                break;
            case R.id.nav_settings:

                break;
        }

        if (fragment != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

            setTitle(item.getTitle());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
