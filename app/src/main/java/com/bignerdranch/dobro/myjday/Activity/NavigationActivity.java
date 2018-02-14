package com.bignerdranch.dobro.myjday.Activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.dobro.myjday.Enum.CurrentFragmentType;
import com.bignerdranch.dobro.myjday.Fragments.ChatListFragment;
import com.bignerdranch.dobro.myjday.Fragments.MainFragment;
import com.bignerdranch.dobro.myjday.Fragments.ProfileFragment;
import com.bignerdranch.dobro.myjday.R;

/**
 * Created by Dobro on 14.02.2018.
 */

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {


    private Fragment currentFragment;
    private CurrentFragmentType currentFragmentType;
    private ImageView profileImg, lampImg, messageImg, profileImgActive, lampImgAvtive, messageImgActive;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity);

        profileImg = (ImageView) findViewById(R.id.profile);
        profileImg.setOnClickListener(this);

        lampImg = (ImageView) findViewById(R.id.search);
        lampImg.setOnClickListener(this);

        messageImg = (ImageView) findViewById(R.id.chat);
        messageImg.setOnClickListener(this);

        profileImgActive =(ImageView) findViewById(R.id.profile_active);
        lampImgAvtive = (ImageView) findViewById(R.id.search_active);
        lampImgAvtive.setVisibility(View.VISIBLE);
        messageImgActive = (ImageView) findViewById(R.id.chatactive);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
       /* mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);*/

        changeFragment(new MainFragment(), CurrentFragmentType.search);
    }


    public void changeFragment(Fragment fragment, CurrentFragmentType type ){
        if(type.equals(currentFragment))
            return;
        currentFragment = fragment;
        currentFragmentType = type;
        if (currentFragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment, currentFragment);
            fragmentTransaction.commitNow();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.profile:
                changeFragment(new ProfileFragment(), CurrentFragmentType.profile);
                profileImgActive.setVisibility(View.VISIBLE);
                lampImgAvtive.setVisibility(View.INVISIBLE);
                messageImgActive.setVisibility(View.INVISIBLE);
            break;

            case R.id.search:
                changeFragment(new MainFragment(), CurrentFragmentType.search);
                lampImgAvtive.setVisibility(View.VISIBLE);
                profileImgActive.setVisibility(View.INVISIBLE);
                messageImgActive.setVisibility(View.INVISIBLE);
            break;

            case R.id.chat:
                changeFragment(new ChatListFragment(), CurrentFragmentType.chat);
                messageImgActive.setVisibility(View.VISIBLE);
                profileImgActive.setVisibility(View.INVISIBLE);
                lampImgAvtive.setVisibility(View.INVISIBLE);
            break;
        }
    }


  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {

        }

        public static Fragment newInstance(int sectionNumber) {
            Fragment fragment = null;
            switch (sectionNumber){
                case 1:
                    fragment = new ProfileFragment();
                    break;
                case 2:
                    fragment = new MainFragment();
                    break;
                case 3:
                    fragment = new ChatListFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.navigation_activity, container, false);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
