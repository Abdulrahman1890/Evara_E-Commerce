package com.example.evara;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CatogaryFragment extends Fragment {
    RecyclerView recyclerView;
    HorizontalHomeAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<ItemModel> arrayList;
    private Bundle bundle;
    Spinner catogary , sub;
    String token;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_catogary,container,false);
        bundle = getArguments();
        token = bundle.getString("token");
        recyclerView = view.findViewById(R.id.catogary_recycle_view);
        layoutManager = new GridLayoutManager(getContext() , 3);
        recyclerView.setLayoutManager(layoutManager);



        catogary = view.findViewById(R.id.spinner_catogary);


        Call<GetCategoryResponds> call = ApiClient.getInstance().getApi().GetCategories();
        call.enqueue(new Callback<GetCategoryResponds>() {
            @Override
            public void onResponse(Call<GetCategoryResponds> call, Response<GetCategoryResponds> response) {
                GetCategoryResponds getCategoryResponds = response.body();

                ArrayAdapter<All_Categories> adapter = new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,getCategoryResponds.getAll_categories());
                catogary.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GetCategoryResponds> call, Throwable t) {

            }
        });

        sub = view.findViewById(R.id.spinner_sub_catogary);
        sub.setVisibility(View.GONE);

        catogary.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                All_Categories category = (All_Categories) catogary.getSelectedItem();
                Call<GetSubcategoriesByIdRespond> getSubcategoriesByIdRespondCall = ApiClient.getInstance().getApi().getSubcategoriesByIdRespondCall(category.getId());
                getSubcategoriesByIdRespondCall.enqueue(new Callback<GetSubcategoriesByIdRespond>() {
                    @Override
                    public void onResponse(Call<GetSubcategoriesByIdRespond> call, Response<GetSubcategoriesByIdRespond> response) {
                        sub.setVisibility(View.VISIBLE);
                        GetSubcategoriesByIdRespond getSubcategoriesByIdRespond = response.body();
                        SubCategory[] subCategories = getSubcategoriesByIdRespond.getSubCategory();
                        ArrayAdapter<SubCategory> adapter = new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,subCategories);
                        sub.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<GetSubcategoriesByIdRespond> call, Throwable t) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SubCategory subProduct = (SubCategory) sub.getSelectedItem();
                Call<ProductByCategoryRespond> callSubCateProduct = ApiClient.getInstance().getApi().GetProductBySubCategory(subProduct.getId());
                Toast.makeText(getContext(), subProduct.getId() + "", Toast.LENGTH_SHORT).show();

                callSubCateProduct.enqueue(new Callback<ProductByCategoryRespond>() {
                    @Override
                    public void onResponse(Call<ProductByCategoryRespond> call, Response<ProductByCategoryRespond> response) {
                        ProductByCategoryRespond productByCategoryRespond = response.body();
                        dataSet(productByCategoryRespond.getProducts());

                    }

                    @Override
                    public void onFailure(Call<ProductByCategoryRespond> call, Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
    public void dataSet(SingleProduct[] products){
        arrayList = new ArrayList<ItemModel>();
        for (int i = 0 ;i < products.length; i++){
            ItemModel itemModel = new ItemModel(products[i].getPath(),products[i].getTitle(),Double.parseDouble(products[i].getPrice()),products[i].getId(),token);
            arrayList.add(itemModel);
        }

        adapter = new HorizontalHomeAdapter(getContext(),arrayList);
        recyclerView.setAdapter(adapter);
        adapter.notifyItemRangeChanged(0, products.length);
    }
}