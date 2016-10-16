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
public class InternationalFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    MyAdapter_International myAdapterInternational;

    public  class MyAdapter_International extends FragmentPagerAdapter
    {

        String [] internationalArray = {"Asia","Europe"};
        public MyAdapter_International(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position)
            {
                case 0:
                    AsiaFragment asiaFragment = new AsiaFragment();
                    return asiaFragment;

                case 1:
                    EuropeFragment europeFragment = new EuropeFragment();
                    return europeFragment;

                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return internationalArray.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return internationalArray[position];
        }
    }


    public InternationalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_international, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.InternationalViewpager);
        tabLayout = (TabLayout) v.findViewById(R.id.InternationalTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        myAdapterInternational = new MyAdapter_International(getChildFragmentManager());
        viewPager.setAdapter(myAdapterInternational);

        return v;
    }

}
