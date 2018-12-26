import docx2txt
import file

class Docx:

    def __init__(self, name):
        self.fileName = name

    def getFileContent(self):
        text = docx2txt.process(self.fileName)
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

