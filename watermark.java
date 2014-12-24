/**
* Watermark in text
* requires itextpdf-5.4.3.jar
* @author jaypark@gmail.com 2014.12.24 (yes it's christmas)
*/
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.ColumnText;


public class watermark {
	//static String FONTFILE = "./NanumGothic.ttf";
	//static String LIC = "이 문서는 %s님께 사용이 허가된 문서입니다.";
	static String FONTFILE = "./times.ttf";
	static String LIC = "This document is licensed to %s.";

	public static void main(String[] args) {
		try {
			PdfReader reader = new PdfReader(args[0]);
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(args[1]));
			stamp.getWriter().setCompressionLevel(9);

			String lic = String.format(LIC, args[2]);

			BaseFont bf = BaseFont.createFont(FONTFILE, BaseFont.IDENTITY_H , BaseFont.EMBEDDED);
			Chunk c = new Chunk(lic, new Font(bf, 7, Font.NORMAL,new BaseColor(110, 110, 110)));
			c.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE, 1/800f, null);

			Phrase phrase = new Phrase(c);

			int pages = reader.getNumberOfPages();
			int xpos = 90;
			for (int i = 1; i <= pages; i++) { 
				if(i %2==0)	xpos = 160;
				else 				xpos = 90;

				PdfContentByte under = stamp.getUnderContent(i); 
				ColumnText.showTextAligned(under, Element.ALIGN_LEFT, phrase, xpos, 15, -0);

			} 
			stamp.setFullCompression();
			stamp.close();
		}
		catch (Exception e) {
				e.printStackTrace();
		}
	}
}

