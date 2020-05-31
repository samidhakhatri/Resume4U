package com.example.pdf3;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.pdf.PdfDocument;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;



public class MainActivity extends AppCompatActivity {


    private  static final int STORAGE_CODE=1000;
    EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16,et17,et18,et19,et20;
    Button mSaveBtn;

    ImageView viewImage;
    Button b;
    boolean t=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer song;
        song=MediaPlayer.create(MainActivity.this,R.raw.song);
        song.setLooping(true);
        song.start();




        b = (Button) findViewById(R.id.btnSelectPhoto);
        viewImage = (ImageView) findViewById(R.id.viewImage);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        et1=findViewById(R.id.name);
        et2=findViewById(R.id.email);
        et3=findViewById(R.id.phone);
        et4=findViewById(R.id.t11);
        et5=findViewById(R.id.t12);
        et6=findViewById(R.id.t21);
        et7=findViewById(R.id.t22);
        et8=findViewById(R.id.t31);
        et9=findViewById(R.id.t32);
        et10=findViewById(R.id.t41);
        et11=findViewById(R.id.t42);
        et12=findViewById(R.id.t51);
        et13=findViewById(R.id.t52);
        et14=findViewById(R.id.skills);
        et15=findViewById(R.id.experience);
        et16=findViewById(R.id.awards);





        mSaveBtn=findViewById(R.id.saveBtn);

        mSaveBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){




                if(Build.VERSION.SDK_INT>Build.VERSION_CODES.M) {

                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_GRANTED) {

                        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permissions, STORAGE_CODE);
                    }

                    else {
                        savePdf();
                    }

                }

                else {
                    savePdf();
                }

                }


        });

    }

    private void savePdf(){

        Document mDoc=new Document();

        String mFileName=new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(System.currentTimeMillis());

        String mFilePath= Environment.getExternalStorageDirectory() +"/Docs/PDF/"+mFileName+".pdf";

        try{

            PdfWriter.getInstance(mDoc,new FileOutputStream(mFilePath));

            mDoc.open();

            String mText1=et1.getText().toString();
            String mText2=et2.getText().toString();
            String mText3=et3.getText().toString();
            String mText4=et4.getText().toString();
            String mText5=et5.getText().toString();
            String mText6=et6.getText().toString();
            String mText7=et7.getText().toString();
            String mText8=et8.getText().toString();
            String mText9=et9.getText().toString();
            String mText10=et10.getText().toString();
            String mText11=et11.getText().toString();
            String mText12=et12.getText().toString();
            String mText13=et13.getText().toString();
            String mText14=et14.getText().toString();
            String mText15=et15.getText().toString();
            String mText16=et16.getText().toString();



            mDoc.addAuthor("Samidha");

            float fntsize=20.7f;
            PdfPTable pdfPTable = new PdfPTable(3);

            //Create cells
            PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Education",FontFactory.getFont(FontFactory.TIMES_BOLD,fntsize)));
            PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Institution",FontFactory.getFont(FontFactory.TIMES_BOLD,fntsize)));
            PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Percentage/cgpa",FontFactory.getFont(FontFactory.TIMES_BOLD,fntsize)));

            pdfPTable.addCell(pdfPCell1);
            pdfPTable.addCell(pdfPCell2);
            pdfPTable.addCell(pdfPCell3);

            if(!mText4.isEmpty()) {
                PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("Class X", FontFactory.getFont(FontFactory.TIMES_BOLD, fntsize)));

                PdfPCell pdfPCell5 = new PdfPCell(new Paragraph(mText4, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
                PdfPCell pdfPCell6 = new PdfPCell(new Paragraph(mText5, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
                pdfPTable.addCell(pdfPCell4);
                pdfPTable.addCell(pdfPCell5);
                pdfPTable.addCell(pdfPCell6);

            }

            if(!mText6.isEmpty()) {


                PdfPCell pdfPCell7 = new PdfPCell(new Paragraph("Class XII", FontFactory.getFont(FontFactory.TIMES_BOLD, fntsize)));
                PdfPCell pdfPCell8 = new PdfPCell(new Paragraph(mText6, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
                PdfPCell pdfPCell9 = new PdfPCell(new Paragraph(mText7, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));

                pdfPTable.addCell(pdfPCell7);
                pdfPTable.addCell(pdfPCell8);
                pdfPTable.addCell(pdfPCell9);
            }

            if(!mText8.isEmpty()) {
                PdfPCell pdfPCell10 = new PdfPCell(new Paragraph("Bachelor's", FontFactory.getFont(FontFactory.TIMES_BOLD, fntsize)));
                PdfPCell pdfPCell11 = new PdfPCell(new Paragraph(mText8, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
                PdfPCell pdfPCell12 = new PdfPCell(new Paragraph(mText9, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));


                pdfPTable.addCell(pdfPCell10);
                pdfPTable.addCell(pdfPCell11);
                pdfPTable.addCell(pdfPCell12);
            }

            if(!mText10.isEmpty()) {
                PdfPCell pdfPCell13 = new PdfPCell(new Paragraph("Master's", FontFactory.getFont(FontFactory.TIMES_BOLD, fntsize)));
                PdfPCell pdfPCell14 = new PdfPCell(new Paragraph(mText10, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
                PdfPCell pdfPCell15 = new PdfPCell(new Paragraph(mText11, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));

                pdfPTable.addCell(pdfPCell13);
                pdfPTable.addCell(pdfPCell14);
                pdfPTable.addCell(pdfPCell15);
            }

            if(!mText12.isEmpty()) {
                PdfPCell pdfPCell16 = new PdfPCell(new Paragraph("Phd.", FontFactory.getFont(FontFactory.TIMES_BOLD, fntsize)));
                PdfPCell pdfPCell17 = new PdfPCell(new Paragraph(mText12, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
                PdfPCell pdfPCell18 = new PdfPCell(new Paragraph(mText13, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));


                pdfPTable.addCell(pdfPCell16);
                pdfPTable.addCell(pdfPCell17);
                pdfPTable.addCell(pdfPCell18);
            }








            float a= mDoc.getPageSize().getWidth();
            float b=mDoc.getPageSize().getHeight();


            Rectangle rect1= new Rectangle(20,20,a-20,b-20);

            rect1.setBorder(Rectangle.BOX);
            rect1.setBorderWidth(5);
            rect1.setBorderColor(BaseColor.BLUE);

            mDoc.add(rect1);

            Rectangle rect2= new Rectangle(30,30,a-30,b-30);

            rect2.setBorder(Rectangle.BOX);
            rect2.setBorderWidth(2);
            rect2.setBorderColor(BaseColor.BLUE);
            mDoc.add(rect2);


            if(t==true ) {
                ImageView imageView = (ImageView) findViewById(R.id.viewImage);

                Bitmap image = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

                ByteArrayOutputStream stream3 = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.PNG, 100, stream3);
                Image img = Image.getInstance(stream3.toByteArray());

                img.scaleToFit(50f, 50f);

                mDoc.add(img);
            }


            if(!mText1.isEmpty()) {

                mDoc.add(new Paragraph("\nNAME:  ", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, fntsize)));
                mDoc.add(new Chunk(mText1, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
            }

            if(!mText2.isEmpty()) {
                mDoc.add(new Paragraph("EMAIL-ID:  ", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, fntsize)));
                mDoc.add(new Chunk(mText2, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
            }
            if(!mText3.isEmpty()) {
                mDoc.add(new Paragraph("PHONE NO:  ", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, fntsize)));
                mDoc.add(new Chunk(mText3, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
            }
            if(!mText1.isEmpty()) {
                mDoc.add(new Paragraph("\nQUALIFICATIONS\n\n", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, fntsize)));
                mDoc.add(pdfPTable);
            }

            if(!mText14.isEmpty()) {

                mDoc.add(new Paragraph("\n\nSKILLS\n", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, fntsize)));
                mDoc.add(new Chunk(mText14, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
            }
            if(!mText15.isEmpty()) {
                mDoc.add(new Paragraph("\n\nEXPERIENCE\n", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, fntsize)));
                mDoc.add(new Chunk(mText15, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
            }
            if(!mText16.isEmpty()) {
                mDoc.add(new Paragraph("\n\nAWARDS\n", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, fntsize)));
                mDoc.add(new Chunk(mText16, FontFactory.getFont(FontFactory.TIMES_ROMAN, fntsize)));
            }



            mDoc.close();

            Toast.makeText(this,mFileName+".pdf\nis saved to\n"+ mFilePath,Toast.LENGTH_SHORT).show();

        }
        catch(Exception e){

            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults ){


        switch(requestCode){
            case STORAGE_CODE:
                if(grantResults.length>0&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    savePdf();

                }

                else{
                    Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
                }
        }

    }

    private void selectImage() {
        final CharSequence[] options = { "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                 if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {


            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {


                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);
                    viewImage.setImageBitmap(bitmap);
                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
    Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Log.w("Image Path:", picturePath + "");
                viewImage.setImageBitmap(thumbnail);
                viewImage.setBackground(null);

                t=true;
}
        }
                }

}
