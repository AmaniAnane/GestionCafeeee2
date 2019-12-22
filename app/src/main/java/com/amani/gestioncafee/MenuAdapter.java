package com.amani.gestioncafee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ContactViewHolder>{

    List<Menu> listeMenu;



    public MenuAdapter(List<Menu> listeIngredient) {
        this.listeMenu = listeIngredient;
    }

    @Override
    public MenuAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem, parent, false);

        MenuAdapter.ContactViewHolder contactViewHolder = new MenuAdapter.ContactViewHolder(view);

        return contactViewHolder;
    }



    @Override
    public void onBindViewHolder(MenuAdapter.ContactViewHolder holder, int position) {
        Menu menu = listeMenu.get(position);
        holder.titre.setText(menu.getNom());
        holder.prix.setText(menu.getPrix());
        holder.imageView.setImageResource(menu.getImage());


    }

    @Override
    public int getItemCount() {
        return listeMenu.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView titre;
        TextView prix;
        ImageView imageView;
        public ContactViewHolder(View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.titre);
            prix = itemView.findViewById(R.id.prix);
            imageView=itemView.findViewById(R.id.item_image);

        }






    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position, String id);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        // mItemClickListener;
    }








}