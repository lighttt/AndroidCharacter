package np.com.manishtuladhar.androidcharacter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import np.com.manishtuladhar.androidcharacter.R;
import np.com.manishtuladhar.androidcharacter.data.AndroidImageAssets;

public class AndroidCharacterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_character);

        if(savedInstanceState == null)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();

            //head
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            headFragment.setListIndex(1);
            fragmentManager.beginTransaction()
                    .add(R.id.head_container,headFragment)
                    .commit();

            //body
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            fragmentManager.beginTransaction()
                    .add(R.id.body_container,bodyFragment)
                    .commit();

            //leg
            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container,legFragment)
                    .commit();
        }

    }
}