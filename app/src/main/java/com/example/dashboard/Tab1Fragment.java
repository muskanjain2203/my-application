package com.example.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class Tab1Fragment extends Fragment {
    private BottomSheetDialog bottomSheetDialog;
    private TextView quantity,medicine_name , company_name , actual_price, reduced_price , tablets_pack, discount_price;
    private  int position;
    private  int count=1;
    ArrayList<rectangle_card> itemList = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    public Tab1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {

        bottomSheetDialog = new BottomSheetDialog(getActivity());

        View rootView = inflater.inflate(R.layout.fragment_tab1_fragment, container, false);

        for (int i = 0 ; i<=20 ; i++){
            itemList.add(new rectangle_card("Medicine name","company name",20,image,10,10,"lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_at_pellentesque_aliquet_maecenas_massa_egestas_sapien_turpis_purus_mauris_vestibulum_augue_mattis_ut_laoreet_porta_vel_etiam_velit_leo_in_quam_et_in_leo_lectus_adipiscing_arcu_ut_ac_lectus_in_orci_pulvinar_dignissim_nulla_ut_arcu_vestibulum\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. At pellentesque aliquet maecenas massa egestas sapien turpis purus. Mauris vestibulum, augue mattis ut. Laoreet porta vel etiam velit leo in quam et in. Leo, lectus adipiscing arcu, ut. Ac lectus in orci pulvinar dignissim nulla ut arcu vestibulum",140,120));
        }
        RecyclerView categoryTemplate = (RecyclerView) rootView.findViewById(R.id.shopByCategoryFragment);
        GridLayoutManager layoutManagerFragment = new GridLayoutManager(getActivity(),2);
        categoryTemplate.setHasFixedSize(true);
        categoryTemplate.setLayoutManager(layoutManagerFragment);
        RecyclerViewAdapterFragment categoryFragment = new RecyclerViewAdapterFragment(getActivity(), itemList);
        categoryFragment.onLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                 position = categoryTemplate.getChildAdapterPosition(v);
                 Toast.makeText(getActivity(),"hello"+position,Toast.LENGTH_SHORT).show();
                 msgDialog();
                return true;
            }
        });
        categoryTemplate.setAdapter(categoryFragment);


        return rootView;
    }
    public  void msgDialog(){

         View view = getLayoutInflater().from(getActivity()).inflate(R.layout.activity_medicine_name,null);
         medicine_name=view.findViewById(R.id.medicineNameTextView);
         company_name = view.findViewById(R.id.byCompanyNameTextView);
         reduced_price=view.findViewById(R.id.reducedPriceTextView);
         tablets_pack = view.findViewById(R.id.tabletsPackTextView);
         actual_price = view.findViewById(R.id.originalPriceTextView);
         discount_price = view.findViewById(R.id.discountLabelTextView);
         quantity=view.findViewById(R.id.quantityTextView);
         rectangle_card current = itemList.get(position);
         if(position != -1){
          medicine_name.setText(current.getMedicine_name());
          company_name.setText(current.getCompany_name());
          reduced_price.setText(String.valueOf("Rs"+current.getReduced_price()+" /"));
          tablets_pack.setText(String.valueOf(current.getTabletPacks()+" tablets pack"));
          actual_price.setText(String.valueOf("Rs"+current.getActual_price()));
          discount_price.setText(String.valueOf("Rs"+current.getDiscount_price()));
         }

         view.findViewById(R.id.arrowImageView).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                  bottomSheetDialog.dismiss();
             }
         });
         view.findViewById(R.id.minusButtonImageView).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                count = count-1;
                quantity.setText(String.valueOf(count));
             }
         });
         view.findViewById(R.id.plusButtonImageView).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                count = count+1;
                quantity.setText(String.valueOf(count));
             }
         });
           bottomSheetDialog.setContentView(view);
           bottomSheetDialog.show();
    }
}

