package com.example.photobomb1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.photobomb1.BottomFragment.Fragment_bottom_join;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    Dialog dialog;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
//    Toolbar toolbar;

    androidx.appcompat.widget.Toolbar toolbar;
    RecyclerView mainRecycle;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      // getSupportActionBar().hide();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        bottomNavigationView=findViewById(R.id.bottomNavigation);
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar= findViewById(R.id.toolbar);
//        mainRecycle=findViewById(R.id.mainRecycle);
        navigationView=findViewById(R.id.navigationView);

        toggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.Create) {
                    FragmentManager Fm = getSupportFragmentManager();
                    FragmentTransaction ft = Fm.beginTransaction();
                    ft.add(R.id.drawerLayout, new CreateGroupFragment());
                    ft.commit();
                    return false;
                } else if (item.getItemId()==R.id.Join) {
                    FragmentManager Fm = getSupportFragmentManager();
                    FragmentTransaction ft = Fm.beginTransaction();
                    ft.add(R.id.FragmentHolder,new Fragment_bottom_join());
                    ft.commit();
                }

                return true;
            }
        });





        dialog = new Dialog(this);
        dialog.dismiss();

//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                int id = item.getItemId();
//                if (id==R.id.logOut){
////                    logOutYes();
////                    dialog.show();
//                    Toast.makeText(MainActivity.this, "Log Out is Clicked", Toast.LENGTH_SHORT).show();
//
//
//                }else if (id==R.id.home){
//                    Toast.makeText(MainActivity.this, "Home is Clicked", Toast.LENGTH_SHORT).show();
//
//                }else if (id==R.id.myProfile){
//                    Toast.makeText(MainActivity.this, "My Profile is Clicked", Toast.LENGTH_SHORT).show();
//                }else if (id==R.id.manageStorage){
//                    Toast.makeText(MainActivity.this, "Manage Storage is Clicked", Toast.LENGTH_SHORT).show();
//                }
//
//
//                return true;
//            }
//        });

    }
//    private void logOutYes(){
//        dialog.setContentView(R.layout.custom_alert_layout);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
//        TextView confirmation =dialog.findViewById(R.id.confirmation);
//        TextView des =dialog.findViewById(R.id.des);
//        TextView no =dialog.findViewById(R.id.no);
//        TextView yes =dialog.findViewById(R.id.yes);
//        dialog.show();
//        yes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (yes==yes){
//                    startActivity(new Intent((Intent) null));
//                }
//                dialog.dismiss();
//            }
//        });
//
//
//
//    }

}