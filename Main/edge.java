//import org.tess4j.*;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
//import org.opencv.highgui.Highgui;
//import java.awt.List;
//import java.util.ArrayList;
import org.opencv.*;
import org.opencv.core.*;
//import org.opencv.core.MatOfPoint;
import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;

public class edge {

	public static void main(String[] args){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String cname;
      //  cname=new String();
        System.out.println("enter name");
        Scanner sc=new Scanner(System.in);
        cname=sc.next();
        
        Mat color=Imgcodecs.imread("F:/EclipPref/FirstFProj/lib/images/"+cname+".png");
        System.out.println(color);
        Mat gray=new Mat();
        Mat wide=new Mat();
        Mat draw=new Mat();

        Mat erode = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5,5));
        Mat dilate = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5,5));
      //  Mat dest=new Mat();

        Imgproc.cvtColor(color, gray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.GaussianBlur(gray, gray,new Size(5,5),0);
        //Imgproc.GaussianBlur(gray, gray,new Size(5,5),0);
        Imgproc.erode(gray, draw, erode);
        Imgproc.erode(gray, draw, erode);

        Imgproc.dilate(gray, draw, dilate);
        Imgproc.dilate(gray, draw, dilate);

        Imgproc.Canny(gray, wide, 50,100,3,false);
        wide.convertTo(draw, CvType.CV_8U);
        if(Imgcodecs.imwrite("F:/EclipPref/FirstFProj/lib/images/2.png",draw));
        	System.out.print("found");
        	
        List<MatOfPoint>contours = new ArrayList<>();
        
    //    Mat dest = Mat.zeros(draw.size(), CvType.CV_8UC3);
        Scalar white = new Scalar(255, 255, 255);

        	// Find contours
        Imgproc.findContours(draw, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        	// Draw contours in dest Mat
        Imgproc.drawContours(wide, contours, -1, white);
        Scalar green = new Scalar(81, 190, 0);
        int i=4;
        for (MatOfPoint contour: contours) {
        	System.out.println(Imgproc.contourArea(contour));
        	if(((Imgproc.contourArea(contour)>18)&&((Imgproc.contourArea(contour)<300))))
        			{ //RotatedRect rotatedRect = Imgproc.minAreaRect(new MatOfPoint2f(contour.toArray()));
            //drawRotatedRect(color, rotatedRect, green, 2);
            Rect rect = Imgproc.boundingRect(contour);
            Imgproc.rectangle(color, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,255));
            Mat ROI = color.submat(rect.y, rect.y + rect.height, rect.x, rect.x + rect.width);System.out.println("i ==="+Imgproc.contourArea(contour));
            i++;
            Imgcodecs.imwrite("F:/EclipPref/FirstFProj/lib/images/"+cname+"_"+i+".png",ROI);
            
        }}
        Imgcodecs.imwrite("F:/EclipPref/FirstFProj/lib/images/3.png",color);
     //   Point[] vertices = new Point[4];
	    //Rect rect=rotatedRect.points(vertices);
	    //dest=draw.submat(rect);
        
        //calling tesseract
      //  String imgname[] = new String[--i];
     //   for(int j=5;j<i;j++) {
       // 	imgname[j]=""+j+".png";
         //   System.out.println("$$$"+i+"$$$"+j);
        //}
        Qw q = new Qw();
        while(i>4) {
        	q.man(i,cname);
        	i--;
        }
        //q.man(imgname);
        
	    
	}
	public static void drawRotatedRect(Mat image, RotatedRect rotatedRect, Scalar color, int thickness) {
	    Point[] vertices = new Point[4];
	    rotatedRect.points(vertices);
	    MatOfPoint points = new MatOfPoint(vertices);
	    Imgproc.drawContours(image, Arrays.asList(points), -1, color, thickness);
	}
}