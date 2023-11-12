package ru.samsung.academy.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import ru.samsung.academy.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initPopupMenu();
        setSupportActionBar(binding.toolbar);

    }

    private void initView() {
        binding.button0.setOnClickListener(v -> {
            if (binding.number.getText().equals("")) {
                Snackbar.make(v, "Первая цифра не может быть нулем", Toast.LENGTH_LONG).show();
            }
            else {
                String number = binding.number.getText() + "0";
                binding.number.setText(number);
            }
        });
        binding.button1.setOnClickListener(v -> {
            String number = binding.number.getText() + "1";
            binding.number.setText(number);
        });
        binding.button2.setOnClickListener(v -> {
            String number = binding.number.getText() + "2";
            binding.number.setText(number);
        });
        binding.button3.setOnClickListener(v -> {
            String number = binding.number.getText() + "3";
            binding.number.setText(number);
        });
        binding.button4.setOnClickListener(v -> {
            String number = binding.number.getText() + "4";
            binding.number.setText(number);
        });
        binding.button5.setOnClickListener(v -> {
            String number = binding.number.getText() + "5";
            binding.number.setText(number);
        });
        binding.button6.setOnClickListener(v -> {
            String number = binding.number.getText() + "6";
            binding.number.setText(number);
        });
        binding.button7.setOnClickListener(v -> {
            String number = binding.number.getText() + "7";
            binding.number.setText(number);
        });
        binding.button8.setOnClickListener(v -> {
            String number = binding.number.getText() + "8";
            binding.number.setText(number);
        });
        binding.button9.setOnClickListener(v -> {
            String number = binding.number.getText() + "9";
            binding.number.setText(number);
        });
        binding.buttonBack.setOnClickListener(v -> {
            String number = binding.number.getText().toString();
            if (number.length() > 0) {
                number = number.substring(0, number.length() - 1);
                binding.number.setText(number);
            }
        });
        binding.buttonClear.setOnClickListener(v -> {
            binding.number.setText("");
            binding.numberTwo.setText("");
        });
        binding.buttonAddition.setOnClickListener(v -> {
            String number = binding.number.getText().toString() + " + ";
            if (number.length() > 3) {
                binding.numberTwo.setText(number);
                binding.number.setText("");
            }
        });
        binding.buttonSubtraction.setOnClickListener(v -> {
            String number = binding.number.getText().toString() + " - ";
            if (number.length() > 3) {
                binding.numberTwo.setText(number);
                binding.number.setText("");
            }
        });
        binding.buttonMultiplication.setOnClickListener(v -> {
            String number = binding.number.getText().toString() + " × ";
            if (number.length() > 3) {
                binding.numberTwo.setText(number);
                binding.number.setText("");
            }
        });
        binding.buttonDivision.setOnClickListener(v -> {
            String number = binding.number.getText().toString() + " ÷ ";
            if (number.length() > 3) {
                binding.numberTwo.setText(number);
                binding.number.setText("");
            }
        });
        binding.buttonEqually.setOnClickListener(v -> {
            String numberOne = binding.number.getText().toString();
            String numberTwo = binding.numberTwo.getText().toString();

            if (numberOne.length() > 0 && numberTwo.length() > 0) {
                double numberTw = Double.parseDouble(numberTwo.substring(0, numberTwo.length() - 3));
                double numberOn;
                String result;
                binding.numberTwo.setText("");
                numberOn = Double.parseDouble(numberOne);
                char operation = numberTwo.charAt(numberTwo.length() - 2);
                switch (operation) {
                    case '+': {
                        result = String.valueOf((long) (numberTw + numberOn));
                        binding.number.setText(result);
                        break;
                    }
                    case '-': {
                        result = String.valueOf(((long) (numberTw - numberOn)));
                        binding.number.setText(result);
                        break;
                    }
                    case '×': {
                        result = String.valueOf((long) (numberTw * numberOn));
                        binding.number.setText(result);
                        break;
                    }
                    case '÷': {
                        result = String.valueOf(numberTw / numberOn);
                        binding.number.setText(result);
                        break;
                    }

                }
            }
        });

    }
    private void initPopupMenu() {
        binding.number.setOnLongClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, v, Gravity.END);
            popupMenu.inflate(R.menu.menu_popup);
            popupMenu.setOnMenuItemClickListener(menuItem -> {
                int id = menuItem.getItemId();
                if (id == R.id.blue) {
                    binding.number.setTextColor(getResources().getColor(R.color.blue, getTheme()));
                    binding.numberTwo.setTextColor(getResources().getColor(R.color.blue, getTheme()));
                }
                else if (id == R.id.red) {
                    binding.number.setTextColor(getResources().getColor(R.color.red, getTheme()));
                    binding.numberTwo.setTextColor(getResources().getColor(R.color.red, getTheme()));
                }
                else if (id == R.id.green) {
                    binding.number.setTextColor(getResources().getColor(R.color.green, getTheme()));
                    binding.numberTwo.setTextColor(getResources().getColor(R.color.green, getTheme()));
                }
                else if (id == R.id.orange) {
                    binding.number.setTextColor(getResources().getColor(R.color.orange, getTheme()));
                    binding.numberTwo.setTextColor(getResources().getColor(R.color.orange, getTheme()));
                }
                return true;
            });
            popupMenu.show();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.favourite) {
            Toast.makeText(this, "Избранное добавится в следующем обновлении", Toast.LENGTH_LONG).show();
            return true;
        }
        else if (item.getItemId() == R.id.camera) {
            Toast.makeText(this, "Камера добавится в следующем обновлении", Toast.LENGTH_LONG).show();
            return true;
        }
        else if (item.getItemId() == R.id.settings) {
            Toast.makeText(this, "Настройки добавятся в следующем обновлении", Toast.LENGTH_LONG).show();
            return true;
        }
        else if (item.getItemId() == R.id.gallery) {
            Toast.makeText(this, "Галерея добавится в следующем обновлении", Toast.LENGTH_LONG).show();
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }
}