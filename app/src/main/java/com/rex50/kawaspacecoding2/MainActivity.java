package com.rex50.kawaspacecoding2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rex50.kawaspacecoding2.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGenerateTicket.setOnClickListener(v -> {
            int[][] items = new TicketGenerator(4, 9).generateTicket();
            StringBuilder op = new StringBuilder();
            for (int i = 0; i < items.length; i++) {
                op.append(Arrays.toString(items[i])).append("\n");
            }
            binding.tvOuptut.setText(op.toString());
        });
    }
}