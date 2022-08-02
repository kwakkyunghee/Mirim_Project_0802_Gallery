package kr.hs.emirim.s2117.mirim_project_0802_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] posterId = {R.drawable.wntnfghlwjs1, R.drawable.wntnfghlwjs2,R.drawable.wntnfghlwjs3,R.drawable.wntnfghlwjs4,R.drawable.wntnfghlwjs5,R.drawable.wntnfghlwjs6,R.drawable.wntnfghlwjs7,R.drawable.wntnfghlwjs8,R.drawable.wntnfghlwjs9,R.drawable.wntnfghlwjs10};
    String[] posterTitle ={"죽여버리겠어", "기수뇌동", "시부야 사변 -개문-", "회옥", "시부야 사변 -이비-", "눈부신 어둠", "주태대천", "옥절", "시부야 사변 -강령-", "시부야 사변 -벽력-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gallery gallery = findViewById(R.id.gallery);
        GalleryAdapter adapter = new GalleryAdapter(this);
        gallery.setAdapter(adapter);
    }
    public class GalleryAdapter extends BaseAdapter{
        Context context;
        public GalleryAdapter(Context context){
            this.context = context;//
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            ViewGroup.LayoutParams params = new Gallery.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setImageResource(posterId[i]);
            final int pos = i;
            imgv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView largeImgv = findViewById(R.id.imgv);
                    largeImgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    largeImgv.setImageResource(posterId[pos]);
                    Toast t = new Toast(context);
                    View toastView = View.inflate(context, R.layout.toast, null);
                    TextView textTitle = toastView.findViewById(R.id.text_title);
                    textTitle.setText(posterTitle[pos]);
                    t.setView(toastView);
                    t.setDuration(Toast.LENGTH_SHORT);
                    t.show();
                    return false;
                }
            });

            return imgv;
        }
    }
}