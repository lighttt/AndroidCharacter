package np.com.manishtuladhar.androidcharacter.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import np.com.manishtuladhar.androidcharacter.R;
import np.com.manishtuladhar.androidcharacter.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {

    private static final String TAG = "BodyPartFragment";

    private List<Integer> mImageIds;
    private int mListIndex;

    public BodyPartFragment()
    {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View
        View rootView = inflater.inflate(R.layout.fragment_body_part,container, false);
        ImageView imageView = rootView.findViewById(R.id.body_part_iv);
        if(mImageIds !=null)
        {
            imageView.setImageResource(mImageIds.get(mListIndex));
        }
        else{
            Log.e(TAG, "onCreateView: cannot find the id or image " );
        }
        return rootView;
    }

    public void setImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }
}
