package com.ravish.universities.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ravish.universities.database.UniversityEntity;
import com.ravish.universities.model.University;
import com.ravish.universities.repository.UniversityRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class UniversityViewModel extends ViewModel {

    private UniversityRepository repository;
    private MutableLiveData<List<University>> allUniversities = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private List<UniversityEntity> entities = new ArrayList<>();
    private List<University> universities = new ArrayList<>();

    @Inject
    public UniversityViewModel(UniversityRepository repository){
        this.repository = repository;
    }

    public void insert(List<UniversityEntity> universities){
        repository.insert(universities);
    }

    public void deleteAllUniversities(){
        repository.deleteAllUniversities();
    }

    public LiveData<List<UniversityEntity>> getAllUniversities(){
        return repository.getAllUniversities();
    }

    public void insertUniversities(List<University> universities){
        for (int i = 0; i<universities.size(); i++){
            UniversityEntity entity = new UniversityEntity(universities.get(i).getDomains().get(0),
                    universities.get(i).getWeb_pages().get(0), universities.get(i).getName(), universities.get(i).getAlpha_two_code(),
                    universities.get(i).getState_province(), universities.get(i).getCountry());
            entities.add(entity);
        }
        insert(entities);
    }

    public void getAllUniversities(String country){
        repository.getAllUniversities(country).enqueue(new Callback<List<University>>() {
            @Override
            public void onResponse(Call<List<University>> call, Response<List<University>> response) {
                try {
                    if (response.body() != null){
                        allUniversities.postValue(response.body());
                    }
                }catch (Exception e){
                    errorMessage.postValue(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<University>> call, Throwable t) {
                errorMessage.postValue(t.getMessage());
            }
        });
    }

    public void getAllDataFromTheDatabase(List<UniversityEntity> entities){
        List<String> domains = new ArrayList<>();
        List<String> web_pages = new ArrayList<>();

        for (int i = 0; i<entities.size(); i++){
            domains.add(entities.get(i).getDomain());
            web_pages.add(entities.get(i).getWeb_pages());
            University university = new University(domains, web_pages, entities.get(i).getName(), entities.get(i).getAlpha_two_code()
            ,entities.get(i).getState_province(), entities.get(i).getCountry());
            universities.add(university);
        }

        allUniversities.postValue(universities);
    }

    public LiveData<List<University>> getUniversityList(){
        return allUniversities;
    }

    public LiveData<String> getErrorMessage(){
        return errorMessage;
    }
}
