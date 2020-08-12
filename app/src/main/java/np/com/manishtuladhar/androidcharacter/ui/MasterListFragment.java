package np.com.manishtuladhar.androidcharacter.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import np.com.manishtuladhar.androidcharacter.R;
import np.com.manishtuladhar.androidcharacter.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {


    public MasterListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = rootView.findViewById(R.id.images_grid_view);
        MasterListAdapter masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(masterListAdapter);
        return rootView;
    }
}