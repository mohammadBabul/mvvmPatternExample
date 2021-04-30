package com.babul.mvvm.views;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.babul.mvvm.R;
import com.babul.mvvm.adapters.BrandAdapter;
import com.babul.mvvm.adapters.ProductAdapter;
import com.babul.mvvm.adapters.ShopAdapter;
import com.babul.mvvm.model.data.Brand;
import com.babul.mvvm.model.data.Product;
import com.babul.mvvm.model.data.Shop;
import com.babul.mvvm.viewmodels.BrandViewmodel;
import com.babul.mvvm.viewmodels.ProductViewModel;
import com.babul.mvvm.viewmodels.ShopViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Homefragment extends Fragment {

    View view;
    RecyclerView recyclerViewShop, recyclerViewBrand, recyclerViewProduct;
    ArrayList<Shop> arrayList = new ArrayList<>();
    ArrayList<Brand> brandArrayList = new ArrayList<>();
    ArrayList<Product> productArrayList = new ArrayList<>();
    ShopAdapter adapter;
    BrandAdapter brandAdapter;
    ProductAdapter productAdapter;
    Context mContext;

    int page = 1, brandPage = 1, productPage = 1;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager branGridLayoutManager, prodLinearLayoutManager;
    ProgressBar progressBar, productProgressBar;
    LinearLayout loadMoreLinearLayout;
    boolean loadMoreClick = false;
    ShopViewModel shopViewModel;
    ProductViewModel productViewModel;
    BrandViewmodel brandViewmodel;
    NestedScrollView ns;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        view = inflater.inflate(R.layout.home_fragment, container, false);

        shopViewModel = ViewModelProviders.of(this).get(ShopViewModel.class);
        brandViewmodel = ViewModelProviders.of(this).get(BrandViewmodel.class);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);

        shopViewModel.init(page);
        brandViewmodel.init(page);
        productViewModel.init(page);

        shopViewModel.getNewsRepository().observe(getViewLifecycleOwner(), newsResponse -> {
            List<Shop> newsArticles = newsResponse.getShopList();
            arrayList.addAll(newsArticles);
            adapter.notifyDataSetChanged();
        });
        productViewModel.getProductRepository().observe(getViewLifecycleOwner(), newsResponse -> {
            List<Product> newsArticles = newsResponse.getProductList();
            productArrayList.addAll(newsArticles);
            productAdapter.notifyDataSetChanged();
        });
        brandViewmodel.getNewsRepository().observe(getViewLifecycleOwner(), newsResponse -> {
            List<Brand> newsArticles = newsResponse.getBrandList();
            brandArrayList.addAll(newsArticles);
            brandAdapter.notifyDataSetChanged();
        });

        shopViewModel.getProgressStatus().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });
        productViewModel.getProgressProduct().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                productProgressBar.setVisibility(View.VISIBLE);
            } else {
                productProgressBar.setVisibility(View.GONE);
            }
        });

        initializeShopView();
        initializeBrandView();
        initializeProductView();

        return view;
    }


    private void initializeShopView() {
        recyclerViewShop = view.findViewById(R.id.recycler_view_shop);
        progressBar = view.findViewById(R.id.progressbar);

        adapter = new ShopAdapter(mContext, arrayList);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerViewShop.setLayoutManager(linearLayoutManager);
        recyclerViewShop.setAdapter(adapter);
        recyclerViewShop.setItemAnimator(new DefaultItemAnimator());
        recyclerViewShop.setNestedScrollingEnabled(false);
        recyclerViewShop.setHasFixedSize(true);

        recyclerViewShop.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                    page++;
                    shopViewModel.init(page);
                    shopViewModel.getNewsRepository().observe(getViewLifecycleOwner(), newsResponse -> {
                        List<Shop> newsArticles = newsResponse.getShopList();
                        arrayList.addAll(newsArticles);
                        adapter.notifyDataSetChanged();
                    });
                }
            }
        });
    }

    private void initializeBrandView() {
        recyclerViewBrand = view.findViewById(R.id.recycler_view_brand);
        branGridLayoutManager = new GridLayoutManager(getContext(), 4);

        loadMoreLinearLayout = view.findViewById(R.id.layout_load_more);
        recyclerViewBrand.setLayoutManager(branGridLayoutManager);
        recyclerViewBrand.setItemAnimator(new DefaultItemAnimator());

        brandArrayList = new ArrayList<>();
        brandAdapter = new BrandAdapter(mContext, brandArrayList);
        recyclerViewBrand.setAdapter(brandAdapter);
        recyclerViewBrand.setHasFixedSize(true);
        recyclerViewBrand.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = branGridLayoutManager.getChildCount();
                int totalItemCount = branGridLayoutManager.getItemCount();
                int firstVisibleItemPosition = branGridLayoutManager.findFirstVisibleItemPosition();

                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                    recyclerViewBrand.smoothScrollToPosition(brandAdapter.getItemCount() - 2);
                }
            }
        });

        loadMoreLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                brandPage++;
                brandViewmodel.init(brandPage);
                brandViewmodel.getNewsRepository().observe(getViewLifecycleOwner(), newsResponse -> {
                    List<Brand> newsArticles = newsResponse.getBrandList();
                    brandArrayList.addAll(newsArticles);
                    brandAdapter.notifyDataSetChanged();
                });
                loadMoreClick = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerViewBrand.scrollToPosition(brandArrayList.size() - 2);
                    }
                }, 400);

            }
        });
    }

    private void initializeProductView() {

        productProgressBar = view.findViewById(R.id.product_progress);
        recyclerViewProduct = view.findViewById(R.id.recycler_view_product);
        prodLinearLayoutManager = new GridLayoutManager(getContext(), 2);

        recyclerViewProduct.setLayoutManager(prodLinearLayoutManager);
        recyclerViewProduct.setItemAnimator(new DefaultItemAnimator());

        productArrayList = new ArrayList<>();
        productAdapter = new ProductAdapter(mContext, productArrayList);

        recyclerViewProduct.setAdapter(productAdapter);
        recyclerViewProduct.setNestedScrollingEnabled(false);
        recyclerViewProduct.setHasFixedSize(true);

        ns = view.findViewById(R.id.ns);
        ns.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY==v.getChildAt(0).getMeasuredHeight()-v.getMeasuredHeight()){
                    productPage++;
                    productViewModel.init(productPage);
                    productViewModel.getProductRepository().observe(getViewLifecycleOwner(), newsResponse -> {
                        List<Product> newsArticles = newsResponse.getProductList();
                        productArrayList.addAll(newsArticles);
                        productAdapter.notifyDataSetChanged();
                    });
                }
            }
        });
    }
}