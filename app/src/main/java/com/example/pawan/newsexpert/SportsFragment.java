package com.example.pawan.newsexpert;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SportsFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    MyAdapter_Sports myAdapterSports;

    public  class MyAdapter_Sports extends FragmentPagerAdapter
    {
        String [] sportsArray = {"Cricket","Football","Badminton","More About Sports"};

        public MyAdapter_Sports(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0:
                    CricketFragment cricketFragment = new CricketFragment();
                    return cricketFragment;

                case 1:
                    FootballFragment footballFragment = new FootballFragment();
                    return footballFragment;

                case 2:
                    BadmintonFragment badmintonFragment =new BadmintonFragment();
                    return badmintonFragment;
                case 3:
                    MoreAboutSportsFragment moreAboutSportsFragment = new MoreAboutSportsFragment();
                    return moreAboutSportsFragment;

                default:
                return null;
            }
        }

        @Override
        public int getCount() {
            return sportsArray.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return sportsArray[position];
        }
    }


    public SportsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_sports, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.SportsViewpager);
        tabLayout = (TabLayout) v.findViewById(R.id.SportsTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        myAdapterSports = new MyAdapter_Sports(getChildFragmentManager());
        viewPager.setAdapter(myAdapterSports);

        return v;
    }

}
