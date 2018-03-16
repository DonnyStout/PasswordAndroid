package edu.cnm.deepdive.passwordandroid;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import layout.ArchiveFragment;
import layout.PlayFragment;
import layout.SetupFragment;

public class MainActivity extends AppCompatActivity {

  private TextView mTextMessage;

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
        case R.id.navigation_home:
          android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager()
              .beginTransaction();
          SetupFragment setup = new SetupFragment();
          transaction.replace(R.id.content, setup).commit();
          return true;
        case R.id.navigation_dashboard:
          transaction = getSupportFragmentManager().beginTransaction();
          PlayFragment play = new PlayFragment();
          transaction.replace(R.id.content, play).commit();
          return true;
        case R.id.navigation_notifications:
          transaction = getSupportFragmentManager().beginTransaction();
          ArchiveFragment archive = new ArchiveFragment();
          transaction.replace(R.id.content, archive).commit();
          return true;
      }
      return false;
    }

  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager()
        .beginTransaction();
    SetupFragment setup = new SetupFragment();
    transaction.replace(R.id.content, setup).commit();
    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
  }

}
