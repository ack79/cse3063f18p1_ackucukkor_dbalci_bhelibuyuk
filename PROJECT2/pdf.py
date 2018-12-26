from io import StringIO
from pdfminer3.pdfinterp import PDFResourceManager, PDFPageInterpreter
from pdfminer3.converter import TextConverter
from pdfminer3.layout import LAParams
from pdfminer3.pdfpage import PDFPage
import file


class Pdf:

    def __init__(self, name):
        self.fileName = name

    def getFileContent(self):
        rsrcmgr = PDFResourceManager()
        sio = StringIO()
        codec = 'utf-8'
        laparams = LAParams()
        device = TextConverter(rsrcmgr, sio, codec=codec, laparams=laparams)
        interpreter = PDFPageInterpreter(rsrcmgr, device)

        fp = open(self.fileName, 'rb')
        for page in PDFPage.get_pages(fp):
            interpreter.process_page(page)
        fp.close()

        text = sio.getvalue()

        # Cleanup
        device.close()
        sio.close()
        return text

    def getWordList(self):

        cleanWordList = list()
        string = self.getFileContent()
        string = string.lower()

        stopWords = file.File("stopwords.txt").getFileContent()
        stopWordsCount = 0

        for word in string.split():

            cleanWord = ""
            for char in word:
                if char.isalpha():
                    cleanWord = cleanWord + char


            if len(cleanWord) > 0:
                if cleanWord in stopWords:
                    stopWordsCount = stopWordsCount + 1
                else:
                    cleanWordList.append(cleanWord)

        return ' '.join(cleanWordList)
