package com.example.baniya.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baniya.R;
import com.example.baniya.retrofitsetup.Api;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.baniya.retrofitsetup.App.getRetrofit;

public class SearchController extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Api api;
    Call<List<SearchPOJO>> call;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_controller);

        recyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        MenuItem menuItem = menu.getItem(0);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type something to search");
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                api = getRetrofit().create(Api.class);
                call = api.getList(query);

                call.enqueue(new Callback<List<SearchPOJO>>() {
                    @Override
                    public void onResponse(Call<List<SearchPOJO>> call, Response<List<SearchPOJO>> response) {

                        if (!response.isSuccessful()){
                            System.out.println("Response not successful. CODE : " + response.code());
                            return;
                        }

                        List<SearchPOJO> searchPOJOS = response.body();
                        recyclerView.setAdapter(new SearchAdapter(SearchController.this, searchPOJOS));
                        int resSize = searchPOJOS.size();
                        String snackDisplay = resSize + " produts found";
                        Snackbar snackbar = Snackbar.make(view, snackDisplay, Snackbar.LENGTH_SHORT);
                        snackbar.show();

                    }

                    @Override
                    public void onFailure(Call<List<SearchPOJO>> call, Throwable t) {

                        System.out.println("On Failure() called : " + t.getMessage());
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
}
