package np.com.manishtuladhar.androidcharacter.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import np.com.manishtuladhar.androidcharacter.R;
import np.com.manishtuladhar.androidcharacter.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {

    //triggers a callback to the main activity
    OnImageClickListener imageClickListener;

    //interface for image selected
    public interface OnImageClickListener{
        void onImageSelected(int position);
    }

    /**
     * The lifecycle where activity and fragment connects
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //check if attach
        try{
           imageClickListener = (OnImageClickListener) context;
        }
        catch (ClassCastException e){
            throw  new ClassCastException(context.toString() + "is not implemented");
        }
    }

    //necessary empty constructor
    public MasterListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = rootView.findViewById(R.id.images_grid_view);
        MasterListAdapter masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(masterListAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //get the position
                imageClickListener.onImageSelected(position);
            }
        });
        return rootView;
    }
}