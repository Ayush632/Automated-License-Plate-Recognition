import java.sql.*;
import java.io.File;

import net.sourceforge.tess4j.*;

class Qw {
	public void man(int i,String cname) {
		File imageFile /*new File("F:/EclipPref/FirstFProj/lib/images/"+cname+"_"+i+".png")*/;
		ITesseract ins = new Tesseract();
		ins.setDatapath("F:\\OpenCVJava\\Tess4J\\tessdata");
		ins.setTessVariable("tessedit_char_whitelist", "0123456789abcdefghijklmnopqrstuvwxyz");
		try {
			
		//	for(int i = 0;i<args.length;i++) {
			imageFile = new File("F:/EclipPref/FirstFProj/lib/images/"+cname+"_"+i+".png");
			String path="F:/EclipPref/FirstFProj/lib/images/"+cname+"_"+i+".png";
			//System.out.println(imageFile.getName());
			String result = ins.doOCR(imageFile);
		//	System.out.println(result+"\n***********************************************************");
			MSQ adder = new MSQ();
			if(result.length()>5) {
				if(result.length()>10)
				adder.addI(cname,i,path,result.substring(0,10));
				else
					adder.addI(cname,i,path,result);
					
			}
			else
				imageFile.delete();
	//		}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}