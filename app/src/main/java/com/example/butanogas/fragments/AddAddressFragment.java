package com.example.butanogas.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.butanogas.R;
import com.example.butanogas.dao.AddressDAO;
import com.example.butanogas.dao.AppDataBase;
import com.example.butanogas.entity.AddressEntity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class AddAddressFragment extends Fragment {
    private TextInputEditText street;
    private TextInputEditText houseNumber;
    private TextInputEditText district;
    private TextInputEditText zipCode;
    private Button btnAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_address, container, false);
        street = root.findViewById(R.id.street);
        houseNumber = root.findViewById(R.id.houseNumber);
        district = root.findViewById(R.id.district);
        zipCode = root.findViewById(R.id.zipCode);
        btnAdd = root.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTask<Void,Integer, Integer>() {
                    @Override
                    protected Integer doInBackground(Void... voids) {
                        AddressDAO addressDAO = AppDataBase.getInstance(getContext().getApplicationContext()).createAddressDAO();
                        AddressEntity addressEntity = new AddressEntity();
                        addressEntity.setStreet(street.getText().toString());
                        addressEntity.setHouseNumber(houseNumber.getText().toString());
                        addressEntity.setDistrict(district.getText().toString());
                        addressEntity.setZipCode(zipCode.getText().toString());
                        addressDAO.insert(addressEntity);

                        return addressEntity.getId();
                    }
                }.execute();

                Snackbar snackbar = Snackbar.make(view, "Endereço adicionado com sucesso!", Snackbar.LENGTH_LONG);
                snackbar.show();
                Navigation.findNavController(view).navigate(R.id.action_nav_add_to_nav_list);
            }
        });
        return root;
    }

}
