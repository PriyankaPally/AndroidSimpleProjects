package com.example.ppriyanka.myapplication.SQLiteDataBase;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ppriyanka.myapplication.R;
import com.example.ppriyanka.myapplication.databinding.ActivityStudentBinding;

public class StudentActivity extends AppCompatActivity {

    ActivityStudentBinding binding;

    DatabaseHelper databaseHelper;

    EditText editName,editSurname,editMarks,editId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_student);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_student);

        databaseHelper = new DatabaseHelper(this);

        editId=(EditText)findViewById(R.id.id_editText);
        editName = (EditText)findViewById(R.id.name_editText);
        editSurname=(EditText)findViewById(R.id.surname_editText);
        editMarks = (EditText)findViewById(R.id.editText_marks);
        addData();
        viewAllData();
        updateData();
        deleteData();
    }
    public void updateFields(){
        editId.setText("");
        editName.setText("");
        editSurname.setText("");
        editMarks.setText("");
    }

    public void deleteData() {

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletRows = databaseHelper.deleteData(editId.getText().toString());
                if (deletRows>0){
                    updateFields();
                    Toast.makeText(StudentActivity.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(StudentActivity.this, "Data not updated", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    public void updateData() {

        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isUpdate=databaseHelper.updateData(editId.getText().toString(),editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
                if (isUpdate == true){
                    updateFields();
                    Toast.makeText(StudentActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(StudentActivity.this, "Data not updated", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void viewAllData() {

        binding.btnViewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=databaseHelper.getALLData();
                if (res.getCount() ==0){
                    showMessage("error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id:"+res.getString(0)+"\n");
                    buffer.append("Name:"+res.getString(1)+"\n");
                    buffer.append("Surname:"+res.getString(2)+"\n");
                    buffer.append("marks:"+res.getString(3)+"\n");
                }
                showMessage("Data",buffer.toString());
            }
        });
    }

    private void showMessage(String tittle, String message) {
        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tittle);
        builder.setMessage(message);
        builder.show();
    }

    public void addData() {

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = databaseHelper.insertData(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());

                if (isInserted==true){
                    Toast.makeText(StudentActivity.this, "Data Inserted successfully", Toast.LENGTH_SHORT).show();
                    updateFields();
                }else {
                    Toast.makeText(StudentActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
