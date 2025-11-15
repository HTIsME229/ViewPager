package com.example.viewpage;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {

    private static final String ARG_LAYOUT_TYPE = "layout_type";

    public static RecyclerFragment newInstance(String layoutType) {
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LAYOUT_TYPE, layoutType);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        String layoutType = getArguments() != null ? getArguments().getString(ARG_LAYOUT_TYPE) : "LINEAR";

        // 1. Tạo dữ liệu mẫu
        List<ItemData> dataList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            dataList.add(new ItemData("Mục " + i + " - Tab " + layoutType,
                    "Mô tả chi tiết của mục số " + i + ".", 0));
        }

        // 2. Thiết lập LayoutManager dựa trên tham số
        switch (layoutType) {
            case "LINEAR":
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                break;
            case "GRID":
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                break;
            case "STAGGERED":
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                break;
        }

        // 3. Thiết lập Adapter
        ItemAdapter adapter = new ItemAdapter(dataList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}