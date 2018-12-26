class File:

    def __init__(self, fileName):
        self.fileName = fileName

    def getFileContent(self):
        file = open(self.fileName, "r")
        lines = file.readlines()

        for i in range(len(lines)):
            lines[i] = lines[i].rstrip()

        return lines

    def getWordList(self):

        cleanWordList = list()

        file = open(self.fileName, "r")
        string = file.read()
        string = string.lower()

        stopWords = File("stopwords.txt").getFileContent()
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
