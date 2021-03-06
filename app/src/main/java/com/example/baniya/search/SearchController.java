package com.example.baniya.search;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.baniya.R;
import com.example.baniya.retrofitsetup.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.baniya.retrofitsetup.App.getRetrofit;

public class SearchController extends AppCompatActivity {

    private TextView tvSearchResults;
    private Api api;
    Call<List<SearchPOJO>> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_controller);

        tvSearchResults = (TextView) findViewById(R.id.tv_search);
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
                            tvSearchResults.setText(response.code());
                            return;
                        }

                        List<SearchPOJO> searchPOJOS = response.body();
                        tvSearchResults.setText("");

                        for (SearchPOJO singlePojo : searchPOJOS){
                            String content = "";
                            content += singlePojo.getCategoryId() + "\n";
                            content += singlePojo.getImageUrl() + "\n";
                            content += singlePojo.getProductDescription() + "\n";
                            content += singlePojo.getProductId() + "\n";
                            content += singlePojo.getProductName() + "\n";
                            content += singlePojo.getProductUsp() + "\n";
                            content += singlePojo.getPrice() + "\n";
                            content += singlePojo.getProductAttribute() + "\n";
                            content += singlePojo.getProductRating() + "\n\n\n\n";

                            tvSearchResults.append(content);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SearchPOJO>> call, Throwable t) {

                        System.out.println("On Failure() called");
                        tvSearchResults.setText(t.getMessage());

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
