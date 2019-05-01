package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@RestController
public class OcrController {
	
	@RequestMapping(value="/ocr")
	public String doOcr() {
		 Tesseract tesseract = new Tesseract();
		 try {
			tesseract.setDatapath("/home/syam/Workspace/OcrSample/tessdata");
			tesseract.setHocr(true);
			String text = tesseract.doOCR(new File("/home/syam/Workspace/imagesamples/P0001.png"));
			return text;
		 } catch (TesseractException e) {		
			e.printStackTrace();
		}
		return "Hello";
	}

}
