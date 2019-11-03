package com.example.bankcardfirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<BankCard> bankCards = new ArrayList<BankCard>() {{
        add(new BankCard("Danya", "1234 5678 9012 4578", 1000f, "21.02.2017", 1234));
        add(new BankCard("Vanya", "1234 5678 9012 4578", 1000f, "21.02.2017", 1234));
        add(new BankCard("Olya", "1234 5678 9012 4578", 1000f, "21.02.2017", 1234));
        add(new BankCard("Kira", "1234 5678 9012 4578", 1000f, "21.02.2017", 1234));
        add(new BankCard("Misha", "1234 5678 9012 4578", 1000f, "21.02.2017", 1234));
        add(new BankCard("Masyanya", "1234 5678 9012 4578", 1000f, "21.02.2017", 1234));
        add(new BankCard("Mikhalich", "1234 5678 9012 4578", 1000f, "21.02.2017", 1234));
        add(new BankCard("Lesha", "1234 5678 9012 4578", 1000f, "21.02.2017", 1234));
        add(new BankCard("Vitalik", "1234 5678 9012 4578", 1000f, "21.02.2017", 1234));
    }};
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvBankCard);
        recyclerView.setAdapter(new BankCardAdapter(bankCards));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public class BankCardAdapter extends RecyclerView.Adapter<BankCardAdapter.BankCardViewHolder> {
        List<BankCard> items;
        public BankCardAdapter(List<BankCard> bankCard){

            this.items = bankCard;
        }
        public class BankCardViewHolder extends RecyclerView.ViewHolder {

            TextView text1, text2, text3, text4;

            public BankCardViewHolder(@NonNull View itemView) {
                super(itemView);
                text1 = itemView.findViewById(R.id.text1);
                text2 = itemView.findViewById(R.id.text2);
                text3 = itemView.findViewById(R.id.text3);
                text4 = itemView.findViewById(R.id.text4);
            }
        }

        @NonNull
        @Override
        public BankCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list_item_4,  parent, false);
            return new BankCardViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BankCardViewHolder holder, int position) {
            BankCard bankCard = items.get(position);
            holder.text1.setText(bankCard.getOwnerName());
            holder.text2.setText(bankCard.getNum());
            holder.text3.setText(bankCard.getDate());
            holder.text4.setText(String.valueOf(bankCard.getAmount()));
        }

            @Override
        public int getItemCount() {

            return items.size();
        }
    }
}
