pdf watermarking with text
==========================

little code for watermarking on the pdf file.


Compile
=======
javac -cp itextpdf-5.5.13.jar watermark.java

Usage
====
java -cp itextpdf-5.5.13.jar:./ watermark source.pdf target.pdf bottommargin "licensed user"

Fonts
=====
NanumGothic : http://hangeul.naver.com/download.nhn
Times : http://www.microsoft.com/typography/fonts/font.aspx?FMID=1653

Library
=======
iTextPDF : http://sourceforge.net/projects/itext/

Korean
======
한글로 PDF에 워터마킹 하는 코드를 찾기가 힘들었다. 검색을 해서, 코드로 정리했다.
