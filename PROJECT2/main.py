import file
import pdf
import docx
import urllib.request
import ssl
import frequency
import glob
import csv

from operator import itemgetter
from collections import OrderedDict

import os
from wordcloud import WordCloud

currentDirectory = os.path.dirname(__file__)

ssl._create_default_https_context = ssl._create_unverified_context

# getting pdf urls from file
fileContent = file.File("urls.txt").getFileContent()

#saving pdfs from internet
i = 1
for url in fileContent:
    urllib.request.urlretrieve(url, "source/" +str(i)+".pdf")
    i += 1

corpus = list()
for source in glob.glob("source/*.pdf"):
    corpus.append(pdf.Pdf(source).getWordList())

for source in glob.glob("source/*.docx"):
    corpus.append(docx.Docx(source).getWordList())

for source in glob.glob("source/*.txt"):
    corpus.append(file.File(source).getWordList())


frequency = frequency.Frequency(corpus)


with open('result/tfidf_list.csv', 'w+') as csvFile:

    writer = csv.writer(csvFile)

    for key, value in OrderedDict(sorted(frequency.idf().items(), key=itemgetter(1), reverse=True)).items():
        writer.writerow([key, value])

freqDic = {}
with open('result/tf_list.csv', 'w+') as csvFile2:

    writer = csv.writer(csvFile2)

    for word in frequency.termFrequency():
       writer.writerow([word[0], word[1]])
       freqDic[word[0]] = word[1]


cloud = WordCloud(background_color="white", width=750, height=750, max_words=50)
cloud.generate_from_frequencies(frequency.idf())
cloud.to_file(os.path.join(currentDirectory, "result/tfidf_wordCloud.pdf"))

cloud.generate_from_frequencies(freqDic)
cloud.to_file(os.path.join(currentDirectory, "result/tf_wordCloud.pdf"))
