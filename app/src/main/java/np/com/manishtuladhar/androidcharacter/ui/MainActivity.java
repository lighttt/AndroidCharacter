package np.com.manishtuladhar.androidcharacter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import np.com.manishtuladhar.androidcharacter.R;
import np.com.manishtuladhar.androidcharacter.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ============= TABLET  =======================
        //determine if it is tablet
        if(findViewById(R.id.android_tab_character_ll) !=null)
        {
            mTwoPane = true;

            //gridview
            GridView gridView = findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);

            //remove button
            Button nextButton = findViewById(R.id.next_button);
            nextButton.setVisibility(View.GONE);

            if(savedInstanceState == null)
            {
                FragmentManager fragmentManager = getSupportFragmentManager();

                //head
                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setImageIds(AndroidImageAssets.getHeads());
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
        else{
            mTwoPane = false;
        }
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position Clicked: " + position, Toast.LENGTH_SHORT).show();

        //get the body part number
        // 0 : head
        // 1 : body
        // 2 : legs
        int bodyPartNumber = position/12;

        //list index
        int listIndex = position - 12 * bodyPartNumber;

        //selected image is placed on the bodypartfragment accordingly
        if(mTwoPane)
        {
            BodyPartFragment newFragment = new BodyPartFragment();

            switch (bodyPartNumber)
            {
                case 0:
                    newFragment.setImageIds(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.head_container,newFragment)
                            .commit();
                    break;
                case 1:
                    newFragment.setImageIds(AndroidImageAssets.getBodies());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.body_container,newFragment)
                            .commit();
                    break;
                case 2:
                    newFragment.setImageIds(AndroidImageAssets.getLegs());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.leg_container,newFragment)
                            .commit();
                    break;
                default: break;
            }
        }
        else{

            switch (bodyPartNumber)
            {
                case 0:
                    headIndex = listIndex;
                    break;
                case 1:
                    bodyIndex = listIndex;
                    break;
                case 2:
                    legIndex = listIndex;
                    break;
                default: break;
            }
        }


        //pass bundle to android character activity
        Bundle b = new Bundle();

        b.putInt("headIndex",headIndex);
        b.putInt("bodyIndex",bodyIndex);
        b.putInt("legIndex",legIndex);


        //attach to intent
        final Intent intent = new Intent(this,AndroidCharacterActivity.class);
        intent.putExtras(b);

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }
}