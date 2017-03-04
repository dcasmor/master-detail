package com.example.dcasm.daniel_castro_maestrodetalle.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyContent {

    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static void rellenar(ArrayList<DummyItem> arrayList) {
        ITEMS.clear();
        ITEM_MAP.clear();
        for (int i=0; i<arrayList.size(); i++)
            addItem(new DummyItem(
                    arrayList.get(i).getId(),
                    arrayList.get(i).getSerie(),
                    arrayList.get(i).getModelo(),
                    arrayList.get(i).getFoto()));
    }

    public static class DummyItem {
        public final String id, serie, modelo, foto;

        public DummyItem(String id, String serie, String modelo, String foto) {
            this.id = id;
            this.serie = serie;
            this.modelo = modelo;
            this.foto = foto;
        }

        public String getId() {
            return id;
        }

        public String getSerie() {
            return serie;
        }

        public String getModelo() {
            return modelo;
        }

        public String getFoto() {
            return foto;
        }
    }
}
